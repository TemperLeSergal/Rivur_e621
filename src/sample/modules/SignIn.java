package sample.modules;

/**
 * Sample Skeleton for 'splashpage.fxml' Controller Class
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sample.modules.SceneNavigaton.SceneNavigator;

import java.net.URL;
import java.util.ResourceBundle;

public class SignIn {

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

    @FXML // fx:id="usernameTextField"
    private JFXTextField usernameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordTextField"
    private JFXPasswordField passwordTextField; // Value injected by FXMLLoader

    @FXML // fx:id="rememberMeToggleButton"
    private JFXToggleButton rememberMeToggleButton; // Value injected by FXMLLoader

    @FXML // fx:id="signInButton"
    private JFXButton signInButton; // Value injected by FXMLLoader

    @FXML // fx:id="signUpButton"
    private JFXButton signUpButton; // Value injected by FXMLLoader

    @FXML // fx:id="forgotPassword"
    private Text forgotPassword; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        //rememberMeToggleButton.disarm();
    }

    @FXML
    public void signup(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    public void signin(MouseEvent event) {
        SceneNavigator.loadScene(event, SceneNavigator.SUB_MAIN_MENU_PAGE, true);
    }
}
