package com.platzi.mensaje_app;

import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);

    }

    ;
    public static void listarMensajes() {
        System.out.println("Los mensajes son los siguientes:");
        MensajesDAO.leerMensajeDB();
    }

    ;
    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cual es el id del mensaje a borrar");

        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);

    }

    ;
    public static void editarMensaje() {
        Mensajes registro = new Mensajes();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del mensaje que quieres editar");
        String id_mensajeString = entrada.nextLine();
        int id_mensaje = Integer.parseInt(id_mensajeString);
        registro.setId_mensaje(id_mensaje);

        System.out.println("Escribe ahora lo que quieres que diga el mensaje");
        String mensaje = entrada.nextLine();
        registro.setMensaje(mensaje);

        System.out.println("-----Procesando-----");
        MensajesDAO.actualizarMensajeDB(registro);
    }
;
}
