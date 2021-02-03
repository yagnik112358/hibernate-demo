package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/db_hibernate_demo?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "student";
        String pass = "Student@123";
        try {
            System.out.println("Connecting to Database"+jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection Successful!");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
