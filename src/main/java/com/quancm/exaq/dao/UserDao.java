package com.quancm.exaq.dao;

import com.quancm.exaq.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // Database connection parameters
    private String jdbcURL = "jdbc:mysql://localhost:3306/exaq";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    // Database connection
    private Connection connection;

    public UserDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a new user into the database
    public boolean addUser(User user) {
        String INSERT_USER_SQL = "INSERT INTO users (username, password, firstName, lastName, role, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setDate(6, new java.sql.Date(user.getCreated_at().getTime()));
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Retrieve a user by username
    public User getUserByUsername(String username) {
        String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserAvatarByUsername(String username) {
        String SELECT_USERAVATAR_BY_USERNAME = "SELECT avatar_url FROM users WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERAVATAR_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("avatar_url");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setUserAvatarByUsername(String username, String url) {
        String SELECT_USERAVATAR_BY_USERNAME = "SELECT avatar_url FROM users WHERE username = ?";
        try {
            // Define the SQL update statement
            String updateSql = "UPDATE users SET avatar_url = ? WHERE username = ?";

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);

            // Set the new avatar URL and user ID as parameters
            preparedStatement.setString(1, url);
            preparedStatement.setString(2, username);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Avatar URL updated successfully.");
            } else {
                System.out.println("No user found with the specified ID.");
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create a User object from a ResultSet
    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setRole(resultSet.getString("role"));
        user.setCreated_at(resultSet.getDate("created_at"));
        return user;
    }

    public boolean validate(User user){
        String SELECT_USER_BY_USERNAME_PASSWORD = "SELECT * FROM users WHERE username = ? AND password = ?" ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_PASSWORD)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Add more methods as needed for your application (e.g., update, delete, list all users).
}
