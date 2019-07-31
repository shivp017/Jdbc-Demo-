package com.stackroute;

import java.sql.*;

public class JdbcBasicDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public void displayUser() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from user");) {

//                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
//                statement=connection.createStatement();
//                resultSet=statement.executeQuery("select * from user");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        }
        //demo to use prepared statement
        public void getUserByName(String name){

        }
    }

