package sample.modules;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.modules.webPageManager.WebPageAccess.openWebpage;

public class e621Downloader implements Initializable {

    @FXML
    AnchorPane furryHavenInviteButton;

    @FXML
    ImageView buttonGraphic;

    @FXML
    public void buttonTest() {
        System.out.println("Button on menu was pushed!");
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
        Image image = new Image(getClass().getClassLoader().getResourceAsStream("sample/media/images/fhIcon.jpg"));
        System.out.println(image.getUrl());
        //buttonGraphic = new ImageView(image);
        //buttonGraphic.setPreserveRatio(true);
        BackgroundSize backgroundSize = new BackgroundSize(furryHavenInviteButton.getWidth(), furryHavenInviteButton.getHeight(), false, false, true, false);
        furryHavenInviteButton.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }
}
