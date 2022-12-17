package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
