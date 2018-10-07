package sample.modules.fileManager;

import java.io.File;

public class FolderManager {
    private File privFolder = null;
    public FolderManager(String filePath) {
        System.out.println("Creating new folder");
        privFolder = new File(filePath);
        if (!privFolder.exists()) {
            if (privFolder.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }else{
            System.out.println("Folder already exists");
        }
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
