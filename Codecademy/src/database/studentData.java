package database;

import java.sql.*;

public class StudentData extends Connection {
    public String createStudent(String studentEmail, String name, String dateOfBirth, String gender, String address,
            String city, String country, String zipCode) throws SQLException {
        String SQL = "INSERT INTO Student VALUES ('" + studentEmail + "', '" + name + "', '" + dateOfBirth + "', '"
                + gender + "', '" + address + "', '" + city + "', '" + country + "', '" + zipCode + "')";
        return super.runQuery(SQL, false, "Student");
    }

    public String readStudent(String email) throws SQLException {
        String SQL = "SELECT * FROM Student WHERE StudentEmail = '" + email + "';";
        return super.runQuery(SQL, true, "Student");
    }

    public String updateStudent(String initialEmail, String email, String name, String dateOfBirth, String gender,
            String address,
            String city, String country, String zipCode) throws SQLException {
        readStudent(initialEmail);
        String SQL = "UPDATE Student SET StudentEmail = '" + email + "', Name = '" + name + "', DateOfBirth = '"
                + dateOfBirth + "', Gender = '" + gender + "', Address = '" + address + "', City = '" + city
                + "', Country =  '" + country + "', ZipCode = '" + zipCode + "' WHERE StudentEmail = '" + initialEmail
                + "';";
        if (readStudent(initialEmail).equals("The specified e-mail address does not appear in the database.")) {
            return "The specified e-mail address does not appear in the database.";
        }
        return super.runQuery(SQL, false, "Student");

    }

    public String deleteStudent(String email) throws SQLException {
        if (readStudent(email).equals("The specified e-mail address does not appear in the database.")) {
            return "The specified e-mail address does not appear in the database.";
        }
        String SQL = "DELETE FROM Student WHERE StudentEmail = '" + email + "';";
        return super.runQuery(SQL, false, "Student");
    }

}
