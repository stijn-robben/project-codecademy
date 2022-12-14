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

    public void runQuery(String query, boolean returnsResultSet, String table) throws SQLException {
        Statement stmt = DriverManager.getConnection(connectionUrl).createStatement();
        if (!returnsResultSet) {
            stmt.executeUpdate(query);
        } else if (returnsResultSet) {
            if (table.equals("Student")) {
                ResultSet rs = stmt.executeQuery(query);
                printSQLResultStudent(rs);
            }
        }
    }

    public static void printSQLResultStudent(ResultSet rs) throws SQLException {

        while (rs.next()) {
            String email = rs.getString("StudentEmail");
            String name = rs.getString("Name");
            Date dateOfBirth = rs.getDate("DateOfBirth");
            String gender = rs.getString("Gender");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String country = rs.getString("Country");
            System.out.println(
                    email + " " + name + " " + dateOfBirth + " " + gender + " " + address + " " + city + " " + country);
        }
    }

    // More printSQL methods here
}
