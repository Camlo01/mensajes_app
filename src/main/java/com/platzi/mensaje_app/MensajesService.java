package com.platzi.mensaje_app;

import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje() {

        System.out.println("-CREAR MENSAJE----------------");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje:");
        System.out.println();
        System.out.println("--{");
        String mensaje = sc.nextLine();
        System.out.println("}--");

        System.out.println("Tu nombre:");
        System.out.println();
        System.out.println("--{");
        String nombre = sc.nextLine();
        System.out.println("}--");
        System.out.println();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);

    }

    ;

    public static void listarMensajes() {
        System.out.println("-MENSAJES---------------------");
        System.out.println("");
        System.out.println("Los mensajes son los siguientes:");
        MensajesDAO.leerMensajeDB();
    }

    ;

    public static void borrarMensaje() {

        MensajesDAO.vistaRapidaMensajes();
        Scanner sc = new Scanner(System.in);
        System.out.println("-ELIMINAR MENSAJE------------");
        System.out.println("");
        System.out.println("Cual es el id del mensaje a borrar: ");
        System.out.println("--{");
        int id_mensaje = sc.nextInt();
        System.out.println("}--");

        MensajesDAO.borrarMensajeDB(id_mensaje);

    }

    ;

    public static void editarMensaje() {
        Mensajes registro = new Mensajes();

        System.out.println("-EDITAR MENSAJES------------");
        System.out.println("");
        MensajesDAO.vistaRapidaMensajes();

        Scanner entrada = new Scanner(System.in);
        System.out.println();
        System.out.println("Arriba vista previa mensajes");
        System.out.println();
        System.out.println("ID del mensaje a editar:");
        System.out.println("--{");
        String id_mensajeString = entrada.nextLine();
        System.out.println("}--");

        int id_mensaje = Integer.parseInt(id_mensajeString);
        registro.setId_mensaje(id_mensaje);

        System.out.println("Escribe el nuevo mensaje:");
        System.out.println("--{");
        String mensaje = entrada.nextLine();
        registro.setMensaje(mensaje);
        System.out.println("}--");

        System.out.println("-----Procesando-----");
        MensajesDAO.actualizarMensajeDB(registro);
    };
}
