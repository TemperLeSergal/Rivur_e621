package sample.modules.jsonManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.modules.fileManager.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class User {
    private FileManager userFileManager;
    private String defFileSavePath;
    String userJsonFile;
    public User(FileManager fm){
        userFileManager = fm;
        defFileSavePath = fm.getDefFilePath();
        userJsonFile = defFileSavePath + "src\\sample\\media\\files\\json\\user.json";

    }
}
