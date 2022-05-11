package com.platzi.mensaje_app;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
            errorConnectToDataBase();
        }
    }

    public static void leerMensajeDB() {
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM `mensajes`";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("Mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));

            }
        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }

    public static void vistaRapidaMensajes() {
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM `mensajes`";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println("Vista previa mensajes-------");
            while (rs.next()) {
                int id = rs.getInt("id_mensaje");
                String mensaje = rs.getString("Mensaje");
                System.out.println("Id: " + id + " Mensaje: " + mensaje);
            }
        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {

                String query = "DELETE FROM `mensajes` WHERE `mensajes`.`id_mensaje` = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado exitosamente!");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo borrar el mensaje");
            }

        } catch (SQLException e) {
            System.out.println(e);
            errorConnectToDataBase();

        }

    }

    public static void actualizarMensajeDB(Mensajes mensaje) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {

                String query = "UPDATE `mensajes` SET `mensaje` = ? WHERE `mensajes`.`id_mensaje` =  ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Se actualizó el mensaje correctamente");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo actualizar el mensaje :(");
            }

        } catch (SQLException e) {
            System.out.println(e);
            errorConnectToDataBase();

        }

    }

    private static void errorConnectToDataBase() {
        System.out.println("Problema al conectar con la base de datos");
    }

}
