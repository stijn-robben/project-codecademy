package database;

import java.sql.*;

public class OverviewsData extends Connection {
    public String getOverview1(String gender, String courseName) throws SQLException {
        String SQLCertificatesGivenAway = "SELECT COUNT(CertificateID) AS Count FROM Certificate INNER JOIN Student ON Certificate.StudentEmail = Student.StudentEmail WHERE Gender = '"
                + gender + "' AND CourseName = '" + courseName + "';";
        String certificatesGivenAway = super.runQuery(SQLCertificatesGivenAway, true, "Overview1");
        String SQLEnrollmentsOfCourse = "SELECT COUNT(*) AS 'Count' FROM Registration WHERE CourseName = '" + courseName
                + "'";
        String enrollmentsOfCourse = super.runQuery(SQLEnrollmentsOfCourse, true, "Overview1");
        try {
            String percentage = Double
                    .toString(Integer.parseInt(certificatesGivenAway) / Integer.parseInt(enrollmentsOfCourse) * 100)
                    + "%";
            return percentage;
        } catch (ArithmeticException e) {
            return "0%";
        }
    }

    public String getOverview2(String moduleTitle) throws SQLException {
        String SQLGetContentID = "SELECT ContentID AS 'Count' FROM ContentItem WHERE Title = '" + moduleTitle
                + "' AND Type = 'Module'";
        String contentID = super.runQuery(SQLGetContentID, true, "Overview1");
        String SQLgetAvgProgress = "SELECT AVG(WatchPercentage) AS 'Count' FROM Progress WHERE ContentID = '"
                + contentID + "'";
        String avgProgress = super.runQuery(SQLgetAvgProgress, true, "Overview1");
        return avgProgress + "%";
    }

    public String getOverview3(String studentEmail) throws SQLException {
        String SQLgetAvgProgress = "SELECT AVG(WatchPercentage) AS 'Count' FROM Progress WHERE StudentEmail = '"
                + studentEmail
                + "'";
        String avgProgress = super.runQuery(SQLgetAvgProgress, true, "Overview1");
        return avgProgress + "%";
    }

    public String getOverview4(String courseName) throws SQLException {
        String SQLCountCertificates = "SELECT COUNT(*) AS 'Count' FROM Certificate WHERE CourseName = '" + courseName
                + "'";
        String countCertificates = super.runQuery(SQLCountCertificates, true, "Overview1");
        String SQLCountEnrollments = "SELECT COUNT(*) AS 'Count' FROM Registration WHERE CourseName = '" + courseName
                + "'";
        String countEnrollments = super.runQuery(SQLCountEnrollments, true, "Overview1");
        try {
            String percentage = Double
                    .toString(Integer.parseInt(countCertificates) /
                            Integer.parseInt(countEnrollments) * 100)
                    + "%";
            return percentage;
        } catch (ArithmeticException e) {
            return "0%";
        }
    }

    public String getOverview5() throws SQLException {
        String SQLgetTop3 = "SELECT TOP 3 ContentID AS 'top3' FROM Progress";
        String getTop3 = super.runQuery(SQLgetTop3, true, "printTop3");
        return getTop3;
    }

    public String getOverview6() throws SQLException {
        String SQLgetTop3 = "SELECT TOP 3 CourseName AS 'top3' FROM Certificate";
        String getTop3 = super.runQuery(SQLgetTop3, true, "printTop3");
        return getTop3;
    }
}
