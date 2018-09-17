package sample.modules.fileManager;

import java.io.File;
import java.io.IOException;

public class FolderManager {
    private File privFolder = null;
    public FolderManager(String filePath) {
        privFolder = new File(filePath);
        try {
            privFolder.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FolderManager(File file) {
        privFolder = file;
            try {
                //noinspection ResultOfMethodCallIgnored
                privFolder.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
