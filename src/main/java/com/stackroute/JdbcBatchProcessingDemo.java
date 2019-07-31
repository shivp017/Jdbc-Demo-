package com.stackroute;

import java.sql.*;

public class JdbcBatchProcessingDemo {
    public void batchProcessing(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "")){

            // Create statement object
            Statement statement = connection.createStatement();
            // Set auto-commit to false
            connection.setAutoCommit(false);

// Create SQL statement
            String SQL = "INSERT INTO user (name,age,gender) " +
                    "VALUES('atul',30,'m')";
// Add above SQL statement in the batch.
            statement.addBatch(SQL);

// Create one more SQL statement
            SQL = "INSERT INTO user (name,age,gender) " +
                    "VALUES('rohan',20,'m')";
// Add above SQL statement in the batch.
            statement.addBatch(SQL);

// Create one more SQL statement
            SQL = "UPDATE user SET age = 35 " +
                    "WHERE name='singh'";
// Add above SQL statement in the batch.
            statement.addBatch(SQL);

// Create an int[] to hold returned values
            int[] count = statement.executeBatch();

            System.out.println("no of rows effected "+count);
//Explicitly commit statements to apply changes
            connection.commit();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}