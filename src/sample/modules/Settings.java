/*
  Sample Skeleton for 'Settings.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import sample.modules.fileManager.FileManager;
import sample.modules.jsonManager.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static sample.modules.webPageManager.WebPageAccess.openWebpage;

public class Settings {

    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader

    @FXML // fx:id="furryHavenInviteButton"
    private AnchorPane furryHavenInviteButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsPagePane"
    private AnchorPane e621DownloaderSettingsPagePane; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsScoreSlider"
    private JFXSlider e621DownloaderSettingsScoreSlider; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsScoreText"
    private Text e621DownloaderSettingsScoreText; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsFolderLocationTextField"
    private JFXTextField e621DownloaderSettingsFolderLocationTextField; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListTagTextField"
    private JFXTextField e621DownloaderSettingsBlackListTagTextField; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListTagAddButton"
    private JFXButton e621DownloaderSettingsBlackListTagAddButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListTagRemoveButton"
    private JFXButton e621DownloaderSettingsBlackListTagRemoveButton; // Value injected by FXMLLoader

    @FXML // fx:id="selectedTags"
    private Text selectedTags; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListTagTextArea"
    private JFXListView<String> e621DownloaderSettingsBlackListTagTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListSelectFolderButton"
    private JFXButton e621DownloaderSettingsBlackListSelectFolderButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListOpenFolderButton"
    private JFXButton e621DownloaderSettingsBlackListOpenFolderButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsAllowNSFWButton"
    private JFXCheckBox e621DownloaderSettingsAllowNSFWButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsEnableBlackListButton"
    private JFXCheckBox e621DownloaderSettingsEnableBlackListButton; // Value injected by FXMLLoader

    private FileManager userDataFile = new FileManager("user.json");
    private User userData = new User(userDataFile);
    private FileManager imageFolder = new FileManager("SavedImages");
    private JFXTextField lastKnownJFXTextField = null;
    private String lastKnownJFXTextFieldPromptText = "";

    @FXML
    void blackListAdd() {
        if (!e621DownloaderSettingsBlackListTagTextField.getText().isEmpty()) {
            Collection<String> result = Arrays.stream(e621DownloaderSettingsBlackListTagTextField.getText().split("[,|\\s+]"))
                    .map(String::trim)
                    .filter(next -> !next.isEmpty())
                    .collect(Collectors.toList());
            userData.setValue(User.BLACKLISTED_TAGS, result);
            String str = userData.fetchUserInfo(User.BLACKLISTED_TAGS).replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            ObservableList<String> items = FXCollections.observableArrayList(Arrays.asList(str.split(",")));
            e621DownloaderSettingsBlackListTagTextArea.setItems(items);
            e621DownloaderSettingsBlackListTagTextField.clear();
        }//TODO add else statement preventing empty fields
    }

    @FXML
    void blackListRem() {
        if (!selectedTags.getText().isEmpty()) {
            userData.remBlacklist(selectedTags.getText());
            String str = userData.fetchUserInfo(User.BLACKLISTED_TAGS).replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            ObservableList<String> items = FXCollections.observableArrayList(Arrays.asList(str.split(",")));
            e621DownloaderSettingsBlackListTagTextArea.setItems(items);
            selectedTags.setText("");
        }//TODO add else statement preventing empty fields
    }

    @FXML
    void clearSelectedTags(MouseEvent event) {
        try {
            if (selectedTags.getText() != null) {
                Node node = (Node) event.getSource();
                if (!node.getTypeSelector().equals("JFXButton")) {
                    selectedTags.setText("");
                }
            }
        } catch (NullPointerException ignored) {

        }
    }

    @FXML
    void joinDiscord() {
        try {
            openWebpage(new URL("https://discord.gg/mKAvNKu"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openFolderAtLoc() {
        Desktop d;
        if (Desktop.isDesktopSupported()) {
            d = Desktop.getDesktop();
            try {
                d.open(new File(userData.fetchUserInfo(User.IMAGE_SAVE_LOCATION)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void removePromptTextOnClick(MouseEvent event) {
        if (!lastKnownJFXTextFieldPromptText.isEmpty()) {
            lastKnownJFXTextField.setPromptText(lastKnownJFXTextFieldPromptText);
        }
        Node node = (Node) event.getSource();
        String nodeType = node.getTypeSelector();
        System.out.println(nodeType);
        if (nodeType.equals("JFXTextField")) {
            lastKnownJFXTextField = (JFXTextField) node;
            lastKnownJFXTextFieldPromptText = lastKnownJFXTextField.getPromptText();
            ((JFXTextField) node).setPromptText("");
        }
    }

    @FXML
    void saveFolderLocation() {
        Stage stage = (Stage) selectedTags.getScene().getWindow();
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select A Folder To Save Images");
        File defaultDirectory = new File(userData.fetchUserInfo(User.IMAGE_SAVE_LOCATION));
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(stage);
        userData.setValue(User.IMAGE_SAVE_LOCATION, selectedDirectory.getPath());
        e621DownloaderSettingsFolderLocationTextField.setText(userData.fetchUserInfo(User.IMAGE_SAVE_LOCATION));
    }

    @FXML
    void updateIsBlacklisted() {
        if (Boolean.parseBoolean(userData.fetchUserInfo(User.IS_BLACKLIST_ALLOWED))) {
            userData.setValue(User.IS_BLACKLIST_ALLOWED, false);
        } else {
            userData.setValue(User.IS_BLACKLIST_ALLOWED, true);
        }
    }

    @FXML
    void updateIsNSFW() {
        if (Boolean.parseBoolean(userData.fetchUserInfo(User.IS_NSFW_ALLOWED))) {
            userData.setValue(User.IS_NSFW_ALLOWED, false);
        } else {
            userData.setValue(User.IS_NSFW_ALLOWED, true);
        }
    }

    @FXML
    void updateScore() {
        userData.setValue(User.SCORE, (int) e621DownloaderSettingsScoreSlider.getValue());
    }

    @FXML
    void updateScoreDrag() {
        e621DownloaderSettingsScoreText.setText("Score: " + String.valueOf((int) e621DownloaderSettingsScoreSlider.getValue()));
    }

    @FXML
    void updateSelectedTags() {
        selectedTags.setText(e621DownloaderSettingsBlackListTagTextArea.getSelectionModel().getSelectedItems().get(0));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert rootLayout != null : "fx:id=\"rootLayout\" was not injected: check your FXML file 'Settings.fxml'.";
        assert furryHavenInviteButton != null : "fx:id=\"furryHavenInviteButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsPagePane != null : "fx:id=\"e621DownloaderSettingsPagePane\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsScoreSlider != null : "fx:id=\"e621DownloaderSettingsScoreSlider\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsScoreText != null : "fx:id=\"e621DownloaderSettingsScoreText\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsFolderLocationTextField != null : "fx:id=\"e621DownloaderSettingsFolderLocationTextField\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagTextField != null : "fx:id=\"e621DownloaderSettingsBlackListTagTextField\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagAddButton != null : "fx:id=\"e621DownloaderSettingsBlackListTagAddButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagRemoveButton != null : "fx:id=\"e621DownloaderSettingsBlackListTagRemoveButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert selectedTags != null : "fx:id=\"selectedTags\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagTextArea != null : "fx:id=\"e621DownloaderSettingsBlackListTagTextArea\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListSelectFolderButton != null : "fx:id=\"e621DownloaderSettingsBlackListSelectFolderButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListOpenFolderButton != null : "fx:id=\"e621DownloaderSettingsBlackListOpenFolderButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsAllowNSFWButton != null : "fx:id=\"e621DownloaderSettingsAllowNSFWButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsEnableBlackListButton != null : "fx:id=\"e621DownloaderSettingsEnableBlackListButton\" was not injected: check your FXML file 'Settings.fxml'.";
        userData.setValue(User.IMAGE_SAVE_LOCATION, imageFolder.getFile().getPath());
        String str = userData.fetchUserInfo(User.BLACKLISTED_TAGS).replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        e621DownloaderSettingsBlackListTagTextArea.getItems().addAll(Arrays.asList(str.split(",")));
        File saveFolder = new File(userData.fetchUserInfo(User.IMAGE_SAVE_LOCATION));
        e621DownloaderSettingsFolderLocationTextField.setText(saveFolder.getPath());
        if (Boolean.parseBoolean(userData.fetchUserInfo(User.IS_NSFW_ALLOWED)) && !e621DownloaderSettingsAllowNSFWButton.isArmed()) {
            e621DownloaderSettingsAllowNSFWButton.fire();
        } else if (!Boolean.parseBoolean(userData.fetchUserInfo(User.IS_NSFW_ALLOWED)) && e621DownloaderSettingsAllowNSFWButton.isArmed()) {
            e621DownloaderSettingsAllowNSFWButton.fire();
        }
        if (Boolean.parseBoolean(userData.fetchUserInfo(User.IS_BLACKLIST_ALLOWED)) && !e621DownloaderSettingsEnableBlackListButton.isArmed()) {
            e621DownloaderSettingsEnableBlackListButton.fire();
        } else if (!Boolean.parseBoolean(userData.fetchUserInfo(User.IS_BLACKLIST_ALLOWED)) && e621DownloaderSettingsEnableBlackListButton.isArmed()) {
            e621DownloaderSettingsEnableBlackListButton.fire();
        }

        e621DownloaderSettingsScoreSlider.setValue(Double.parseDouble(userData.fetchUserInfo(User.SCORE)));
        e621DownloaderSettingsScoreText.setText("Score: " + userData.fetchUserInfo(User.SCORE));
    }
}
