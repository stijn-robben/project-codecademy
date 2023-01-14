package database;

import java.sql.*;

public class CertificateData extends Connection {
    public String createCertificate(String certificateID, String grade, String nameEmployee, String courseName,
            String studentEmail) throws SQLException {
        String SQL = "INSERT INTO Certificate VALUES ('" + certificateID + "', '" + grade + "', '" + nameEmployee
                + "', '" + courseName + "', '" + studentEmail + "')";
        return super.runQuery(SQL, false, "Certificate");
    }

    public String readCertificate(String studentEmail) throws SQLException {
        String SQL = "SELECT CertificateID, Grade, NameEmployee, CourseName, StudentEmail FROM Certificate WHERE StudentEmail = '"
                + studentEmail + "'";
        return super.runQuery(SQL, true, "Certificate");
    }

    public String deleteCertificate(String certificateID) throws SQLException {
        String SQL = "DELETE FROM Certificate WHERE CertificateID = '" + certificateID + "';";
        return super.runQuery(SQL, false, "Certificate");
    }

    public String updateCertificate(String certificateID, String grade, String nameEmployee) throws SQLException {
        String SQL = "UPDATE Certificate SET Grade = '" + grade
                + "', NameEmployee = '"
                + nameEmployee + "' WHERE CertificateID = " + certificateID + ";";

        return super.runQuery(SQL, false, "Certificate");

    }
}