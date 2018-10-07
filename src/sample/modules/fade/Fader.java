package sample.modules.fade;

import javafx.scene.Node;
import javafx.util.Duration;

public class Fader {
    public void fadeIn(Node node) {
        javafx.animation.FadeTransition fadeTransition =
                new javafx.animation.FadeTransition(Duration.millis(250), node);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setByValue(1f);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    public void fadeOut(Node node) {
        javafx.animation.FadeTransition fadeTransition =
                new javafx.animation.FadeTransition(Duration.millis(250), node);
        fadeTransition.setFromValue(1f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }
}
