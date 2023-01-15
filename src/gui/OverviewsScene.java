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

public class OverviewsScene extends InputChecks {
    database.OverviewsData overviewsData = new database.OverviewsData();

    public void overviewsScene(Stage stage) {
        PrimaryScene primaryScene = new PrimaryScene();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 250);

        TextField value4 = new TextField();
        TextField value0 = new TextField();
        TextField value1 = new TextField();
        TextField value2 = new TextField();
        TextField value3 = new TextField();

        TextField output = new TextField();

        Label label4 = new Label("Webcast title");
        Label label0 = new Label("Module title");
        Label label1 = new Label("Gender");
        Label label2 = new Label("Student email");
        Label label3 = new Label("Course name");

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
        RadioButton rb1 = new RadioButton(
                "Percentage van de cursisten van bepaald gender die een certificaat behaald heeft");
        rb1.setToggleGroup(radioGroup);
        RadioButton rb2 = new RadioButton("Gemiddelde voortgang van een module voor alle accounts");
        rb2.setToggleGroup(radioGroup);
        RadioButton rb3 = new RadioButton("Gemiddelde voortgang van alle modules van één account");
        rb3.setToggleGroup(radioGroup);
        RadioButton rb4 = new RadioButton("Top 3 meest bekeken webcasts ContentID");
        rb4.setToggleGroup(radioGroup);
        RadioButton rb5 = new RadioButton("Top 3 cursussen met meest uitgegeven certificaten");
        rb5.setToggleGroup(radioGroup);
        RadioButton rb6 = new RadioButton("Percentage cursus gehaald");
        rb6.setToggleGroup(radioGroup);

        // styling
        value0.setId("text-area-style");
        value1.setId("text-area-style");
        value2.setId("text-area-style");
        value3.setId("text-area-style");
        output.setId("text-area-style");
        value4.setId("text-area-style");

        HBox buttons = new HBox();
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setSpacing(10);
        buttons.getChildren().addAll(submit, clear);

        VBox radio = new VBox(20, rb1, rb2, rb3, rb4, rb5, rb6, buttons);
        radio.setPadding(new Insets(10, 10, 10, 10));

        output.setEditable(false);
        output.setPadding(new Insets(10, 10, 10, 10));

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
                RadioButton rb = (RadioButton) radioGroup.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();
                    if (s.equals("Percentage van de cursisten van bepaald gender die een certificaat behaald heeft")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableTrue(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableTrue(value3);
                        setManagedAndVisableFalse(value4);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableTrue(label1);
                        setLabelManagedAndVisableFalse(label2);
                        setLabelManagedAndVisableTrue(label3);
                        setLabelManagedAndVisableFalse(label4);
                    }
                    if (s.equals("Gemiddelde voortgang van een module voor alle accounts")) {
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
                    if (s.equals("Gemiddelde voortgang van alle modules van één account")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableTrue(value2);
                        setManagedAndVisableFalse(value3);
                        setManagedAndVisableFalse(value4);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableTrue(label2);
                        setLabelManagedAndVisableFalse(label3);
                        setLabelManagedAndVisableFalse(label4);
                    }
                    if (s.equals("Top 3 meest bekeken webcasts ContentID")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableFalse(value3);
                        setManagedAndVisableFalse(value4);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableFalse(label2);
                        setLabelManagedAndVisableFalse(label3);
                        setLabelManagedAndVisableFalse(label4);
                    }
                    if (s.equals("Top 3 cursussen met meest uitgegeven certificaten")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableFalse(value3);
                        setManagedAndVisableFalse(value4);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableFalse(label2);
                        setLabelManagedAndVisableFalse(label3);
                        setLabelManagedAndVisableFalse(label4);
                    }
                    if (s.equals("Percentage cursus gehaald")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableFalse(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableTrue(value3);
                        setManagedAndVisableFalse(value4);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableFalse(label1);
                        setLabelManagedAndVisableFalse(label2);
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

            if (s.equals("Percentage van de cursisten van bepaald gender die een certificaat behaald heeft")) {
                try {
                    output.setText(overviewsData.getOverview1(value1.getText(), value3.getText()));
                } catch (Exception e) {
                    output.setText("Something went wrong... Make sure that the input values exist in the database.");
                }
            }

            if (s.equals("Gemiddelde voortgang van een module voor alle accounts")) {
                try {
                    output.setText(overviewsData.getOverview2(value0.getText()));
                } catch (Exception e) {
                    output.setText("Something went wrong... Make sure that the input values exist in the database.");
                }
            }

            if (s.equals("Gemiddelde voortgang van alle modules van één account")) {
                try {
                    output.setText(overviewsData.getOverview3(value2.getText()));
                } catch (Exception e) {
                    output.setText("Something went wrong... Make sure that the input values exist in the database.");
                }
            }

            if (s.equals("Percentage cursus gehaald")) {
                try {
                    output.setText(overviewsData.getOverview4(value2.getText()));
                } catch (Exception e) {
                    output.setText("Something went wrong... Make sure that the input values exist in the database.");
                }
            }

            if (s.equals("Top 3 meest bekeken webcasts ContentID")) {
                try {
                    output.setText(overviewsData.getOverview5());
                } catch (Exception e) {
                    output.setText("Something went wrong... Make sure that the input values exist in the database.");
                }
            }

            if (s.equals("Top 3 cursussen met meest uitgegeven certificaten")) {
                try {
                    output.setText(overviewsData.getOverview6());
                } catch (Exception e) {
                    output.setText("Something went wrong... Make sure that the input values exist in the database.");
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

        Scene overviewsScene = new Scene(borderPane);
        overviewsScene.getStylesheets().add("/resources/stylesheet.css");
        stage.setScene(overviewsScene);
    }
}
