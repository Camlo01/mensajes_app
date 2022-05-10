/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Camilo
 */
public class Conexion {

    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3307/mensajes_app", "root", "");
            if (conection != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conection;
    }
}
