/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensaje_app;

import java.util.Scanner;

/**
 *
 * @author Camilo
 */
public class Inicio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var option = 0;
        do {
            System.out.println("------------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println(" 1. Crear mensaje");
            System.out.println(" 2. Listar mensajes");
            System.out.println(" 3. Editar mensajes");
            System.out.println(" 4. Borrar mensajes");
            System.out.println(" 5. Salir");
            // leemos la opcion del usuario

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;

            }

        } while (option != 5);

    }

}
