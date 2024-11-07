package com.marriaga.conversormonedas.principal;

import com.marriaga.conversormonedas.connection.Conexion;
import com.marriaga.conversormonedas.model.Intercambio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static int contador = 1;

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner s = new Scanner(System.in);
        int seleccion = 1;
        String moneda1 = "";
        String moneda2 = "";
        double cantidad = 0;
        List<String> consultas = new ArrayList<>();

        System.out.println("\n***** ¡Bienvenido al conversor de monedas! *****\n\n" +
                "Instrucciones:\n" +
                "A continuación se presenta un menú en el cual debes escribir el número de la opción deseada.");

        while (seleccion != 0) {

            System.out.println("================================================================================");
            System.out.println("Seleccione la opción deseada: \n" +
                    "1.- Dólar ==> Peso Argentino\n" +
                    "2.- Peso Argentino ==> Dólar\n" +
                    "3.- Dólar ==> Real Brasileño\n" +
                    "4.- Real Brasileño ==> Dólar\n" +
                    "5.- Dólar ==> Peso Colombiano\n" +
                    "6.- Peso Colombiano ==> Dólar\n" +
                    "7.- Dólar ==> Peso Mexicano\n" +
                    "8.- Peso Mexicano ==> Dólar\n" +
                    "9.- Consultar el historial de conversiones\n" +
                    "0.- Salir del programa\n");
            try {
                seleccion = s.nextInt();
            } catch (Exception e) {
                seleccion = -1;
                s.nextLine();
            }

            boolean cantidadValida = false;

            if (seleccion > 0 && seleccion < 9) {
                try {
                    System.out.println("Ingrese la cantidad a convertir:");
                    cantidad = s.nextDouble();
                    cantidadValida = true;
                } catch (Exception e) {
                    System.err.println("El valor proporcionado no es válido. Intente nuevamente.");
                    s.nextLine();
                }
            }
            switch (seleccion) {

                case 0:
                    System.out.println("¡Gracias por utilizar el conversor de monedas!");
                case 1:
                    if (cantidadValida) {
                        moneda1 = "USD";
                        moneda2 = "ARS";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 2:
                    if (cantidadValida) {
                        moneda1 = "ARS";
                        moneda2 = "USD";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 3:
                    if (cantidadValida) {
                        moneda1 = "USD";
                        moneda2 = "BRL";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 4:
                    if (cantidadValida) {
                        moneda1 = "BRL";
                        moneda2 = "USD";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 5:
                    if (cantidadValida) {
                        moneda1 = "USD";
                        moneda2 = "COP";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 6:
                    if (cantidadValida) {
                        moneda1 = "COP";
                        moneda2 = "USD";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 7:
                    if (cantidadValida) {
                        moneda1 = "USD";
                        moneda2 = "MXN";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 8:
                    if (cantidadValida) {
                        moneda1 = "MXN";
                        moneda2 = "USD";
                        imprimirResultado(moneda1, moneda2, cantidad, consultas);
                    }
                    break;
                case 9:
                    consultarConversiones(consultas);
                    break;
                default:
                    System.err.println("No se ha ingresado una opción válida. Intente nuevamente");
            }
        }
    }

    private static void imprimirResultado(String moneda1, String moneda2, Double cantidad, List<String> consultas)
            throws IOException, InterruptedException {
        Intercambio intercambio = new Intercambio(moneda1, moneda2, cantidad);

        Intercambio resultado = Conexion.obtenerValores(intercambio);
        String respuesta = "Equivalencia " + moneda1 + " => " + moneda2 + " = " + resultado.getValor() + "\n" +
                cantidad + " " + moneda1 + " equivale a " + resultado.getConversion() + " " + moneda2;
        System.out.println(respuesta);
        consultas.add("Consulta " + contador++ + ": \n" + respuesta + "\n");
    }

    private static void consultarConversiones(List<String> consultas) {
        if (consultas.isEmpty()) {
            System.out.println("Aún no se ha realizado ninguna consulta.");
        } else {
            consultas.forEach(System.out::println);
        }
    }
}
