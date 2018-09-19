/*
  Sample Skeleton for 'e621Downloader.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import sample.modules.fileManager.FileManager;
import sample.modules.fileManager.FileProperties;
import sample.modules.fileManager.FolderManager;
import sample.modules.jsonManager.User;
import sample.modules.jsonManager.e621;
import sample.modules.jsonManager.e621Builder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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
    Thread cacheThread;
    @FXML // fx:id="searchTags"
    private JFXTextField searchTags; // Value injected by FXMLLoader
    private FileManager userDataFile = new FileManager("user.json");
    private User userData = new User(userDataFile);
    e621Builder e621 = new e621Builder();

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
            String tags = searchTags.getText().replaceAll("\\s+", ",");
            if (Boolean.parseBoolean(userData.fetchUserInfo(User.IS_NSFW_ALLOWED))) {
                rating = "e";
            } else {
                rating = "s";
            }
            Task<Void> cacheImages = new Task<>() {
                @Override
                protected Void call() {

                    e621.addTag(tags);
                    //e621.setLimit(limit);
                    e621.setRating(rating);
                    e621.queueAndCacheImages();
                    return null;
                }
            };
            cacheThread = new Thread(cacheImages);
            cacheThread.setDaemon(true);
            cacheThread.start();
            Task<Void> downloadImages = new Task<>() {
                @Override
                protected Void call() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for(int index = 0; index < e621.fetchCachedImages().size(); index++){
                        String url = (String) e621.fetchCachedImages().keySet().toArray()[index];
                        String fileName = e621.fetchCachedImages().get(url);
                        Image image = new Image(url);
                        if (!addedURL.contains(url)) {
                            addedURL.add(url);
                            System.out.println("Downloading: " + url + " || to: " + (userData.fetchUserInfo(User.IMAGE_SAVE_LOCATION)));
                            try {
                                int finalIndex = index;
                                Platform.runLater(() -> {
                                    System.out.println(finalIndex + " || " + e621.fetchCachedImages().size());
                                    updateProgress(finalIndex, e621.fetchCachedImages().size());
                                    BackgroundSize backgroundSize = new BackgroundSize(e621DownloaderImageContainer.getWidth(), e621DownloaderImageContainer.getHeight(), false, false, true, false);
                                    e621DownloaderImageContainer.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
                                    e621DownloadingStatusText.setText("Status: " + finalIndex + " || " + (e621.fetchCachedImages().size() - 1));
                                    e621DownloadingInfoText.setText("Downloading: " + fileName);
                                });
                                saveImage(url, (userData.fetchUserInfo(User.IMAGE_SAVE_LOCATION) + fileName));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else{

                        }
                    }
                    updateProgress(e621.fetchCachedImages().size(), e621.fetchCachedImages().size());
                    e621DownloadingStatusText.setText("Status: Downloaded " + (e621.fetchCachedImages().size()-1) + " images.");
                    e621DownloadingInfoText.setText("All Images Downloaded");
                    return null;
                }
            };
            cacheThread = new Thread(downloadImages);
            cacheThread.setDaemon(false);
            cacheThread.start();
            e621DownloadingProgressBar.progressProperty()
                    .bind(downloadImages.progressProperty());
        }
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
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
        e621DownloadingProgressBar.progressProperty().unbind();
        e621DownloadingProgressBar.progressProperty().setValue(0);
    }
}
