/*
  Sample Skeleton for 'e621Downloader.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXProgressBar;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.MalformedURLException;
import java.net.URL;

import static sample.modules.webPageManager.WebPageAccess.openWebpage;

public class e621Downloader {

    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader

    @FXML // fx:id="furryHavenInviteButton"
    private AnchorPane furryHavenInviteButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderImageContainer"
    private HBox e621DownloaderImageContainer; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloadingStatusText"
    private Text e621DownloadingStatusText; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloadingProgressBar"
    private JFXProgressBar e621DownloadingProgressBar; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloadingInfoText"
    private Text e621DownloadingInfoText; // Value injected by FXMLLoader

    @FXML
    public void joinDiscord() {
        System.out.println("Doing something");
        try {
            openWebpage(new URL("https://discord.gg/mKAvNKu"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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
