package com.bitinbyte.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * TestJdbc
 */
public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost/hb_student_tracker?ssl=false";
        String user = "postgres";
        String pass = "postgres";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful!!!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
