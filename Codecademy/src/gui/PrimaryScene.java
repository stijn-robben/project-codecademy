package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PrimaryScene {
    public void primaryScene(Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 250);
        StudentScene studentScene = new StudentScene();
        CourseScene courseScene = new CourseScene();
        EnrollmentScene enrollmentScene = new EnrollmentScene();
        Scene primaryScene;
        Label label1 = new Label("This is the first scene when you open our application.");
        Button button1 = new Button("Go to student CRUD");
        Button button2 = new Button("Go to course CRUD");
        Button button3 = new Button("Go to enrollment CRUD");
        button1.setOnAction(e -> studentScene.studentScene(stage));
        button2.setOnAction(e -> courseScene.courseScene(stage));
        button3.setOnAction(e -> enrollmentScene.enrollmentScene(stage));
        button1.setMinHeight(80);
        button2.setMinHeight(80);
        button3.setMinHeight(80);
        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(button1, button2, button3);
        borderPane.setTop(label1);
        borderPane.setCenter(buttons);
        primaryScene = new Scene(borderPane, 600, 250);
        primaryScene.getStylesheets().add(getClass().getResource("/resources/stylesheet.css").toExternalForm());
        stage.setScene(primaryScene);
        stage.show();
    }
}
