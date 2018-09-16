/**
 * Sample Skeleton for 'AdvancedSettings.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AdvancedSettings {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader

    @FXML // fx:id="furryHavenInviteButton"
    private AnchorPane furryHavenInviteButton; // Value injected by FXMLLoader

    @FXML // fx:id="downloadRestrictionChoiceBox"
    private JFXComboBox<?> downloadRestrictionChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="helpLimit"
    private ImageView helpLimit; // Value injected by FXMLLoader

    @FXML // fx:id="helpRestrictions"
    private ImageView helpRestrictions; // Value injected by FXMLLoader

    @FXML // fx:id="helpInfoPane"
    private AnchorPane helpInfoPane; // Value injected by FXMLLoader

    @FXML // fx:id="HelpModalTitle"
    private Text HelpModalTitle; // Value injected by FXMLLoader

    @FXML // fx:id="HelpModalCloseButton"
    private JFXButton HelpModalCloseButton; // Value injected by FXMLLoader

    @FXML // fx:id="HelpModalTextArea"
    private JFXTextArea HelpModalTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="helpMetadata"
    private ImageView helpMetadata; // Value injected by FXMLLoader

    @FXML // fx:id="helpArtistNameTags"
    private ImageView helpArtistNameTags; // Value injected by FXMLLoader

    @FXML // fx:id="helpWhitelistTagsName"
    private ImageView helpWhitelistTagsName; // Value injected by FXMLLoader

    @FXML // fx:id="helpPriorityOneBlackAndWhitelist"
    private ImageView helpPriorityOneBlackAndWhitelist; // Value injected by FXMLLoader

    @FXML // fx:id="blacklistTagsTextField"
    private JFXTextField blacklistTagsTextField; // Value injected by FXMLLoader

    @FXML // fx:id="addToBlacklistButton"
    private JFXButton addToBlacklistButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListTagRemoveButton"
    private JFXButton e621DownloaderSettingsBlackListTagRemoveButton; // Value injected by FXMLLoader

    @FXML // fx:id="selectedTags"
    private Text selectedTags; // Value injected by FXMLLoader

    @FXML // fx:id="priorityOneBlacklist"
    private JFXListView<?> priorityOneBlacklist; // Value injected by FXMLLoader

    @FXML // fx:id="whitelistTagsTextField"
    private JFXTextField whitelistTagsTextField; // Value injected by FXMLLoader

    @FXML // fx:id="addToWhitelistButton"
    private JFXButton addToWhitelistButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListTagRemoveButton1"
    private JFXButton e621DownloaderSettingsBlackListTagRemoveButton1; // Value injected by FXMLLoader

    @FXML // fx:id="selectedTags1"
    private Text selectedTags1; // Value injected by FXMLLoader

    @FXML // fx:id="priorityOneWhitelist"
    private JFXListView<?> priorityOneWhitelist; // Value injected by FXMLLoader

    @FXML
    void blackListAdd(MouseEvent event) {

    }

    @FXML
    void blackListRem(MouseEvent event) {

    }

    @FXML
    void joinDiscord(MouseEvent event) {

    }

    @FXML
    void updateSelectedTags(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert rootLayout != null : "fx:id=\"rootLayout\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert furryHavenInviteButton != null : "fx:id=\"furryHavenInviteButton\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert downloadRestrictionChoiceBox != null : "fx:id=\"downloadRestrictionChoiceBox\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert helpLimit != null : "fx:id=\"helpLimit\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert helpRestrictions != null : "fx:id=\"helpRestrictions\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert helpInfoPane != null : "fx:id=\"helpInfoPane\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert HelpModalTitle != null : "fx:id=\"HelpModalTitle\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert HelpModalCloseButton != null : "fx:id=\"HelpModalCloseButton\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert HelpModalTextArea != null : "fx:id=\"HelpModalTextArea\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert helpMetadata != null : "fx:id=\"helpMetadata\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert helpArtistNameTags != null : "fx:id=\"helpArtistNameTags\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert helpWhitelistTagsName != null : "fx:id=\"helpWhitelistTagsName\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert helpPriorityOneBlackAndWhitelist != null : "fx:id=\"helpPriorityOneBlackAndWhitelist\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert blacklistTagsTextField != null : "fx:id=\"blacklistTagsTextField\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert addToBlacklistButton != null : "fx:id=\"addToBlacklistButton\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert e621DownloaderSettingsBlackListTagRemoveButton != null : "fx:id=\"e621DownloaderSettingsBlackListTagRemoveButton\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert selectedTags != null : "fx:id=\"selectedTags\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert priorityOneBlacklist != null : "fx:id=\"priorityOneBlacklist\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert whitelistTagsTextField != null : "fx:id=\"whitelistTagsTextField\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert addToWhitelistButton != null : "fx:id=\"addToWhitelistButton\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert e621DownloaderSettingsBlackListTagRemoveButton1 != null : "fx:id=\"e621DownloaderSettingsBlackListTagRemoveButton1\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert selectedTags1 != null : "fx:id=\"selectedTags1\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert priorityOneWhitelist != null : "fx:id=\"priorityOneWhitelist\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";

    }
}
