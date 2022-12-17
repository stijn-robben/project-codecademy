package gui;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
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
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class startGUI extends Application {
    Scene primaryScene;

    database.studentData studentData = new database.studentData();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Codecademy application");
        stage.getIcons().add(new Image("/resources/codecademyIcon.jpg"));
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
        borderPane.setPrefSize(600, 250);

        TextField value0 = new TextField();
        TextField value1 = new TextField();
        TextField value2 = new TextField();
        TextField value3 = new TextField();
        TextField value4 = new TextField();
        TextField value5 = new TextField();
        TextField value6 = new TextField();
        TextField value7 = new TextField();
        TextField output = new TextField();

        Label label0 = new Label("Initial email");
        Label label1 = new Label("Student email");
        Label label2 = new Label("Name");
        Label label3 = new Label("Date of birth");
        Label label4 = new Label("Gender");
        Label label5 = new Label("Address");
        Label label6 = new Label("City");
        Label label7 = new Label("Country");

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        Button primaryScene = new Button("Back to home");

        GridPane userInput = new GridPane();
        userInput.addRow(0, label0, value0);
        userInput.addRow(1, label1, value1);
        userInput.addRow(2, label2, value2);
        userInput.addRow(3, label3, value3);
        userInput.addRow(4, label4, value4);
        userInput.addRow(5, label5, value5);
        userInput.addRow(6, label6, value6);
        userInput.addRow(7, label7, value7);
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
                    // change input fields depending on radio select
                    if (s.equals("Create")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableTrue(value1);
                        setManagedAndVisableTrue(value2);
                        setManagedAndVisableTrue(value3);
                        setManagedAndVisableTrue(value4);
                        setManagedAndVisableTrue(value5);
                        setManagedAndVisableTrue(value6);
                        setManagedAndVisableTrue(value7);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableTrue(label1);
                        setLabelManagedAndVisableTrue(label2);
                        setLabelManagedAndVisableTrue(label3);
                        setLabelManagedAndVisableTrue(label4);
                        setLabelManagedAndVisableTrue(label5);
                        setLabelManagedAndVisableTrue(label6);
                        setLabelManagedAndVisableTrue(label7);
                    }
                    if (s.equals("Delete") || s.equals("Read")) {
                        setManagedAndVisableFalse(value0);
                        setManagedAndVisableTrue(value1);
                        setManagedAndVisableFalse(value2);
                        setManagedAndVisableFalse(value3);
                        setManagedAndVisableFalse(value4);
                        setManagedAndVisableFalse(value5);
                        setManagedAndVisableFalse(value6);
                        setManagedAndVisableFalse(value7);

                        setLabelManagedAndVisableFalse(label0);
                        setLabelManagedAndVisableTrue(label1);
                        setLabelManagedAndVisableFalse(label2);
                        setLabelManagedAndVisableFalse(label3);
                        setLabelManagedAndVisableFalse(label4);
                        setLabelManagedAndVisableFalse(label5);
                        setLabelManagedAndVisableFalse(label6);
                        setLabelManagedAndVisableFalse(label7);
                    }
                    if (s.equals("Update")) {
                        setManagedAndVisableTrue(value0);
                        setManagedAndVisableTrue(value1);
                        setManagedAndVisableTrue(value2);
                        setManagedAndVisableTrue(value3);
                        setManagedAndVisableTrue(value4);
                        setManagedAndVisableTrue(value5);
                        setManagedAndVisableTrue(value6);
                        setManagedAndVisableTrue(value7);

                        setLabelManagedAndVisableTrue(label0);
                        setLabelManagedAndVisableTrue(label1);
                        setLabelManagedAndVisableTrue(label2);
                        setLabelManagedAndVisableTrue(label3);
                        setLabelManagedAndVisableTrue(label4);
                        setLabelManagedAndVisableTrue(label5);
                        setLabelManagedAndVisableTrue(label6);
                        setLabelManagedAndVisableTrue(label7);
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
            value5.clear();
            value6.clear();
            value7.clear();
            output.clear();
        });

        submit.setOnAction((event) -> {
            RadioButton rb = (RadioButton) radioGroup.getSelectedToggle();
            String s = rb.getText();

            if (s.equals("Read")) {
                try {
                    output.setText(studentData.readStudent(value1.getText()));
                } catch (SQLException e) {
                    output.setText("Something went wrong...");
                }
            }

            if (s.equals("Create")) {
                try {
                    String date = formatDate(value3.getText());
                    boolean checkEmail = checkEmail(value1.getText());
                    boolean checkGender = checkGender(value4.getText());
                    if (date.equals("Incorrect date...")) {
                        output.setText("Incorrect date...");
                    }
                    if (checkEmail == false) {
                        output.setText("Incorrect email...");
                    }
                    if (checkGender == false) {
                        output.setText("Make sure the gender is written in the following way: M or F.");
                    }
                    if (!date.equals("Incorrect date...") && checkEmail == true && checkGender == true) {
                        output.setText(studentData.createStudent(value1.getText(), value2.getText(),
                                date,
                                value4.getText(), value5.getText(), value6.getText(), value7.getText()));
                    }
                } catch (Exception e) {
                    output.setText("Something went wrong...");
                }
            }

            if (s.equals("Delete")) {
                try {
                    output.setText(studentData.deleteStudent(value1.getText()));
                } catch (SQLException e) {
                    output.setText("Something went wrong...");
                }
            }

            if (s.equals("Update")) {
                try {
                    String date = formatDate(value3.getText());
                    boolean checkEmail = checkEmail(value1.getText());
                    boolean checkGender = checkGender(value4.getText());
                    if (date.equals("Incorrect date...")) {
                        output.setText("Incorrect date...");
                    }
                    if (checkEmail == false) {
                        output.setText("Incorrect email...");
                    }
                    if (checkGender == false) {
                        output.setText("Make sure the gender is written in the following way: M or F.");
                    }
                    if (!date.equals("Incorrect date...") && checkEmail == true && checkGender == true) {
                        output.setText(
                                studentData.updateStudent(value0.getText(), value1.getText(), value2.getText(), date,
                                        value4.getText(), value5.getText(), value6.getText(), value7.getText()));
                    }

                } catch (Exception e) {
                    output.setText("Something went wrong...");
                }
            }
        });

        primaryScene.setOnAction((event) -> {
            primaryScene(stage);
        });

        borderPane.setBottom(output);
        borderPane.setLeft(radio);
        borderPane.setRight(userInput);
        borderPane.setTop(primaryScene);

        Scene secondaryScene = new Scene(borderPane);
        stage.setScene(secondaryScene);
    }

    public TextField setManagedAndVisableTrue(TextField value) {
        value.setManaged(true);
        value.setVisible(true);
        return value;
    }

    public TextField setManagedAndVisableFalse(TextField value) {
        value.setManaged(false);
        value.setVisible(false);
        return value;
    }

    public Label setLabelManagedAndVisableTrue(Label label) {
        label.setManaged(true);
        label.setVisible(true);
        return label;
    }

    public Label setLabelManagedAndVisableFalse(Label label) {
        label.setManaged(false);
        label.setVisible(false);
        return label;
    }

    // If user inputs DD-MM-YYYY it will format it to YYYY-MM-DD, if user inputs
    // YYYY-MM-DD it will return just return it.
    public String formatDate(String date) throws ParseException {
        String str = date;
        String[] arrOfStr = str.split("-", -1);
        if (arrOfStr[0].length() == 2) {
            try {
                String startDateString = date;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                return sdf2.format(sdf.parse(startDateString));
            } catch (Exception e) {
                return "Something went wrong!";
            }
        } else if (arrOfStr[0].length() == 2) {
            return date;
        }
        return "Incorrect date...";
    }

    public boolean checkEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]*@[a-zA-Z0-9]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean checkGender(String gender) {
        if (gender.length() == 1) {
            return true;
        }
        return false;
    }
}
