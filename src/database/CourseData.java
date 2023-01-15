package database;

import java.sql.*;

public class CourseData extends Connection {
    public String readCourse(String courseName) throws SQLException {
        String SQL = "SELECT * FROM Course WHERE CourseName = '" + courseName + "';";
        return super.runQuery(SQL, true, "Course");
    }

    public String deleteCourse(String courseName) throws SQLException {
        if (readCourse(courseName).equals("The specified e-mail address does not appear in the database.")) {
            return "The specified e-mail address does not appear in the database.";
        }
        String SQL = "DELETE FROM Course WHERE CourseName = '" + courseName + "';";
        return super.runQuery(SQL, false, "Course");
    }

    public String createCourse(String courseName, String subject, String introductionText, String level)
            throws SQLException {
        String SQL = "INSERT INTO Course VALUES ('" + courseName + "', '" + subject + "', '" + introductionText + "', '"
                + level + "')";
        return super.runQuery(SQL, false, "Course");
    }

    public String updateCourse(String initialCourseName, String courseName, String subject, String introductionText,
            String level) throws SQLException {
        readCourse(initialCourseName);
        String SQL = "UPDATE Course SET CourseName = '" + courseName + "', Subject = '" + subject
                + "', IntroductionText = '" + introductionText + "', Level = '" + level + "' WHERE CourseName = '"
                + initialCourseName + "';";
        if (readCourse(initialCourseName).equals("The specified course does not appear in the database.")) {
            return "The specified course does not appear in the database.";
        }
        return super.runQuery(SQL, false, "Course");
    }
}
