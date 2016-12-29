/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinedictionary.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sureshadhikari
 */
public class DbConnection {

    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/entries?user=root&password=root";
            con = DriverManager.getConnection(connectionUrl);
            System.err.println("+++++++++++++++++++connected++++++++++++++++++++++");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }
    }
}
