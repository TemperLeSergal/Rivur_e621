package sample.modules.fileManager;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileManager {

    private File privFile;

    public FileManager(String filePath) {
        System.out.println("Creating new file.");
        privFile = new File(filePath);
        if(this.hasPerms())
            System.out.println("File has perms");
            try {
                //noinspection ResultOfMethodCallIgnored
                privFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public FileManager(File file) {
        System.out.println("Creating new file.");
        privFile = file;
        if(this.hasPerms())
            System.out.println("File has perms");
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
            System.out.println("this.getFile = " + this.getFile());
            System.out.println("privFile = " + privFile);
            fr = new FileReader(privFile);
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

    public boolean copyFileContents(String filePathDest) throws IOException {
        return this.copyFileContents(new File(filePathDest));
    }

    public boolean copyFileContents(File fileDest) throws IOException {
        FileManager fileDest_ = new FileManager(fileDest);
        FileChannel source = null;
        FileChannel destination = null;
        System.out.println("murr: " + fileDest_.hasPerms() + ", Burr: " + fileDest_.isEmpty());
        if (fileDest_.hasPerms() && fileDest_.isEmpty()) {
            try {
                source = new FileInputStream(this.getFile()).getChannel();
                destination = new FileOutputStream(fileDest_.getFile()).getChannel();
                destination.transferFrom(source,0,source.size());
                System.out.println("Source: " + this.getFile().getPath());
                System.out.println("Dest: " + fileDest.getPath());
                System.out.println(destination.transferFrom(source,0,source.size()));

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

    public void appendToFile(String contents){
        try(FileWriter fw = new FileWriter(this.privFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(contents + ",");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void clearFileContents() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(this.privFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert writer != null;
        writer.print("");
        writer.close();
    }

}
