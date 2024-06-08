import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null; // Initialize resultSet to null

        try {
            connection = helper.getConnection();
            System.out.println("Deleting record...");

            String sql = "DELETE FROM city WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4082);
            statement.executeUpdate();

        } catch (SQLException e) {
            helper.error(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    // Other methods...

    // Method to select data and display it
    public void selectDemo() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM city");

            ArrayList<country> countries = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                countries.add(new country(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("continent"),
                        resultSet.getString("region")
                ));
            }
            System.out.println("Connection established");

        } catch (SQLException e) {
            helper.error(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    // Method to insert data into the database
    public void insertData() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "INSERT INTO city (name, code, country) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Istanbul");
            statement.setString(2, "2222");
            statement.setString(3, "Turkey");
            statement.executeUpdate();

            System.out.println("Record added");

        } catch (SQLException e) {
            helper.error(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    // Method to update data in the database
    public void updateData() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            System.out.println("Updating record...");

            String sql = "UPDATE city SET country = 'Germany', population = 89999 WHERE id = 4802";
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException e) {
            helper.error(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
