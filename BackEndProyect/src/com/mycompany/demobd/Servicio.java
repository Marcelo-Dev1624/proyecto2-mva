/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demobd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lulu
 */
public abstract class Servicio {

    private Connection conn = null;

    protected Connection getConection() throws Exception {

//Paso 1
        Class.forName("com.mysql.jdbc.Driver");
        //Paso 2
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto2?zeroDateTimeBehavior=convertToNull", "root", "1234");
        System.out.println("CONEXION: " + conn);
        return conn;
    }

    protected void cerrar(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }

    }

    protected void cerrar(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
            rs = null;
        }
    }

    protected void cerrar(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
            ps = null;
        }
    }

}
