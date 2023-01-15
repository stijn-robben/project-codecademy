package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseScene extends InputChecks {
    database.CourseData courseData = new database.CourseData();

    public void courseScene(Stage stage) {
        PrimaryScene primaryScene = new PrimaryScene();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 250);

        TextField value4 = new TextField();
        TextField value0 = new TextField();
        TextField value1 = new TextField();
        TextField value2 = new TextField();
        TextField value3 = new TextField();
        TextField output = new TextField();

        Label label4 = new Label("Initial course name");
        Label label0 = new Label("Course name");
        Label label1 = new Label("Subject");
        Label label2 = new Label("Introduction Text");
        Label label3 = new Label("Level");

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        Button toPrimaryScene = new Button("Back to home");

        GridPane userInput = new GridPane();
        userInput.addRow(0, label4, value4);
        userInput.addRow(1, label0, value0);
        userInput.addRow(2, label1, value1);
        userInput.addRow(3, label2, value2);
        userInput.addRow(4, label3, value3);
        userInput.setHgap(10);
        userInput.setVgap(10);
        userInput.setPadding(new Insets(10, 10, 10, 10));

        ToggleGroup radioGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Create");
        rb1.setToggleGroup(radioGroup);
        RadioButton rb2 = new RadioButton("Read");
        rb2.setToggleGroup(radioGroup);
        RadioButton rb3 = new RadioButton("Update");
        rb3.setToggleGroup(radioGroup);
        RadioButton rb4 = new RadioButton("Delete");
        rb4.setToggleGroup(radioGroup);

        // styling
        value0.setId("text-area-style");
        value1.setId("text-area-style");
        value2.setId("text-area-style");
        value3.setId("text-area-style");
        value4.setId("text-area-style");
        output.setId("text-area-style");

        HBox buttons = new HBox();
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setSpacing(10);
        buttons.getChildren().addAll(submit, clear);

        VBox radio = new VBox(20, rb1, rb2, rb3, rb4, buttons);
        radio.setPadding(new Insets(10, 10, 10, 10));

        output.setEditable(false);
        output.setPadding(new Insets(10, 10, 10, 10));

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
                RadioButton rb = (RadioButton) radioGroup.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();
                    if (s.equals("Create")) {
                        setManagedAndVisableFalse(value4);
                        setManagedAndVisableTrue(value0);
                        setManagedAndVisableTrue(value1);
                        setManagedAndVisableTrue(value2);
                        setManagedAndVisableTrue(value3);

                        setLabelManagedAndVisableFalse(label4);
                        setLabelManagedAndVisableTrue(label0);
                        setLabelManagedAndVisableTrue(label1);
                        setLabelManagedAndVisableTrue(label2);
                        setLabelManagedAndVisableTrue(label3);
                    }
                    if (s.equals("Delete") || s.equals("Read")) {
                        setManagedAndVisableFalse(value4);
                        setManagedAndVisableTrue(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableFalse(value3);

                        setLabelManagedAndVisableFalse(label4);
                        setLabelManagedAndVisableTrue(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableFalse(label2);
                        setLabelManagedAndVisableFalse(label3);
                    }
                    if (s.equals("Update")) {
                        setManagedAndVisableTrue(value4);
                        setManagedAndVisableTrue(value0);
                        setManagedAndVisableTrue(value1);
                        setManagedAndVisableTrue(value2);
                        setManagedAndVisableTrue(value3);

                        setLabelManagedAndVisableTrue(label4);
                        setLabelManagedAndVisableTrue(label0);
                        setLabelManagedAndVisableTrue(label1);
                        setLabelManagedAndVisableTrue(label2);
                        setLabelManagedAndVisableTrue(label3);
                    }
                }
            }

        });

        clear.setOnAction((event) -> {
            value0.clear();
            value1.clear();
            value2.clear();
            value3.clear();
            value4.clear();
            output.clear();
        });

        submit.setOnAction((event) -> {
            RadioButton rb = (RadioButton) radioGroup.getSelectedToggle();
            String s = rb.getText();

            if (s.equals("Read")) {
                try {
                    output.setText(courseData.readCourse(value0.getText()));
                } catch (Exception e) {
                    output.setText("Something went wrong...");
                }
            }

            if (s.equals("Create")) {
                try {
                    boolean level = checkLevel(value3.getText());
                    if (!level) {
                        output.setText("Make sure level is either Beginner, Gevorders or Expert.");
                    }
                    if (level) {
                        output.setText(courseData.createCourse(value0.getText(), value1.getText(), value2.getText(),
                                value3.getText()));
                    }
                } catch (Exception e) {
                    output.setText("Something went wrong...");
                }
            }

            if (s.equals("Delete")) {
                try {
                    output.setText(courseData.deleteCourse(value0.getText()));
                } catch (Exception e) {
                    output.setText("Something went wrong...");
                }
            }

            if (s.equals("Update")) {
                try {
                    boolean level = checkLevel(value3.getText());
                    if (!level) {
                        output.setText("Make sure level is either Beginner, Gevorders or Expert.");
                    }
                    if (level) {
                        output.setText(courseData.updateCourse(value4.getText(), value0.getText(), value1.getText(),
                                value2.getText(), value3.getText()));
                    }

                } catch (Exception e) {
                    output.setText("Something went wrong...");
                }
            }
        });

        toPrimaryScene.setOnAction((event) -> {
            primaryScene.primaryScene(stage);
        });

        borderPane.setBottom(output);
        borderPane.setLeft(radio);
        borderPane.setRight(userInput);
        borderPane.setTop(toPrimaryScene);

        Scene courseScene = new Scene(borderPane);
        courseScene.getStylesheets().add("/resources/stylesheet.css");
        stage.setScene(courseScene);
    }
}
