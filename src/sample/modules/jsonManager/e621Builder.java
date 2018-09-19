package sample.modules.jsonManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sample.modules.fileManager.FileManager;
import sample.modules.fileManager.FileProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class e621Builder {

    private String ticketURL = "https://e621.net/post/index.json";
    private static String urlForPageLength = "https://e621.net/post";
    private String tags = "?tags=";
    private int score;
    private String rating;
    private String limit = "&limit=320";
    private String page = "&page=";
    private FileManager userDataFile = new FileManager("user.json");
    private FileManager imageDownloadLog = new FileManager("imageDownloadLog.txt");
    private User userData = new User(userDataFile);
    private ArrayList<String> blackListedTags = new ArrayList<>();
    private TreeMap<String, String> keptImages = new TreeMap<>();
    private ArrayList<String> added = new ArrayList<>();
    private Document doc;
    private int pageLimit = 0;


    public e621Builder(){
        String str = userData.fetchUserInfo(User.BLACKLISTED_TAGS).replaceAll("\\[|]|\"","");
        blackListedTags.addAll(Arrays.asList(str.split(",")));
        added.addAll(Arrays.asList(imageDownloadLog.readFromFile(FileProperties.string.STRING).split(",")));
        added.forEach(s -> System.out.println(s));
    }

    public void addTag(String tag){
        if(tag.contains(",")){
            List<String> listOfTags = Arrays.asList(tag.split(","));
            addTag(listOfTags);
        }else{
            if(tags.equals("?tags=")) {
                tags = tags + tag;
            }else{
                tags = tags + "+" + tag;
            }
        }
    }

    public void addTag(List<String> listOfTags){
        StringBuilder sb = new StringBuilder();
        listOfTags.forEach(str -> sb.append(str + "+"));
        sb.replace(sb.length(), sb.length(), "");
        this.tags = tags + sb.toString();
    }

    public void setLimit(int limit) {
        this.limit = "&limit=" + limit;
    }

    public void setPage(String page) {
        this.page = "&page=" + page;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    private void setPageLimit(){
        try {
            this.doc = Jsoup.connect(urlForPageLength + tags + page + limit).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements pagination = doc.getElementById("paginator").getAllElements();
        this.pageLimit = Integer.parseInt(pagination.get(pagination.size()-2).text());
    }

    public int getPageLimit() {
        return pageLimit;
    }

    private void connectToDocument(int pageNumber){
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println(pageLimit);
        System.out.println(urlForPageLength + tags + page + limit);
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        page = "&page=" + pageNumber;
        try {
            this.doc = Jsoup.connect(ticketURL + tags + page + limit).userAgent("Rivfur e621 Image downloading app (Cotton le sergal)").ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements json = doc.select("body");
        handleJSON(json.get(0).text());
    }

    private void handleJSON(String text) {
        JSONParser parser = new JSONParser();
        JSONArray userJson = null;
        JSONObject nextObject;
        try {
            userJson = (JSONArray) parser.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int size = userJson.size();
        for(int index = 0; index < size; index++){
            AtomicBoolean inList = new AtomicBoolean(false);
            nextObject = (JSONObject) userJson.get(index);
            String tagsFromObjectAsString = (String) nextObject.get("tags");
            ArrayList<String> tagsFromObjectAsArray = new ArrayList<>(Arrays.asList(tagsFromObjectAsString.split(" ")));
            if(checkBlackList(tagsFromObjectAsArray) && (score < (int) (long) nextObject.get("score")) && (rating.equals(nextObject.get("rating")) || nextObject.get("rating").equals("q"))){
                JSONArray artistJsonArray = (JSONArray) nextObject.get("artist");
                String author = artistJsonArray.toJSONString();
                String imageName = author.replaceAll("[^\\p{L}\\p{Z}]","");
                String fileUrl = (String) nextObject.get("file_url");
                imageName += fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
                for (String s : added) {
                    if (s.contains(fileUrl)) {
                        inList.set(true);
                        System.out.println(fileUrl + " is in the list of downloaded images");
                        break;
                    } else {

                    }
                }
                if(!inList.get()){
                    added.add(fileUrl);
                    keptImages.put(fileUrl, imageName);
                }else{
                    System.out.println("Duplicates");
                }
            }
        }
    }

    private boolean checkBlackList(ArrayList<String> tagsFromObjectAsArray) {
        for(String newTag : tagsFromObjectAsArray){
            if(blackListedTags.contains(newTag)){
                return false;
            }
        }
        return true;
    }

    public void queueAndCacheImages(){
        setPageLimit();
        for(int index = 0; index < pageLimit; index++){
            connectToDocument(index);
        }
    }

    public void downloadImages(){

    }

    public TreeMap<String, String> fetchCachedImages() {
        return this.keptImages;
    }
}
