package com.stackroute;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RowSetDemo {

    public void displayRowSet() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/user");
            rowSet.setUsername("root");
            rowSet.setPassword("");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            rowSet.setCommand("select * from user");
            rowSet.execute();

            while (rowSet.next()) {
                // Generating cursor Moved event
                System.out.println("name: " + rowSet.getString(1));
                System.out.println("age: " + rowSet.getInt(2));
                System.out.println("gender: " + rowSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
