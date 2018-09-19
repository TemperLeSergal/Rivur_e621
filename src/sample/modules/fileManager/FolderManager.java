package sample.modules.fileManager;

import java.io.File;

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

    public boolean isEmpty(){
        if(privFolder.list().length>0){

            return false;

        }else{

            return true;

        }
    }

    public File getFolder(){
        return this.privFolder;
    }

    public String getFilePath(){
        File file = this.getFolder();
        return file.getAbsolutePath().replace(this.getFolder().getName(), "");
    }
}
