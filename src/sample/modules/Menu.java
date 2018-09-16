/**
 * Sample Skeleton for 'Menu.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXTreeView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Menu {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="backgroundPage"
    private AnchorPane backgroundPage; // Value injected by FXMLLoader

    @FXML // fx:id="DiscordManagement"
    private AnchorPane DiscordManagement; // Value injected by FXMLLoader

    @FXML // fx:id="DiscordManagementTab"
    private AnchorPane DiscordManagementTab; // Value injected by FXMLLoader

    @FXML // fx:id="Settings"
    private AnchorPane Settings; // Value injected by FXMLLoader

    @FXML // fx:id="SettingsTab"
    private AnchorPane SettingsTab; // Value injected by FXMLLoader

    @FXML // fx:id="AdvancedSettings"
    private AnchorPane AdvancedSettings; // Value injected by FXMLLoader

    @FXML // fx:id="AdvancedSettingsTab"
    private AnchorPane AdvancedSettingsTab; // Value injected by FXMLLoader

    @FXML // fx:id="close"
    private ImageView close; // Value injected by FXMLLoader

    @FXML // fx:id="minimize"
    private AnchorPane minimize; // Value injected by FXMLLoader

    @FXML // fx:id="discordServerListing1"
    private JFXTreeView<?> discordServerListing1; // Value injected by FXMLLoader

    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader

    @FXML
    void animateSelectionIn(MouseEvent event) {

    }

    @FXML
    void animateSelectionOut(MouseEvent event) {

    }

    @FXML
    void closeApplication(MouseEvent event) {

    }

    @FXML
    void getScene(MouseEvent event) {

    }

    @FXML
    void minimizeApplication(MouseEvent event) {

    }

    @FXML
    void moveScene(MouseEvent event) {

    }

    @FXML
    void selectScene(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backgroundPage != null : "fx:id=\"backgroundPage\" was not injected: check your FXML file 'Menu.fxml'.";
        assert DiscordManagement != null : "fx:id=\"DiscordManagement\" was not injected: check your FXML file 'Menu.fxml'.";
        assert DiscordManagementTab != null : "fx:id=\"DiscordManagementTab\" was not injected: check your FXML file 'Menu.fxml'.";
        assert Settings != null : "fx:id=\"Settings\" was not injected: check your FXML file 'Menu.fxml'.";
        assert SettingsTab != null : "fx:id=\"SettingsTab\" was not injected: check your FXML file 'Menu.fxml'.";
        assert AdvancedSettings != null : "fx:id=\"AdvancedSettings\" was not injected: check your FXML file 'Menu.fxml'.";
        assert AdvancedSettingsTab != null : "fx:id=\"AdvancedSettingsTab\" was not injected: check your FXML file 'Menu.fxml'.";
        assert close != null : "fx:id=\"close\" was not injected: check your FXML file 'Menu.fxml'.";
        assert minimize != null : "fx:id=\"minimize\" was not injected: check your FXML file 'Menu.fxml'.";
        assert discordServerListing1 != null : "fx:id=\"discordServerListing1\" was not injected: check your FXML file 'Menu.fxml'.";
        assert rootLayout != null : "fx:id=\"rootLayout\" was not injected: check your FXML file 'Menu.fxml'.";

    }
}
