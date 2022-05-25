/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import java.sql.*;

/**
 *
 * @author HuzeyirPc
 */
public abstract class AbstractDao {

    public Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "1234");
            System.out.println("Connected");
            return con;
        } catch (SQLException ex) {
            System.out.println("poor connection: " + ex.getMessage());
        }

        return con;

    }

}