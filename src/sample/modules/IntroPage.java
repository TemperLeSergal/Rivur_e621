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
import sample.modules.fileManager.FolderManager;
import sample.modules.jsonManager.User;
import sample.modules.sceneNavigation.SceneNavigator;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

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

    private FileManager userDataFile = new FileManager("user.json");
    private User userData = new User(userDataFile);
    private FileManager imageDownloadLog = new FileManager("imageDownloadLog.txt");

    @FXML
    public void signup() {
        System.exit(0);
    }

    @FXML
    public void signin(MouseEvent event) {
        SceneNavigator.loadScene(event, SceneNavigator.SUB_MAIN_MENU_PAGE);
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
            userDataFile.appendToFile("{\"profileSettings\":{\"password\":\"\",\"rememberMe\":true,\"FlistCharacterName\":\"\",\"username\":\"\"},\"discordSettings\":{\"server name\":{\"rank\":0,\"xp\":0,\"useDefE621Blacklist\":true,\"discordBlacklist\":[],\"infractions\":{\"serverName\":{\"serverID\":1222134,\"infractionID\":{}},\"serverName2\":{\"serverID\":1222135,\"infractionID\":{},\"infractionID2\":{}}}}},\"e621Settings\":{\"blacklist\":[\"gore\",\"death\",\"young\",\"torture\",\"ball_busting\",\"female\",\"fat\",\"scat\",\"fart\",\"redrusker\",\"horse\",\"equine\",\"donkey\",\"zebra\",\"mlp\",\"breasts\",\"cub\"],\"blacklistPriorityOne\":[],\"whitelistPriorityOne\":[],\"useBlacklist\":true,\"allowNSFW\":true,\"score\":50,\"favoriteArtists\":[],\"favoriteTags\":[],\"imageSaveLocation\":\"\"},\"fListSettings\":{\"characters\":[]}}");
        }

        FolderManager savedImages = new FolderManager("savedImages");
        userData.setValue(User.IMAGE_SAVE_LOCATION, savedImages.getFolder().getPath()+"/");
        ArrayList<String> added = new ArrayList<>();
        added.addAll(Arrays.asList(imageDownloadLog.readFromFile(FileProperties.string.STRING).split(",")));
        added.forEach(s -> System.out.println(s));
    }
}
