package database;

import java.sql.*;

public class connection {
    String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    public void getConnection() throws ClassNotFoundException, SQLException {
        // Connection con = null;
        // Statement stmt = null;
        // ResultSet rs = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    public String runQuery(String query, boolean returnsResultSet, String table) throws SQLException {
        Statement stmt = DriverManager.getConnection(connectionUrl).createStatement();
        if (!returnsResultSet) {
            stmt.executeUpdate(query);
            return "Data has been placed in the database.";
        } else if (returnsResultSet) {
            if (table.equals("Student")) {
                ResultSet rs = stmt.executeQuery(query);
                String result = printSQLResultStudent(rs);
                return result;
            }
            // add more tables for more CRUD on tables
        }
        return "The table is not supported.";
    }

    public static String printSQLResultStudent(ResultSet rs) throws SQLException {

        while (rs.next()) {
            String email = rs.getString("StudentEmail");
            String name = rs.getString("Name");
            Date dateOfBirth = rs.getDate("DateOfBirth");
            String gender = rs.getString("Gender");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String country = rs.getString("Country");
            String result = "" + email + ", " + name + ", " + dateOfBirth + ", " + gender + ", " + address + ", " + city
                    + ", " + country;
            return result;
        }
        return "The specified e-mail address does not appear in the database.";
    }

    // More printSQL methods here
}
