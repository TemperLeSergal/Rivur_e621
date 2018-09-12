package sample.modules.JSONManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.modules.FileManager.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class userJSONManager {
    public String templateFilePath = "JSONTemplate.txt";
    JSONObject userJson = null;
    private File file = null;

    public userJSONManager(String path) {
        file = new File(path);
        FileManager fileManager = new FileManager(path);
        fileManager.getFileContentsToConsole();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public userJSONManager(File file_) {
        file = file_;
        FileManager fileManager = new FileManager(file_.getPath());
        fileManager.getFileContentsToConsole();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signup(String username, String password, FileManager userData) {
        if (userData == null || userData.isEmpty()) {
            JSONParser parser = new JSONParser();

            try {
                userJson = (JSONObject) parser.parse(new FileManager(templateFilePath).getFileContentsAsString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject profileSettings = (JSONObject) userJson.get("profileSettings");
            profileSettings.put("username", username);
            profileSettings.put("password", password);
            saveJsonToFile(userJson.toJSONString());
        } else {
            JSONObject profileSettings = (JSONObject) userJson.get("profileSettings");
            profileSettings.put("username", username);
            profileSettings.put("password", password);
        }
    }

    public String fetchInfo(String fetch) {
        String returnable = "";
        JSONParser parser = new JSONParser();

        try {
            userJson = (JSONObject) parser.parse(new FileManager(file.getPath()).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject profileSettings = (JSONObject) userJson.get("profileSettings");
        JSONObject discordSettings = (JSONObject) userJson.get("discordSettings");
        JSONObject e621Settings = (JSONObject) userJson.get("e621Settings");
        switch (fetch.toLowerCase()) {

            case "username": {
                returnable = (String) profileSettings.get("username");
            }
            break;
            case "password": {
                returnable = (String) profileSettings.get("password");
            }
            break;
            case "rememberme": {
                returnable = String.valueOf(profileSettings.get("rememberMe"));
            }
            break;
            case "blacklist": {
                JSONArray blacklists = (JSONArray) e621Settings.get("blacklist");
                returnable = blacklists.toString();
            }
            break;
            case "score": {
                returnable = String.valueOf(e621Settings.get("score"));
            }
            break;
            case "imagesavelocation": {
                returnable = String.valueOf(e621Settings.get("imageSaveLocation"));
            }
            break;
            case "isnsfw": {
                returnable = String.valueOf(e621Settings.get("allowNSFW"));
            }
            break;
            case "isblacklist": {
                returnable = String.valueOf(e621Settings.get("useBlacklist"));
            }
            break;
        }
        return returnable;
    }

    public void saveJsonToFile(String contents) {
        try {
            PrintStream out = new PrintStream(file);
            out.println(contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setRememberMe(boolean remember) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(new FileManager(file).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject profileSettings = (JSONObject) userJson.get("profileSettings");
        profileSettings.put("rememberMe", remember);
        saveJsonToFile(userJson.toJSONString());
    }

    public void setIsNSFW(boolean remember) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(new FileManager(file).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject profileSettings = (JSONObject) userJson.get("e621Settings");
        profileSettings.put("allowNSFW", remember);
        saveJsonToFile(userJson.toJSONString());
    }

    public void setIsBlacklist(boolean remember) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(new FileManager(file).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject profileSettings = (JSONObject) userJson.get("e621Settings");
        profileSettings.put("useBlacklist", remember);
        saveJsonToFile(userJson.toJSONString());
    }

    public void addBlacklist(String tags) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(new FileManager(file.getPath()).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject e621Settings = (JSONObject) userJson.get("e621Settings");
        JSONArray blacklists = (JSONArray) e621Settings.get("blacklist");
        blacklists.addAll(Arrays.asList(tags.split(",")));
        saveJsonToFile(userJson.toJSONString());
    }

    public void remBlacklist(String tags) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(new FileManager(file.getPath()).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject e621Settings = (JSONObject) userJson.get("e621Settings");
        JSONArray blacklists = (JSONArray) e621Settings.get("blacklist");
        blacklists.removeAll(Arrays.asList(tags.split(",")));
        saveJsonToFile(userJson.toJSONString());
    }

    public void setScore(int num) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(new FileManager(file).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject e621Settings = (JSONObject) userJson.get("e621Settings");
        e621Settings.put("score", num);
        saveJsonToFile(userJson.toJSONString());
    }

    public void saveFolderLocation(String loc) {
        JSONParser parser = new JSONParser();
        try {
            userJson = (JSONObject) parser.parse(new FileManager(file).getFileContentsAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject e621Settings = (JSONObject) userJson.get("e621Settings");
        e621Settings.put("imageSaveLocation", loc);
        saveJsonToFile(userJson.toJSONString());
    }

    public void setPassword(String password) {
        JSONObject profileSettings = (JSONObject) userJson.get("profileSettings");
        profileSettings.put("password", password);
        saveJsonToFile(userJson.toJSONString());
    }

    public void setUsername(String username) {
        JSONObject profileSettings = (JSONObject) userJson.get("profileSettings");
        profileSettings.put("username", username);
        saveJsonToFile(userJson.toJSONString());
    }

}
