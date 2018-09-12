/**
 * Sample Skeleton for 'Settings.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import sample.modules.DatabaseManager.Database;
import sample.modules.FileManager.FileManager;
import sample.modules.JSONManager.userJSONManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.TreeMap;

import static sample.modules.webPageManager.WebPageAccess.openWebpage;

public class Settings {

    public final String B = "bytes";
    public final String KB = "kilobytes";
    public final String MB = "megabytes";
    public int score = 50;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader
    @FXML // fx:id="furryHavenInviteButton"
    private AnchorPane furryHavenInviteButton; // Value injected by FXMLLoader
    @FXML // fx:id="e621DownloaderSettingsPagePane"
    private AnchorPane e621DownloaderSettingsPagePane; // Value injected by FXMLLoader
    @FXML // fx:id="e621DownloaderSettingsAllowNSFWButton"
    private JFXCheckBox e621DownloaderSettingsAllowNSFWButton; // Value injected by FXMLLoader
    @FXML // fx:id="e621DownloaderSettingsEnableBlackListButton"
    private JFXCheckBox e621DownloaderSettingsEnableBlackListButton; // Value injected by FXMLLoader
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
    @FXML // fx:id="paneSelectorPaneE621DownloaderSelectedTabPane11"
    private AnchorPane paneSelectorPaneE621DownloaderSelectedTabPane11; // Value injected by FXMLLoader
    @FXML // fx:id="e621DownloaderSettingsBlackListSelectFolderButton"
    private JFXButton e621DownloaderSettingsBlackListSelectFolderButton; // Value injected by FXMLLoader
    @FXML // fx:id="e621DownloaderSettingsBlackListOpenFolderButton"
    private JFXButton e621DownloaderSettingsBlackListOpenFolderButton; // Value injected by FXMLLoader
    private JFXTextField lastKnownJFXTextField = null;
    private String lastKnownJFXTextFieldPromptText = "";
    private double xOffset = 0;
    private double yOffset = 0;
    private Database database = new Database();
    private FileManager userDataFile = new FileManager("userData.json");
    private FileManager changeLogFile = new FileManager("changelog.txt");
    private userJSONManager userData = new userJSONManager("userData.json");
    private FileManager emailPage = new FileManager("emailPage.html");
    private FileManager imageFolder = new FileManager("SavedImages");
    private TreeMap<String, AnchorPane> sceneSwapMap = new TreeMap<>();
    private TreeMap<String, ImageView> buttons = new TreeMap<>();
    private Thread thread = null;
    private Thread thread_ = null;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert rootLayout != null : "fx:id=\"rootLayout\" was not injected: check your FXML file 'Settings.fxml'.";
        assert furryHavenInviteButton != null : "fx:id=\"furryHavenInviteButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsPagePane != null : "fx:id=\"e621DownloaderSettingsPagePane\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsAllowNSFWButton != null : "fx:id=\"e621DownloaderSettingsAllowNSFWButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsEnableBlackListButton != null : "fx:id=\"e621DownloaderSettingsEnableBlackListButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsScoreSlider != null : "fx:id=\"e621DownloaderSettingsScoreSlider\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsScoreText != null : "fx:id=\"e621DownloaderSettingsScoreText\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsFolderLocationTextField != null : "fx:id=\"e621DownloaderSettingsFolderLocationTextField\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagTextField != null : "fx:id=\"e621DownloaderSettingsBlackListTagTextField\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagAddButton != null : "fx:id=\"e621DownloaderSettingsBlackListTagAddButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagRemoveButton != null : "fx:id=\"e621DownloaderSettingsBlackListTagRemoveButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert selectedTags != null : "fx:id=\"selectedTags\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListTagTextArea != null : "fx:id=\"e621DownloaderSettingsBlackListTagTextArea\" was not injected: check your FXML file 'Settings.fxml'.";
        assert paneSelectorPaneE621DownloaderSelectedTabPane11 != null : "fx:id=\"paneSelectorPaneE621DownloaderSelectedTabPane11\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListSelectFolderButton != null : "fx:id=\"e621DownloaderSettingsBlackListSelectFolderButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert e621DownloaderSettingsBlackListOpenFolderButton != null : "fx:id=\"e621DownloaderSettingsBlackListOpenFolderButton\" was not injected: check your FXML file 'Settings.fxml'.";
        userData.saveFolderLocation(imageFolder.getFile().getPath());
        String str = userData.fetchInfo("blacklist").replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        e621DownloaderSettingsBlackListTagTextArea.getItems().addAll(Arrays.asList(str.split(",")));
        File saveFolder = new File(userData.fetchInfo("imageSaveLocation"));
        e621DownloaderSettingsFolderLocationTextField.setText(saveFolder.getPath());
        System.out.println("Will show NSFW content: " + Boolean.parseBoolean(userData.fetchInfo("isNSFW")));
        System.out.println("Will use Blacklisted tags: " + userData.fetchInfo("isBlacklist"));
        if (Boolean.parseBoolean(userData.fetchInfo("isNSFW")) && !e621DownloaderSettingsAllowNSFWButton.isArmed()) {
            e621DownloaderSettingsAllowNSFWButton.fire();
        } else if (!Boolean.parseBoolean(userData.fetchInfo("isNSFW")) && e621DownloaderSettingsAllowNSFWButton.isArmed()) {
            e621DownloaderSettingsAllowNSFWButton.fire();
        }
        if (Boolean.parseBoolean(userData.fetchInfo("isBlacklist")) && !e621DownloaderSettingsEnableBlackListButton.isArmed()) {
            e621DownloaderSettingsEnableBlackListButton.fire();
        } else if (!Boolean.parseBoolean(userData.fetchInfo("isBlacklist")) && e621DownloaderSettingsEnableBlackListButton.isArmed()) {
            e621DownloaderSettingsEnableBlackListButton.fire();
        }

        e621DownloaderSettingsScoreSlider.setValue(Double.parseDouble(userData.fetchInfo("Score")));
        e621DownloaderSettingsScoreText.setText("Score: " + userData.fetchInfo("Score"));
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
    void blackListAdd(MouseEvent event) {
        if (e621DownloaderSettingsBlackListTagTextField.getText().isEmpty()) {
            //createdialogue("Blacklist Modification Failed", "Please ensure that the blacklist tag field is not empty.", signupPage);
        } else {
            userData.addBlacklist(e621DownloaderSettingsBlackListTagTextField.getText());
            String str = userData.fetchInfo("blacklist").replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            ObservableList<String> items = FXCollections.observableArrayList(Arrays.asList(str.split(",")));
            e621DownloaderSettingsBlackListTagTextArea.setItems(items);
            e621DownloaderSettingsBlackListTagTextField.clear();
        }
    }

    @FXML
    void blackListRem(MouseEvent event) {
        if (selectedTags.getText().isEmpty()) {
            //createdialogue("Blacklist Modification Failed", "Please ensure that a tag is selected from the list.", signupPage);
        } else {
            userData.remBlacklist(selectedTags.getText());
            String str = userData.fetchInfo("blacklist").replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            ObservableList<String> items = FXCollections.observableArrayList(Arrays.asList(str.split(",")));
            e621DownloaderSettingsBlackListTagTextArea.setItems(items);
            selectedTags.setText("");
        }
    }

    @FXML
    void clearSelectedTags(MouseEvent event) {
        try {
            if (selectedTags.getText() != null) {
                Node node = (Node) event.getSource();
                String nodeID = node.getId();
                if (!node.getTypeSelector().equals("JFXButton")) {
                    selectedTags.setText("");
                }
            }
        } catch (NullPointerException e) {

        }
    }

    @FXML
    void openFolderAtLoc(MouseEvent event) {
        Desktop d;
        if (Desktop.isDesktopSupported()) {
            d = Desktop.getDesktop();
            try {
                d.open(new File(userData.fetchInfo("imageSaveLocation")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void saveFolderLocation(MouseEvent event) {
        Stage stage = (Stage) selectedTags.getScene().getWindow();
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select A Folder To Save Images");
        File defaultDirectory = new File(userData.fetchInfo("imageSaveLocation"));
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(stage);
        userData.saveFolderLocation(selectedDirectory.getPath());
        e621DownloaderSettingsFolderLocationTextField.setText(userData.fetchInfo("imageSaveLocation"));
    }

    @FXML
    void updateScore(MouseEvent event) {
        userData.setScore((int) e621DownloaderSettingsScoreSlider.getValue());
    }

    @FXML
    void updateScoreDrag(MouseEvent event) {
        e621DownloaderSettingsScoreText.setText("Score: " + String.valueOf((int) e621DownloaderSettingsScoreSlider.getValue()));
    }

    @FXML
    void updateSelectedTags(MouseEvent event) {
        ObservableList<String> items = e621DownloaderSettingsBlackListTagTextArea.getSelectionModel().getSelectedItems();
        selectedTags.setText(e621DownloaderSettingsBlackListTagTextArea.getSelectionModel().getSelectedItems().get(0));
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
            JFXTextField text = (JFXTextField) node;
            ((JFXTextField) node).setPromptText("");
        }
    }

    @FXML
    void updateIsNSFW() {
        if (Boolean.parseBoolean(userData.fetchInfo("isNSFW"))) {
            userData.setIsNSFW(false);
        } else {
            userData.setIsNSFW(true);
        }
        System.out.println("Will show NSFW content: " + Boolean.parseBoolean(userData.fetchInfo("isNSFW")));
    }

    @FXML
    void updateIsBlacklisted() {
        if (Boolean.parseBoolean(userData.fetchInfo("isBlacklist"))) {
            userData.setIsBlacklist(false);
        } else {
            userData.setIsBlacklist(true);
        }
        System.out.println("Will use Blacklisted tags: " + userData.fetchInfo("isBlacklist"));
    }


}
