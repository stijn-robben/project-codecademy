package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimaryScene {
    public void primaryScene(Stage stage) {
        StudentScene studentScene = new StudentScene();
        CourseScene courseScene = new CourseScene();
        Scene primaryScene;
        Label label1 = new Label("This is the first scene when you open our application.");
        Button button1 = new Button("Go to student CRUD");
        Button button2 = new Button("Go to course CRUD");
        button1.setOnAction(e -> studentScene.studentScene(stage));
        button2.setOnAction(e -> courseScene.courseScene(stage));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button2);
        primaryScene = new Scene(layout1, 300, 250);
        primaryScene.getStylesheets().add(getClass().getResource("/resources/stylesheet.css").toExternalForm());
        stage.setScene(primaryScene);
        stage.show();
    }

}
