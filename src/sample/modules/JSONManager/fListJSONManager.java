package sample.modules.JSONManager;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

public class fListJSONManager {
    private static final String ticketUrl = "https://www.f-list.net/json/getApiTicket.php";
    private static final String characterDataUrl = "https://www.f-list.net/json/api/character-data.php";
    private static final String mappingDataUrl = "https://www.f-list.net/json/api/mapping-list.php";
    private static ArrayList<String> kinkId = new ArrayList<>();
    private static HashMap<Integer, String> kinkName = new HashMap<>();
    private static ArrayList<String> kinkLike = new ArrayList<>();
    private static String account = "AprilLeSerg";
    private static String password = "KBHSkbhs!!8199";
    private static String ticket = "";
    private static String testName1 = "DrVenustus";
    private static String testName2 = "ArilLeSerg";
    private static String name = "";
    private static String kinks;
    private static JSONArray kinkMappedData;
    private static JSONParser parser = new JSONParser();

    public fListJSONManager() {

    }

    public static void main(String args[]) {
        /*System.out.println("Please enter a character name.");
        Scanner scan = new Scanner(System.in);
        setCharacterName(scan.nextLine());
        int status = fetchFListCharacterData(getCharacterName());
        switch (status){
            case 0 : {
                //successful
                organizeKinks();
                fListGetKinkByCategory(getCharacterName(),"like", new ArrayList<>(Arrays.asList("fave","yes","maybe","no")));
            }
            break;
            case 1 : {
                //no character found
                System.out.println("Character name is empty. Please enter a character name.");
            }
            break;
            case 2 : {
                //character does not exist
                System.out.println("No character with the name of: " + name + ". Please enter a valid character name.");
            }
            break;
        }*/

    }

    private static JSONObject returnJsonObjectAsString(String url, HashMap<String, Object> hash) {
        String returned;
        Object result = null;
        try {
            returned = Unirest.post(url).fields(hash).asJson().getBody().toString();
            //System.out.println(returned);
            result = parser.parse(returned);
        } catch (UnirestException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) result;
        return jsonObject;
    }

    private static String getCharacterName() {
        return name;
    }

    private static void setCharacterName(String Name) {
        name = Name;
    }

    private static int fetchFListCharacterData(String characterName) {
        try {
            LinkedHashMap<String, Object> ticketFieldRequest = new LinkedHashMap<>() {{
                put("account", account);
                put("password", password);
            }};
            ticket = returnJsonObjectAsString(ticketUrl, ticketFieldRequest).get("ticket").toString();
            //System.out.println(ticket);

            LinkedHashMap<String, Object> userKinkFieldRequest = new LinkedHashMap<>() {{
                put("account", account);
                put("ticket", ticket);
                put("name", name);
            }};
            kinks = returnJsonObjectAsString(characterDataUrl, userKinkFieldRequest).get("kinks").toString();
            //System.out.println(kinks);
            kinkMappedData = (JSONArray) returnJsonObjectAsString(mappingDataUrl, userKinkFieldRequest).get("kinks");
            //System.out.println(kinkMappedData);
        } catch (NullPointerException e) {
            if (name.isEmpty()) {
                return 1;
            } else {

                return 2;
            }
        }
        return 0;
    }

    private static void organizeKinks() {
        try {
            if (kinkId.size() == 0) {
                Object newResult = parser.parse(kinks);
                JSONObject kinkIterator = (JSONObject) newResult;
                Iterator kink = kinkIterator.entrySet().iterator();
                while (kink.hasNext()) {
                    Map.Entry pair = (Map.Entry) kink.next();
                    kinkId.add((String) pair.getKey());
                    kinkLike.add((String) pair.getValue());
                }
            }
            Iterator<JSONObject> iterator = kinkMappedData.iterator();
            while (iterator.hasNext()) {
                JSONObject obj = iterator.next();
                Object id = obj.get("id");
                Object kinkName_ = obj.get("name");
                for (int index = 0; index < kinkId.size(); index++) {
                    //System.out.println((id.toString() + "==" + kinkId.get(index)) + (id.toString().equals( kinkId.get(index))));
                    if (id.toString().equals(kinkId.get(index))) {
                        //System.out.println("adding: " + kinkName_);
                        kinkName.put(index, (String) kinkName_);
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    private static void fListGetKinkByCategory(String characerName, String category, ArrayList<String> modification) {
        switch (category) {
            case "like": {
                for (String modifier : modification) {
                    for (int index = 0; index < kinkId.size(); index++) {
                        if (kinkLike.get(index).equals(modifier)) {
                            System.out.print(kinkId.get(index) + ",");
                            System.out.print(kinkName.values().toArray()[index] + ",");
                            System.out.print(kinkLike.get(index));
                            System.out.println();
                        }
                    }
                }
            }
            break;
            /*case "id" : {
                switch (modification){
                    case "asc" : {

                    }
                    break;
                    case "des" : {

                    }
                    break;
                }
            }*/
        }
    }

    //private static void e6GetImageByCategory(String category, HashMap<String, >)
}
