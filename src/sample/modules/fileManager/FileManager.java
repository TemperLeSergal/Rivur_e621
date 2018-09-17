package sample.modules.fileManager;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileManager {

    private File privFile;

    public FileManager(String filePath) {
        new FileManager(new File(filePath));
    }

    public FileManager(File file) {
        privFile = file;
        if(this.hasPerms())
            try {
                //noinspection ResultOfMethodCallIgnored
                privFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public boolean hasPerms(String filePath){
        return new FileManager(filePath).hasPerms();
    }

    public boolean hasPerms(File file){
        return new FileManager(file).hasPerms();
    }

    public boolean hasPerms(){
        return privFile.exists() && privFile.canRead() && privFile.canWrite();
    }

    public boolean isEmpty(String filePath){
        return new FileManager(filePath).isEmpty();
    }

    public boolean isEmpty(File file){
        return new FileManager(file).isEmpty();
    }

    public boolean isEmpty(){
        return this.readFromFile(FileProperties.string.STRING).isEmpty();
    }

    public String readFromFile(String filePath, String format){
        return new FileManager(filePath).readFromFile(format);
    }

    public String readFromFile(File file, String format){
        return new FileManager(file).readFromFile(format);
    }

    public String readFromFile(String format){
        format = format.toLowerCase();
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        FileReader fr;
        String line;
        String extension = "";
        switch (format){
            case "string" : {
                extension = " ";
            }
            break;
            case "formatted" : {
                extension = "\n";
            }
            break;
            case "list" : {
                extension = ",";
            }
            break;
            default : {
                System.err.println("Invalid input for format constraint.");
            }
        }
        try {
            fr = new FileReader(this.getFile());
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                sb.append(line + extension);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public File getFile(){
        return this.privFile;
    }

    public boolean copyFileContents(String filePathSource, String filePathDest) throws IOException {
        return new FileManager(filePathSource).copyFileContents(new File(filePathDest));
    }

    public boolean copyFileContents(File fileSource, File fileDest) throws IOException {
        return new FileManager(fileSource).copyFileContents(fileDest);
    }

    public boolean copyFileContents(File fileDest) throws IOException {
        FileManager fileDest_ = new FileManager(fileDest);
        FileChannel source = null;
        FileChannel destination = null;

        if(fileDest_.hasPerms() && !fileDest_.isEmpty()){
            try {
                source = new FileInputStream(this.getFile()).getChannel();
                destination = new FileOutputStream(fileDest_.getFile()).getChannel();
                destination.transferFrom(source,0,source.size());

            } finally {
                if(source != null){
                    source.close();
                }
                if(destination != null){
                    destination.close();
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public String getFilePath(){
        File file = this.getFile();
        return file.getAbsolutePath().replace(this.getFile().getName(), "");
    }

    public String getDefFilePath(){
        String fileName = "test.txt";
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath().replace(fileName, "");
    }

}
