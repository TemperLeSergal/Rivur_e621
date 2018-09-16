package sample.modules.jsonManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.modules.fileManager.FileManager;
import sample.modules.fileManager.FileProperties;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class User {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String IS_REMEMBERED = "rememberMe";
    public static final String BLACKLISTED_TAGS = "blacklist";
    public static final String BLACKLIST_P_1_TAGS = "blacklistP1";
    public static final String WHITELIST_P_1_TAGS = "whitelistP1";
    public static final String SCORE = "score";
    public static final String IMAGE_SAVE_LOCATION = "imageSaveLocation";
    public static final String IS_NSFW_ALLOWED = "allowNSFW";
    public static final String IS_BLACKLIST_ALLOWED = "allowBlacklist";
    public static final String JSON_PROFILE_SETTINGS = "profileSettings";
    public static final String JSON_E621_SETTINGS = "e621Settings";
    private FileManager userFileManager;
    private String defFileSavePath;
    final HashMap<String, String> userMap = new HashMap<>() {{
        put(USERNAME, JSON_PROFILE_SETTINGS);
        put(PASSWORD, JSON_PROFILE_SETTINGS);
        put(IS_REMEMBERED, JSON_PROFILE_SETTINGS);
        put(BLACKLISTED_TAGS, JSON_E621_SETTINGS);
        put(BLACKLIST_P_1_TAGS, JSON_E621_SETTINGS);
        put(WHITELIST_P_1_TAGS, JSON_E621_SETTINGS);
        put(SCORE, JSON_E621_SETTINGS);
        put(IMAGE_SAVE_LOCATION, JSON_E621_SETTINGS);
        put(IS_NSFW_ALLOWED, JSON_E621_SETTINGS);
        put(IS_BLACKLIST_ALLOWED, JSON_E621_SETTINGS);
    }};
    String userJsonFile;
    JSONParser parser = new JSONParser();
    private JSONObject userJson = null;
    public User(FileManager fm){
        userFileManager = fm;
        defFileSavePath = fm.getDefFilePath();
        userJsonFile = defFileSavePath + "src\\sample\\media\\files\\json\\user.json";
    }

    public String fetchUserInfo(String key) {
        String returnable;
        Object object;
        try {
            userJson = (JSONObject) parser.parse(userFileManager.readFromFile(FileProperties.string.STRING));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        object = getKey(key);
        if (object instanceof JSONArray) {
            returnable = object.toString();
        } else if (object instanceof Boolean) {
            returnable = String.valueOf(object);
        } else {
            returnable = (String) object;
        }
        return returnable;
    }

    public void setValue(String key, Object value) {
        Object Key;
        try {
            userJson = (JSONObject) parser.parse(userFileManager.readFromFile(FileProperties.string.STRING));
            Key = getKey(key);
            if (value instanceof Collection) {
                JSONArray edit = (JSONArray) Key;
                edit.addAll((Collection) value);
            } else if (value instanceof String) {
                JSONObject edit = (JSONObject) Key;
                edit.put(key, value);
            } else {
                JSONObject edit = (JSONObject) Key;
                edit.put(key, value);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Object getKey(String key) {
        Object returnable = null;
        JSONObject e621Settings = (JSONObject) userJson.get("e621Settings");
        JSONObject profileSettings = (JSONObject) userJson.get("profileSettings");
        switch (userMap.get(key)) {
            case JSON_E621_SETTINGS: {
                returnable = e621Settings.get(key);
            }
            break;
            case JSON_PROFILE_SETTINGS: {
                returnable = profileSettings.get(key);
            }
            break;
        }
        return returnable;
    }

    public void remBlacklist(String tags) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(userFileManager.readFromFile(FileProperties.string.STRING));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject e621Settings = (JSONObject) userJson.get("e621Settings");
        JSONArray blacklists = (JSONArray) e621Settings.get("blacklist");
        blacklists.removeAll(Arrays.asList(tags.split(",")));
        saveJsonToFile(userJson.toJSONString());
    }

    public void saveJsonToFile(String contents) {
        try {
            PrintStream out = new PrintStream(userFileManager.getFile());
            out.println(contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
