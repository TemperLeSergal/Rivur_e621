/*
  Sample Skeleton for 'e621Downloader.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import sample.modules.fileManager.FileManager;
import sample.modules.fileManager.FileProperties;
import sample.modules.jsonManager.User;
import sample.modules.jsonManager.e621;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static sample.modules.webPageManager.WebPageAccess.openWebpage;

public class e621Downloader {

    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader

    @FXML // fx:id="furryHavenInviteButton"
    private AnchorPane furryHavenInviteButton; // Value injected by FXMLLoader

    FileManager savedImages = new FileManager("savedImages.txt");

    @FXML // fx:id="e621DownloaderImageContainer"
    private HBox e621DownloaderImageContainer; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloadingStatusText"
    private Text e621DownloadingStatusText; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloadingProgressBar"
    private JFXProgressBar e621DownloadingProgressBar; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloadingInfoText"
    private Text e621DownloadingInfoText; // Value injected by FXMLLoader
    Thread cacheThread;
    @FXML // fx:id="searchTags"
    private JFXTextField searchTags; // Value injected by FXMLLoader
    private FileManager userDataFile = new FileManager(FileProperties.directories.JSON + "user.json");
    private User userData = new User(userDataFile);

    @FXML
    public void joinDiscord() {
        System.out.println("Doing something");
        try {
            openWebpage(new URL("https://discord.gg/mKAvNKu"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void startDownload(MouseEvent event) {
        ArrayList<String> addedURL = new ArrayList<>();
        String rating;
        if (!searchTags.getText().isEmpty()) {
            if (Boolean.parseBoolean(userData.fetchUserInfo(User.IS_NSFW_ALLOWED))) {
                rating = "e";
            } else {
                rating = "s";
            }
            e621 e621Object = new e621();
            Task<Void> cacheImages = new Task<>() {
                @Override
                protected Void call() {
                    return null;
                }
            };
            cacheThread.setDaemon(true);
            cacheThread = new Thread(cacheImages);
            cacheThread.start();
            Task<Void> downloadImages = new Task<>() {
                @Override
                protected Void call() {
                    return null;
                }
            };
            cacheThread.setDaemon(false);
            cacheThread = new Thread(cacheImages);
            cacheThread.start();
        }
    }

    @FXML
    void stopDownload(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert rootLayout != null : "fx:id=\"rootLayout\" was not injected: check your FXML file 'e621Downloader.fxml'.";
        assert furryHavenInviteButton != null : "fx:id=\"furryHavenInviteButton\" was not injected: check your FXML file 'e621Downloader.fxml'.";
        assert e621DownloaderImageContainer != null : "fx:id=\"e621DownloaderImageContainer\" was not injected: check your FXML file 'e621Downloader.fxml'.";
        assert e621DownloadingStatusText != null : "fx:id=\"e621DownloadingStatusText\" was not injected: check your FXML file 'e621Downloader.fxml'.";
        assert e621DownloadingProgressBar != null : "fx:id=\"e621DownloadingProgressBar\" was not injected: check your FXML file 'e621Downloader.fxml'.";
        assert e621DownloadingInfoText != null : "fx:id=\"e621DownloadingInfoText\" was not injected: check your FXML file 'e621Downloader.fxml'.";

    }
}
