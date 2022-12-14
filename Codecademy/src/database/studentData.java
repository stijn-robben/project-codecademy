package database;

import java.sql.*;

public class studentData extends connection {
    // CRUD
    public void createStudent(String studentEmail, String name, String dateOfBirth, String gender, String address,
            String city, String country) throws SQLException {
        // "M" or "F"
        if (gender.length() != 1) {
            throw new IllegalArgumentException("Invalid gender string length");
        }
        String SQL = "INSERT INTO Student VALUES ('" + studentEmail + "', '" + name + "', '" + dateOfBirth + "', '"
                + gender + "', '" + address + "', '" + city + "', '" + country + "')";
        super.runQuery(SQL, false, "Student");
    }

    public void readStudent(String email) throws SQLException {
        String SQL = "SELECT * FROM Student WHERE StudentEmail = '" + email + "';";
        super.runQuery(SQL, true, "Student");
    }

    // Update & Try/Catch
    public void updateStudent(String initialEmail, String email, String name, String dateOfBirth, String gender,
            String address,
            String city, String country) throws SQLException {
        System.out.println("Current data from user with email address " + initialEmail);
        readStudent(initialEmail);
        String SQL = "UPDATE Student SET StudentEmail = '" + email + "', Name = '" + name + "', DateOfBirth = '"
                + dateOfBirth + "', Gender = '" + gender + "', Address = '" + address + "', City = '" + city
                + "', Country =  '" + country + "' WHERE StudentEmail = '" + initialEmail + "';";
        super.runQuery(SQL, false, "Student");
        System.out.println("Updated data from user with inital email adress " + initialEmail);
        readStudent(email);
    }

    public void deleteStudent(String email) throws SQLException {
        String SQL = "DELETE FROM Student WHERE StudentEmail = '" + email + "';";
        super.runQuery(SQL, false, "Student");
    }

}
