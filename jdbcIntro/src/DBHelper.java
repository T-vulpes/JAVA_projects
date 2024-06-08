import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String username = "root";
    private String password = "12345";
    private String dbURL = "jdbc:mysql://localhost:3360/world";  // world = name of the database

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL, username, password);
    }

    public void error(SQLException exception) {
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error code: " + exception.getErrorCode());
    }
}
