package sample.modules.SceneNavigaton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneNavigator extends NavigationInfo {

    public static final String CallbackColor = "prevColor";
    public static final String CurrentColor = "nextColor";
    private static int[] prevColor;
    private static int[] nextColor;

    @FXML
    public static void loadScene(MouseEvent event, String page, boolean doFade) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Pane mainPane = loader.load(
                    SceneNavigator.class.getResourceAsStream(
                            page
                    )
            );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // OR
            // these two of them return the same stage
            // Swap screen

            stage.setScene(new Scene(mainPane));
            if (doFade) {
                //new FadeInLeft(stage.getScene().getRoot()).setSpeed(1000).play();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            // OR
            // these two of them return the same stage
            // Swap screen

            stage.setScene(new Scene(mainPane));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static String modifyBackground(Object node){
        if(node instanceof AnchorPane){
            //change pane background

            //((AnchorPane) node).setStyle(test.retriveBackground());
        }
        return backgroundGenerator.linearGradientAsStringGenerator();
    }*/

    public static void animateObject(Object node, String bg) {
        if (node instanceof AnchorPane) {
            System.out.println("pane");

        }
        //node.setBackground();
    }

    public static String animateBackground() {

        return null;
    }

    /*final Animation animation = new Transition() {

        {
            setCycleDuration(Duration.millis(1000));
            setInterpolator(Interpolator.EASE_OUT);
        }

        @Override
        protected void interpolate(double frac) {
            //Color vColor = new Color(1, 0, 0, 1 - frac);
            Stop[] stops = new Stop[] { new Stop(0, Color.rgb(0,102,102)), new Stop(1, Color.rgb(204,0,204))};
            LinearGradient vColor = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
            background.setBackground(new Background(new BackgroundFill(vColor, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    };
        animation.play();*/
}
