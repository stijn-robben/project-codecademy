package gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class startGUI extends Application {
    Scene primaryScene;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Codecademy application");
        primaryScene(stage);
    }

    public void primaryScene(Stage stage) {
        // Primary scene
        Label label1 = new Label("This is the first scene when you open our application.");
        Button button1 = new Button("Go to student CRUD");
        button1.setOnAction(e -> studentScene(stage));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        primaryScene = new Scene(layout1, 300, 250);
        stage.setScene(primaryScene);
        stage.show();
    }

    public void studentScene(Stage stage) {
        BorderPane borderPane = new BorderPane();

        TextField value1 = new TextField();
        TextField value2 = new TextField();
        TextField value3 = new TextField();
        TextField value4 = new TextField();
        TextField value5 = new TextField();
        TextField value6 = new TextField();
        TextField value7 = new TextField();

        Label label1 = new Label("Student email");
        Label label2 = new Label("Name");
        Label label3 = new Label("Date of birth");
        Label label4 = new Label("Gender");
        Label label5 = new Label("Address");
        Label label6 = new Label("City");
        Label label7 = new Label("Country");

        GridPane userInput = new GridPane();
        userInput.addRow(0, label1, value1);
        userInput.addRow(1, label2, value2);
        userInput.addRow(2, label3, value3);
        userInput.addRow(3, label4, value4);
        userInput.addRow(4, label5, value5);
        userInput.addRow(5, label6, value6);
        userInput.addRow(6, label7, value7);

        ToggleGroup radioGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Create");
        rb1.setToggleGroup(radioGroup);
        RadioButton rb2 = new RadioButton("Read");
        rb2.setToggleGroup(radioGroup);
        RadioButton rb3 = new RadioButton("Update");
        rb3.setToggleGroup(radioGroup);
        RadioButton rb4 = new RadioButton("Delete");
        rb3.setToggleGroup(radioGroup);
        VBox radio = new VBox(20, rb1, rb2, rb3, rb4);

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {

                RadioButton rb = (RadioButton) radioGroup.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();
                    if (s.equals("Create")) {
                    }
                }
            }
        });

        borderPane.setLeft(radio);
        borderPane.setRight(userInput);

        Scene secondaryScene = new Scene(borderPane);
        stage.setScene(secondaryScene);
    }

}
