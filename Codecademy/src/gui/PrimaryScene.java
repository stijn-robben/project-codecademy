package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimaryScene {
    public void primaryScene(Stage stage) {
        StudentScene studentScene = new StudentScene();
        Scene primaryScene;
        Label label1 = new Label("This is the first scene when you open our application.");
        Button button1 = new Button("Go to student CRUD");
        button1.setOnAction(e -> studentScene.studentScene(stage));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        primaryScene = new Scene(layout1, 300, 250);
        stage.setScene(primaryScene);
        stage.show();
    }

}
