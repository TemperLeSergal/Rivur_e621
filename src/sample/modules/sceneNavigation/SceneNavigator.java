package sample.modules.sceneNavigation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneNavigator extends NavigationInfo {

    @FXML
    public static void loadScene(MouseEvent event, String page) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Pane mainPane = loader.load(
                    SceneNavigator.class.getResourceAsStream(
                            page
                    )
            );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            double Y = ((primScreenBounds.getHeight()) - stage.getHeight());
            if(Y < 0){
                Y = 0;
            }
            double X = ((primScreenBounds.getWidth()/2) - stage.getWidth());
            System.out.println("X: | " + primScreenBounds.getWidth() + " || Y: | " + primScreenBounds.getHeight());
            System.out.println("new X: | " + (X) + " || new Y: | " + Y);
            stage.setX(X);
            stage.setY(Y);

            stage.setScene(new Scene(mainPane));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
