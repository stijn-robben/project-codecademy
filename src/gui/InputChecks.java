package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputChecks {
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

    // check if email written the right way
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

    // check if input is Beginner, Gevorderd or Expert.
    public boolean checkLevel(String level) {
        if (level.equals("Beginner") || level.equals("Gevorderd") || level.equals("Expert")) {
            return true;
        }
        return false;
    }

    // grade must be between 1 and 10.
    public boolean checkGrade(String grade) {
        double gradeDouble = Double.valueOf(grade);
        if (gradeDouble <= 10 && gradeDouble >= 1) {
            return true;
        } else {
            return false;
        }
    }

    // checks if input zipcode is written the right way. (1234 AB)
    public boolean checkZipCode(String zipCode) {
        String regex = "^[1-9][0-9]{3}\\s[a-zA-Z]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zipCode);
        return matcher.matches();
    }

    // makes fields visable/unvisable
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
}
