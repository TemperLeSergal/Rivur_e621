/*
  Sample Skeleton for 'Menu.fxml' Controller Class
 */

package sample.modules;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeOut;
import com.jfoenix.controls.JFXTreeView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;

public class Menu {

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
    private JFXTreeView<String> discordServerListing1; // Value injected by FXMLLoader

    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader

    private double xOffset = 0;
    private double yOffset = 0;
    //TODO Uncomment this when ready
    //private FileManager userDataFile = new FileManager(FileProperties.directories.JSON + "user.json");
    //private FileManager changeLogFile = new FileManager(FileProperties.directories.TEXT + "changelog.txt");
    //private User userData = new User(userDataFile);
    //private FileManager imageFolder = new FileManager("SavedImages");
    private AnchorPane tabToFadeOut;

    @FXML
    void animateSelectionIn(MouseEvent event) {
        Node node = (Node) event.getSource();
        AnchorPane pane = (AnchorPane) node;
        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(250), pane);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setByValue(1f);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    @FXML
    void animateSelectionOut(MouseEvent event) {
        Node node = (Node) event.getSource();
        AnchorPane pane = (AnchorPane) node;
        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(250), pane);
        fadeTransition.setFromValue(1f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    @FXML
    void closeApplication() {
        System.exit(0);
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    void getScene(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void minimizeApplication() {
        Stage stage = (Stage) minimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void moveScene(MouseEvent event) {
        Stage stage = (Stage) backgroundPage.getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    @FXML
    void selectScene(MouseEvent event) {
        Node node = (Node) event.getSource();
        System.out.println(node.getId());
        setScene(node.getId());
    }

    public void setScene(String path) {
        try {
            rootLayout.getChildren().removeAll(rootLayout.getChildren());
            System.out.println("Displaying sub pane: \nsample/" + path + ".fxml");
            AnchorPane newPane = FXMLLoader.load(Objects.requireNonNull(this.getClass().getClassLoader().getResource("sample/" + path + ".fxml")));
            System.out.println(newPane.getChildren().toString());
            rootLayout.getChildren().addAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (tabToFadeOut != null)
                new FadeOut(tabToFadeOut).play();
            Menu menu = this;
            Field f1 = menu.getClass().getDeclaredField(path + "Tab");
            AnchorPane tab = (AnchorPane) f1.get(menu);
            System.out.println(tab);
            new FadeIn(tab).play();
            tabToFadeOut = tab;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
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
