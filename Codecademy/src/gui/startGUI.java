package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StartGUI extends Application {
    Scene primaryScene;

    @Override
    public void start(Stage stage) throws Exception {
        PrimaryScene primaryScene = new PrimaryScene();
        stage.setTitle("Codecademy application");
        stage.getIcons().add(new Image("/resources/codecademyIcon.jpg"));
        primaryScene.primaryScene(stage);
    }
}
