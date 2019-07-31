package com.stackroute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransactionDemo {

    public void  displayJdbcTransaction(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            connection.setAutoCommit(false);

            Statement stmt=connection.createStatement();
            stmt.executeUpdate("insert into user values('abc',66,'m')");
            stmt.executeUpdate("insert into user values('xyz',50,'f')");

            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
