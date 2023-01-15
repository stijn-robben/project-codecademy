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
        borderPane.setPrefSize(700, 250);
        StudentScene studentScene = new StudentScene();
        CourseScene courseScene = new CourseScene();
        EnrollmentScene enrollmentScene = new EnrollmentScene();
        CertificateScene certificateScene = new CertificateScene();
        OverviewsScene overviewsScene = new OverviewsScene();
        Scene primaryScene;
        Label label1 = new Label(
                "Choose one of the options to create, read, update or delete things in the database!");
        Button button1 = new Button("Student CRUD");
        Button button2 = new Button("Course CRUD");
        Button button3 = new Button("Enrollment CRUD");
        Button button4 = new Button("Certificate CRUD");
        Button button5 = new Button("Overviews");
        button1.setOnAction(e -> studentScene.studentScene(stage));
        button2.setOnAction(e -> courseScene.courseScene(stage));
        button3.setOnAction(e -> enrollmentScene.enrollmentScene(stage));
        button4.setOnAction(e -> certificateScene.certificateScene(stage));
        button5.setOnAction(e -> overviewsScene.overviewsScene(stage));
        button1.setMinHeight(80);
        button2.setMinHeight(80);
        button3.setMinHeight(80);
        button4.setMinHeight(80);
        button5.setMinHeight(80);
        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(button1, button2, button3, button4, button5);
        borderPane.setTop(label1);
        borderPane.setCenter(buttons);
        primaryScene = new Scene(borderPane, 700, 250);
        primaryScene.getStylesheets().add(getClass().getResource("/resources/stylesheet.css").toExternalForm());
        stage.setScene(primaryScene);
        stage.show();
    }
}
