/**
 * Sample Skeleton for 'IntroPage.fxml' Controller Class
 */

package sample.modules;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class IntroPage {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

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

    @FXML
    void signin(MouseEvent event) {

    }

    @FXML
    void signup(MouseEvent event) {

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

    }
}
