package database;

import java.sql.*;

public class Connection {
    String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    public void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    public String runQuery(String query, boolean returnsResultSet, String table) throws SQLException {
        Statement stmt = DriverManager.getConnection(connectionUrl).createStatement();
        if (!returnsResultSet) {
            stmt.execute(query);
            return "Data has been updated in the database.";
        } else if (returnsResultSet) {
            if (table.equals("Student")) {
                ResultSet rs = stmt.executeQuery(query);
                String result = printSQLResultStudent(rs);
                return result;
            }
            if (table.equals("Course")) {
                ResultSet rs = stmt.executeQuery(query);
                String result = printSQLResultCourse(rs);
                return result;
            }
            if (table.equals("Registration")) {
                ResultSet rs = stmt.executeQuery(query);
                String result = printSQLResultRegistration(rs);
                return result;
            }
            if (table.equals("Certificate")) {
                ResultSet rs = stmt.executeQuery(query);
                String result = printSQLResultCertificate(rs);
                return result;
            }
        }
        return "The table is not supported.";
    }

    public static String printSQLResultStudent(ResultSet rs) throws SQLException {
        String result = "";
        while (rs.next()) {
            String email = rs.getString("StudentEmail");
            String name = rs.getString("Name");
            Date dateOfBirth = rs.getDate("DateOfBirth");
            String gender = rs.getString("Gender");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String country = rs.getString("Country");
            result += "" + email + ", " + name + ", " + dateOfBirth + ", " + gender + ", " + address + ", " + city
                    + ", " + country + " ";
        }
        if (result.equals("")) {
            return "The specified student email does not appear in the database.";
        }
        return result;
    }

    public static String printSQLResultCourse(ResultSet rs) throws SQLException {
        String result = "";
        while (rs.next()) {
            String courseName = rs.getString("CourseName");
            String subject = rs.getString("Subject");
            String introductionText = rs.getString("IntroductionText");
            String level = rs.getString("Level");
            result += "" + courseName + ", " + subject + ", " + introductionText + ", " + level;
        }
        if (result.equals("")) {
            return "The specified course name does not appear in the database.";
        }
        return result;
    }

    public static String printSQLResultRegistration(ResultSet rs) throws SQLException {
        String result = "";
        while (rs.next()) {
            String courseName = rs.getString("CourseName");
            String studentEmail = rs.getString("StudentEmail");
            result += "" + courseName + " " + studentEmail + ", ";
        }
        if (result.equals("")) {
            return "The specified course name / student email does not appear in the database.";
        }
        return result;
    }

    public static String printSQLResultCertificate(ResultSet rs) throws SQLException {
        String result = "";
        while (rs.next()) {
            String certificateID = rs.getString("CertificateID");
            String grade = rs.getString("Grade");
            String nameEmployee = rs.getString("NameEmployee");
            String courseName = rs.getString("CourseName");
            result += "ID: " + certificateID + " Grade: " + grade + "  Employee name: " + nameEmployee
                    + " Course name: " + courseName + ", ";
        }
        if (result.equals("")) {
            return "The specified student email does not have a certificate in the database.";
        }
        return result;
    }

    // More printSQL methods here
}
