package sample;

import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.InetAddress;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample/IntroPage.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Rivfur");
        stage.show();
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("media/images/white.png")));
        scene.getStylesheets().add(getClass().getResource("media/files/css/app.css").toExternalForm());
        System.out.println("Host Name: " + InetAddress.getLocalHost().toString().split("/")[0]);
        System.out.println("Host Address: " + InetAddress.getLocalHost().toString().split("/")[1]);
        new FadeIn(root).play();
    }
}
