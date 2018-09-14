
/**
 * Sample Skeleton for 'menu.fxml' Controller Class
 */

package sample.modules;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeOut;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.modules.fileManager.FileManager;
import sample.modules.jsonManager.User;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static sample.modules.webPageManager.WebPageAccess.openWebpage;

public class Menu implements Initializable {

    @FXML
    public AnchorPane DiscordManagementTab;
    @FXML
    public AnchorPane SettingsTab;
    @FXML
    public AnchorPane AdvancedSettingsTab;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="backgroundPage"
    private AnchorPane backgroundPage; // Value injected by FXMLLoader
    @FXML // fx:id="close"
    private ImageView close; // Value injected by FXMLLoader
    @FXML // fx:id="minimize"
    private AnchorPane minimize; // Value injected by FXMLLoader
    @FXML // fx:id="rootLayout"
    private AnchorPane rootLayout; // Value injected by FXMLLoader
    @FXML // fx:id="rootLayout"
    private JFXTreeView<String> discordServerListing;
    private AnchorPane tabToFadeOut;

    private JFXTextField lastKnownJFXTextField = null;

    private String lastKnownJFXTextFieldPromptText = "";

    private FileManager userDataFile = new FileManager("userData.json");
    private FileManager changeLogFile = new FileManager("changelog.txt");
    private User userData = new User("userData.json");
    private FileManager emailPage = new FileManager("emailPage.html");
    private FileManager imageFolder = new FileManager("SavedImages");


    @FXML
    void selectScene(MouseEvent event) {
        Node node = (Node) event.getSource();
        System.out.println(node.getId());
        setScene(node.getId(), event);
    }

    public void setScene(String path, MouseEvent event) {
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
            Field f1 = menu.getClass().getField(path + "Tab");
            AnchorPane tab = (AnchorPane) f1.get(menu);
            System.out.println(tab);
            new FadeIn(tab).play();
            tabToFadeOut = tab;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void animateSelectionIn(MouseEvent event) {
        System.out.println("entered");
        Node node = (Node) event.getSource();
        String nodeID = node.getId();
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
        System.out.println("left");
        Node node = (Node) event.getSource();
        String nodeID = node.getId();
        AnchorPane pane = (AnchorPane) node;
        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(250), pane);
        fadeTransition.setFromValue(1f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    @FXML
    void closeApplication(MouseEvent event) {
        System.exit(0);
        Stage stage = (Stage) close.getScene().getWindow();
        // do what you have to do
        //database.close();
        stage.close();
    }

    @FXML
    void getScene(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void moveScene(MouseEvent event) {
        Stage stage = (Stage) backgroundPage.getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    @FXML
    void minimizeApplication(MouseEvent event) {
        Stage stage = (Stage) minimize.getScene().getWindow();
        stage.setIconified(true);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert backgroundPage != null : "fx:id=\"backgroundPage\" was not injected: check your FXML file 'menu.fxml'.";
        assert close != null : "fx:id=\"close\" was not injected: check your FXML file 'menu.fxml'.";
        assert minimize != null : "fx:id=\"minimize\" was not injected: check your FXML file 'menu.fxml'.";
        assert rootLayout != null : "fx:id=\"rootLayout\" was not injected: check your FXML file 'menu.fxml'.";
        if (userDataFile.isEmpty()) {
            System.out.println("EMPTY!!!!!!!!!!!!!!!!!!!!!!");
            try {
                userDataTemplateFile.copyFile(userDataFile.getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}


/**
 * This part is meant for discord Management
 * <p>
 * When it comes to the tree list for servers, use a treeMap for the name and corresponding image. If an image is not
 * available, use initials overlaid with a semi Transparent grey background.
 * <p>
 * The options available for
 **/

