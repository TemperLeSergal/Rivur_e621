package sample.modules.fileManager;

import java.io.File;
import java.io.IOException;

public class FolderManager {
    private File privFolder = null;
    public FolderManager(String filePath) {
        privFolder = new File(filePath);
        privFolder.mkdir();
    }

    public FolderManager(File file) {
        privFolder = file;
        //noinspection ResultOfMethodCallIgnored
        privFolder.mkdir();
    }
}
