package sample.modules.FileManager;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileManager {
    File file;
    boolean isFolder = false;

    String sizeRestraint = "";

    public FileManager(String filePath) {
        if (filePath.contains(".")) {
            file = new File(filePath);
            if (!(file.exists() && file.canRead() && file.canWrite())) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            isFolder = true;
            file = new File(filePath);
            file.mkdir();
        }
    }

    public FileManager(File file_) {
        file = file_;
        if (!(file.exists() && file.canRead() && file.canWrite())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public FileManager(String filePath, String sizeRestraint_) {
        file = new File(filePath);
        sizeRestraint = sizeRestraint_;
    }

    public void copyFile(File sourceFile, File destFile) throws IOException {
        if (!isFolder) {
            if (!destFile.exists()) {
                destFile.createNewFile();
            }

            FileChannel source = null;
            FileChannel destination = null;

            try {
                source = new FileInputStream(sourceFile).getChannel();
                destination = new FileOutputStream(destFile).getChannel();
                destination.transferFrom(source, 0, source.size());
            } finally {
                if (source != null) {
                    source.close();
                }
                if (destination != null) {
                    destination.close();
                }
            }
        }
    }

    public String getFileContentsAsString() {
        if (!isFolder) {
            return readFile("string");
        } else {
            return "cannot read from folder";
        }
    }

    public String getFileContentsAsFormatted() {
        if (!isFolder) {
            return readFile("format");
        } else {
            return "cannot read from folder";
        }
    }

    public String getFileContentsAsList() {
        if (!isFolder) {
            return readFile("list");
        } else {
            return "cannot read from folder";
        }
    }

    public void getFileContentsToConsole() {
        if (!isFolder) {
            readFile("console");
        }
    }

    public boolean isEmpty() {
        if (!isFolder) {
            System.out.println(readFile("string").isEmpty());
            return readFile("string").isEmpty();
        } else {
            return Boolean.parseBoolean(null);
        }
    }

    private String readFile(String condition) {
        if (!isFolder) {
            String line;
            String str = "";
            try {
                BufferedReader br;
                try (FileReader fr = new FileReader(file)) {
                    br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        switch (condition) {
                            case "string": {
                                str = str + line + " ";
                            }
                            break;
                            case "format": {
                                str = str + line + "\n ";
                            }
                            break;
                            case "list": {
                                str = str + line + ",";
                            }
                            break;
                            case "console": {
                                System.out.println(str);
                            }
                            break;
                        }
                    }
                }
                br.close();

            } catch (IOException ex) {
            }
            return str;
        } else {
            return "cannot read from folder";
        }
    }

    public File getFile() {
        return file;
    }

    public String getFileSize() {
        String fileSize = "";
        double bytes = file.length();
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);
        System.out.println(String.valueOf(bytes));
        switch (sizeRestraint) {
            case "bytes":
                fileSize = String.valueOf(bytes);
                break;
            case "kilobytes":
                fileSize = String.valueOf(kilobytes);
                break;
            case "megabytes":
                fileSize = String.valueOf(megabytes);
                break;
        }
        return fileSize;
    }

}
