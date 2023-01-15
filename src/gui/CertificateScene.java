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

public class CertificateScene extends InputChecks {
    database.CertificateData certificateData = new database.CertificateData();

    public void certificateScene(Stage stage) {
        PrimaryScene primaryScene = new PrimaryScene();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 250);

        TextField value0 = new TextField();
        TextField value1 = new TextField();
        TextField value2 = new TextField();
        TextField value3 = new TextField();
        TextField value4 = new TextField();
        TextField output = new TextField();

        Label label0 = new Label("Certificate ID");
        Label label1 = new Label("Course name");
        Label label2 = new Label("Grade");
        Label label3 = new Label("Employee name");
        Label label4 = new Label("Student email");

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        Button toPrimaryScene = new Button("Back to home");

        GridPane userInput = new GridPane();
        userInput.addRow(1, label0, value0);
        userInput.addRow(2, label1, value1);
        userInput.addRow(3, label2, value2);
        userInput.addRow(4, label3, value3);
        userInput.addRow(5, label4, value4);

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
                        setManagedAndVisableTrue(value0);
                        setManagedAndVisableTrue(value1);
                        setManagedAndVisableTrue(value2);
                        setManagedAndVisableTrue(value3);
                        setManagedAndVisableTrue(value4);

                        setLabelManagedAndVisableTrue(label0);
                        setLabelManagedAndVisableTrue(label1);
                        setLabelManagedAndVisableTrue(label2);
                        setLabelManagedAndVisableTrue(label3);
                        setLabelManagedAndVisableTrue(label4);
                    }
                    if (s.equals("Read")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableFalse(value3);
                        setManagedAndVisableTrue(value4);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableFalse(label2);
                        setLabelManagedAndVisableFalse(label3);
                        setLabelManagedAndVisableTrue(label4);
                    }
                    if (s.equals("Delete")) {
                        setManagedAndVisableTrue(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableFalse(value3);
                        setManagedAndVisableFalse(value4);

                        setLabelManagedAndVisableTrue(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableFalse(label2);
                        setLabelManagedAndVisableFalse(label3);
                        setLabelManagedAndVisableFalse(label4);
                    }
                    if (s.equals("Update")) {
                        setManagedAndVisableTrue(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableTrue(value2);
                        setManagedAndVisableTrue(value3);
                        setManagedAndVisableFalse(value4);

                        setLabelManagedAndVisableTrue(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableTrue(label2);
                        setLabelManagedAndVisableTrue(label3);
                        setLabelManagedAndVisableFalse(label4);
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

            if (s.equals("Create")) {
                try {
                    if (!checkGrade(value2.getText())) {
                        output.setText("Make sure the grade is between 1 and 10!");
                    } else {
                        output.setText(certificateData.createCertificate(value0.getText(), value2.getText(),
                                value3.getText(), value1.getText(), value4.getText()));
                    }
                } catch (Exception e) {
                    output.setText("Make sure that the course and student are in the database!");
                }
            }

            if (s.equals("Read")) {
                try {
                    output.setText(certificateData.readCertificate(value4.getText()));
                } catch (Exception e) {
                    output.setText("Make sure that the student is in the database!");
                }
            }

            if (s.equals("Update")) {
                try {
                    if (!checkGrade(value2.getText())) {
                        output.setText("Make sure the grade is between 1 and 10!");
                    } else {
                        output.setText(certificateData.updateCertificate(value0.getText(), value2.getText(),
                                value3.getText()));
                    }
                } catch (Exception e) {
                }
            }

            if (s.equals("Delete")) {
                try {
                    output.setText(certificateData.deleteCertificate(value0.getText()));
                } catch (Exception e) {
                    System.out.println(e);
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

        Scene enrollmentScene = new Scene(borderPane);
        enrollmentScene.getStylesheets().add("/resources/stylesheet.css");
        stage.setScene(enrollmentScene);
    }

}
