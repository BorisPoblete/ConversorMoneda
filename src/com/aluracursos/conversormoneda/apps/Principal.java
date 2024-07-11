package com.aluracursos.conversormoneda.apps;

import java.util.Scanner;

public class Principal {
    public Principal() {
    }

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionDeConversion = 0;
        double valorAConvertir = 0.0;

        try {
            while(opcionDeConversion != 7) {
                System.out.println("""
                        ****************************************
                        Sea bienvenido al conversor de moneda!
                        1)Pesos Chilenos a Dolar
                        2)Dolar a Pesos Chilenos
                        3)Pesos Argentinos a Dolar
                        4)Dolar a Pesos Argentinos
                        5)Reales Brasileños a Dolar
                        6)Dolar a Reales Brasileños
                        7)Salir
                        Elija una opción valida:
                        """);
                opcionDeConversion = lectura.nextInt();
                if (opcionDeConversion >= 1 && opcionDeConversion <= 6) {
                    System.out.println("""
                            ****************************************
                            Ingrese el valor que desea convertir
                            """);
                    valorAConvertir = (double)lectura.nextInt();
                    ConsultarAPI consulta = new ConsultarAPI();
                    ConversorMoneda convercion = new ConversorMoneda();
                    System.out.printf("Resultado:  %.2f\n", convercion.conversorMoneda(
                            consulta.consultarTasaDeCambio(opcionDeConversion), opcionDeConversion, valorAConvertir));
                } else {
                    if (opcionDeConversion == 7) {
                        break;
                    }

                    System.out.println("Opción no valida. Intente de nuevo");
                }
            }
        } catch (Exception var7) {
            Exception e = var7;
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Gracias por usar el conversor de moneda!\nCerrando Aplicación.");
    }
}
