/*
  Sample Skeleton for 'IntroPage.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sample.modules.fileManager.FileManager;
import sample.modules.fileManager.FileProperties;
import sample.modules.sceneNavigation.SceneNavigator;

import java.io.IOException;

public class IntroPage {

    @FXML // fx:id="toRemove"
    private AnchorPane toRemove; // Value injected by FXMLLoader

    @FXML // fx:id="toRemove1"
    private AnchorPane toRemove1; // Value injected by FXMLLoader

    @FXML // fx:id="greetText1"
    private Text greetText1; // Value injected by FXMLLoader

    @FXML // fx:id="greetText"
    private Text greetText; // Value injected by FXMLLoader

    @FXML // fx:id="fadeAnchor"
    private AnchorPane fadeAnchor; // Value injected by FXMLLoader

    @FXML // fx:id="signInButton"
    private JFXButton signInButton; // Value injected by FXMLLoader

    @FXML // fx:id="signUpButton"
    private JFXButton signUpButton; // Value injected by FXMLLoader

    private FileManager userDataFile = new FileManager(FileProperties.directories.JSON + "user.json");

    @FXML
    public void signup() {
        System.exit(0);
    }

    @FXML
    public void signin(MouseEvent event) {
        SceneNavigator.loadScene(event, SceneNavigator.SUB_MAIN_MENU_PAGE, true);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert toRemove != null : "fx:id=\"toRemove\" was not injected: check your FXML file 'IntroPage.fxml'.";
        assert toRemove1 != null : "fx:id=\"toRemove1\" was not injected: check your FXML file 'IntroPage.fxml'.";
        assert greetText1 != null : "fx:id=\"greetText1\" was not injected: check your FXML file 'IntroPage.fxml'.";
        assert greetText != null : "fx:id=\"greetText\" was not injected: check your FXML file 'IntroPage.fxml'.";
        assert fadeAnchor != null : "fx:id=\"fadeAnchor\" was not injected: check your FXML file 'IntroPage.fxml'.";
        assert signInButton != null : "fx:id=\"signInButton\" was not injected: check your FXML file 'IntroPage.fxml'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'IntroPage.fxml'.";
        if (userDataFile.isEmpty()) {
            System.out.println("User is empty, creating new JSON file.");
            try {
                new FileManager(FileProperties.directories.TEXT + "JSONTemplate.txt").copyFileContents(userDataFile.getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
