/**
 * Sample Skeleton for 'AdvancedSettings.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.modules.webPageManager.WebPageAccess.openWebpage;

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
    private JFXComboBox<Label> downloadRestrictionChoiceBox; // Value injected by FXMLLoader

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
    private JFXListView<String> priorityOneBlacklist; // Value injected by FXMLLoader

    @FXML // fx:id="whitelistTagsTextField"
    private JFXTextField whitelistTagsTextField; // Value injected by FXMLLoader

    @FXML // fx:id="addToWhitelistButton"
    private JFXButton addToWhitelistButton; // Value injected by FXMLLoader

    @FXML // fx:id="e621DownloaderSettingsBlackListTagRemoveButton1"
    private JFXButton e621DownloaderSettingsBlackListTagRemoveButton1; // Value injected by FXMLLoader

    @FXML // fx:id="selectedTags1"
    private Text selectedTags1; // Value injected by FXMLLoader

    @FXML // fx:id="priorityOneWhitelist"
    private JFXListView<String> priorityOneWhitelist; // Value injected by FXMLLoader

    @FXML
    void test(MouseEvent event) {

    }

    @FXML
    public void joinDiscord(MouseEvent event) {
        System.out.println("Doing something");
        try {
            openWebpage(new URL("https://discord.gg/mKAvNKu"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert rootLayout != null : "fx:id=\"rootLayout\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert furryHavenInviteButton != null : "fx:id=\"furryHavenInviteButton\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        assert downloadRestrictionChoiceBox != null : "fx:id=\"downloadRestrictionChoiceBox\" was not injected: check your FXML file 'AdvancedSettings.fxml'.";
        downloadRestrictionChoiceBox.setPromptText("images");
        downloadRestrictionChoiceBox.getItems().add(new Label("Images"));
        downloadRestrictionChoiceBox.getItems().add(new Label("pages"));
        downloadRestrictionChoiceBox.getItems().add(new Label("image size"));
        downloadRestrictionChoiceBox.setPromptText("Select restriction");
        downloadRestrictionChoiceBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Label object) {
                return object == null ? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });

    }

    public void blackListRem(MouseEvent event) {
    }

    public void blackListAdd(MouseEvent event) {
    }

    public void updateSelectedTags(MouseEvent event) {
    }
}
