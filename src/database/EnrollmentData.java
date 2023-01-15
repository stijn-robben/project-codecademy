package database;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnrollmentData extends Connection {
    public String createEnrollment(String courseName, String studentEmail) throws SQLException {
        String currentDate = getDate();
        String SQL = "INSERT INTO Registration VALUES ('" + currentDate + "', '" + studentEmail + "', '" + courseName
                + "');";
        return super.runQuery(SQL, false, "Registration");
    }

    public String readCoursesOfStudent(String studentEmail) throws SQLException {
        String SQL = "SELECT CourseName, StudentEmail FROM Registration WHERE StudentEmail = '" + studentEmail + "'";
        return super.runQuery(SQL, true, "Registration");
    }

    public String readStudentsInCourse(String courseName) throws SQLException {
        String SQL = "SELECT CourseName, StudentEmail FROM Registration WHERE CourseName = '" + courseName + "'";
        return super.runQuery(SQL, true, "Registration");
    }

    public String deleteEnrollment(String courseName, String studentEmail) throws SQLException {
        String SQL = "DELETE FROM Registration WHERE CourseName = '" + courseName + "' AND StudentEmail = '"
                + studentEmail + "';";
        return super.runQuery(SQL, false, "Registration");
    }

    public String getDate() {
        LocalDateTime ldt = LocalDateTime.now();
        String formattedDateStr = DateTimeFormatter.ofPattern("yyyy/MM/dd")
                .format(ldt);
        return formattedDateStr;
    }
}