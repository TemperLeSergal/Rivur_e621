package sample.modules.JSONManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sample.modules.FileManager.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class e621JSONManager {
    public String ticketURL = "https://e621.net/post/index.json";
    public String tags = "?tags=";
    public int score;
    public String rating;
    public String limit = "&limit=100";
    public String page = "&page=";
    FileManager userDataFile = new FileManager("sample/media/files/json/userData.json");
    userJSONManager userData = new userJSONManager(userDataFile.getFile());
    ArrayList<String> blackListedTags = new ArrayList<>();
    TreeMap<String, String> keptImages = new TreeMap<>();
    ArrayList<String> added = new ArrayList<>();
    Document doc;

    public e621JSONManager(int score_, String rating_) {
        //score = score_;
        //rating = rating_;

    }

    public void fetchAndCacheAllImages() {
        setBlacklist();
        int count = 0;
        do {
            count++;
            connectToDocument(count);
            Elements json = doc.select("body");
            if (json.get(0).text().charAt(1) == ']') {
                break;
            } else {
                handleJSON(json.get(0).text());
            }
        } while (true);

    }

    public TreeMap<String, String> fetchCachedImages() {
        return keptImages;
    }

    private void handleJSON(String text) {
        String returnable = "";
        JSONParser parser = new JSONParser();
        JSONArray userJson = null;
        JSONObject nextObject = null;
        try {
            userJson = (JSONArray) parser.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int size = userJson.size();
        for (int index = 0; index < size; index++) {
            nextObject = (JSONObject) userJson.get(index);
            String tagsFromObjectAsString = (String) nextObject.get("tags");
            ArrayList<String> tagsFromObjectAsArray = new ArrayList<>(Arrays.asList(tagsFromObjectAsString.split(" ")));
            if (checkBlackList(tagsFromObjectAsArray) && (score < (int) (long) nextObject.get("score"))) {
                String author = (String) nextObject.get("author");
                String blep = author.replaceAll("[^\\p{L}\\p{Z}]", "");
                String imageName = blep + "_";
                String fileUrl = (String) nextObject.get("file_url");
                imageName += fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
                /*if(keptImages.keySet().contains(fileUrl) || keptImages.containsValue(imageName)){

                }else{
                    keptImages.put(fileUrl, imageName);
                }*/
                if (!added.contains(fileUrl)) {
                    added.add(fileUrl);
                    keptImages.put(fileUrl, imageName);
                } else {
                }
            }
        }
    }

    private boolean checkBlackList(ArrayList<String> tagsFromObjectAsArray) {
        for (String newTag : tagsFromObjectAsArray) {
            if (blackListedTags.contains(newTag)) {
                return false;
            }
        }
        return true;
    }

    public void setTags(String tags_) {
        tags += tags_;
    }

    public void setBlacklist() {
        String str = userData.fetchInfo("blacklist").replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        blackListedTags.addAll(Arrays.asList(str.split(",")));
    }

    private void connectToDocument(int page_) {
        page = ("&page=" + page_);
        try {
            doc = Jsoup.connect(ticketURL + tags + page + limit).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
