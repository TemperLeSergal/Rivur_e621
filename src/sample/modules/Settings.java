/**
 * Sample Skeleton for 'Settings.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Settings {

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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
    private JFXListView<?> e621DownloaderSettingsBlackListTagTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListSelectFolderButton"
    private JFXButton e621DownloaderSettingsBlackListSelectFolderButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListOpenFolderButton"
    private JFXButton e621DownloaderSettingsBlackListOpenFolderButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsAllowNSFWButton"
    private JFXCheckBox e621DownloaderSettingsAllowNSFWButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsEnableBlackListButton"
    private JFXCheckBox e621DownloaderSettingsEnableBlackListButton; // Value injected by FXMLLoader

    @FXML
    void blackListAdd(MouseEvent event) {

    }

    @FXML
    void blackListRem(MouseEvent event) {

    }

    @FXML
    void clearSelectedTags(MouseEvent event) {

    }

    @FXML
    void joinDiscord(MouseEvent event) {

    }

    @FXML
    void openFolderAtLoc(MouseEvent event) {

    }

    @FXML
    void removePromptTextOnClick(MouseEvent event) {

    }

    @FXML
    void saveFolderLocation(MouseEvent event) {

    }

    @FXML
    void updateIsBlacklisted(MouseEvent event) {

    }

    @FXML
    void updateIsNSFW(MouseEvent event) {

    }

    @FXML
    void updateScore(MouseEvent event) {

    }

    @FXML
    void updateScoreDrag(MouseEvent event) {

    }

    @FXML
    void updateSelectedTags(MouseEvent event) {

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

    }
}
