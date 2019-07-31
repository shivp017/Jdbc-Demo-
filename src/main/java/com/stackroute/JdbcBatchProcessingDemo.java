package com.stackroute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchProcessingDemo {

    public  void displayJdbcBatchProcessing(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            connection.setAutoCommit(false);

            Statement stmt=connection.createStatement();
            stmt.addBatch("insert into user values('raju',22,'m'");


            stmt.executeBatch();//executing the batch

            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }}}
