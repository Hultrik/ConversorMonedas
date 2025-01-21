package com.aluracurso.conversor.principal;

import com.aluracurso.conversor.api.Request;
import com.aluracurso.conversor.api.ResultadoConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion = 0;
        Double cantidad;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Scanner scanner = new Scanner(System.in);


        String menu = """
                ****************************************
                Bienvenido/a al conversor de Moneda
                
                1.- Dólar...........=> Peso mexicano
                2.- Peso mexicano...=> Dólar
                3.- Dólar...........=> Real brasileño
                4.- Real brasileño..=> Dólar
                5.- Dólar...........=> Peso colombiano
                6.- Peso colombiano.=> Dólar
                7.- salir
                
                Por favor elija una opción válida:
                ****************************************
                """;

            while (opcion !=7){
                System.out.println(menu);
                opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Por favor ingrese la cantidad a convertir de Dólares a Pesos mexicanos");
                        cantidad = scanner.nextDouble();
                        var request = new Request();
                        var json = request.obtenerDatos("https://v6.exchangerate-api.com/v6/e431cb2a41d057f1558b638a/pair/USD/MXN/"+cantidad);
                        var resultado = gson.fromJson(json, ResultadoConversion.class);
                        var total = resultado.toString().replace("ResultadoConversion[conversion_result=","[");
                        System.out.println("["+cantidad+"] Dólares equivalen a "+total+" Pesos Mexicanos");
                        break;
                    case 2:
                        System.out.println("Por favor ingrese la cantidad a convertir de Pesos mexicanos a Dólares");
                        cantidad = scanner.nextDouble();
                        var request2 = new Request();
                        var json2 = request2.obtenerDatos("https://v6.exchangerate-api.com/v6/e431cb2a41d057f1558b638a/pair/MXN/USD/"+cantidad);
                        var resultado2 = gson.fromJson(json2, ResultadoConversion.class) ;
                        var total2 = resultado2.toString().replace("ResultadoConversion[conversion_result=","[");
                        System.out.println("["+cantidad+"] Pesos Mexicanos equivalen a "+total2+" Dólares");
                        break;
                    case 3:
                        System.out.println("Por favor ingrese la cantidad a convertir de Dólares a Reales brasileños");
                        cantidad = scanner.nextDouble();
                        var request3 = new Request();
                        var json3 = request3.obtenerDatos("https://v6.exchangerate-api.com/v6/e431cb2a41d057f1558b638a/pair/USD/BRL/"+cantidad);
                        var resultado3 = gson.fromJson(json3, ResultadoConversion.class);
                        var total3 = resultado3.toString().replace("ResultadoConversion[conversion_result=","[");
                        System.out.println("["+cantidad+"] Dólares equivalen a "+total3+" Reales Brasileños");
                        break;
                    case 4:
                        System.out.println("Por favor ingrese la cantidad a convertir de Reales brasileños a Dólares");
                        cantidad = scanner.nextDouble();
                        var request4 = new Request();
                        var json4 = request4.obtenerDatos("https://v6.exchangerate-api.com/v6/e431cb2a41d057f1558b638a/pair/BRL/USD/"+cantidad);
                        var resultado4 = gson.fromJson(json4, ResultadoConversion.class) ;
                        var total4 = resultado4.toString().replace("ResultadoConversion[conversion_result=","[");
                        System.out.println("["+cantidad+"] Reales Brasileños equivalen a "+total4+" Dólares");
                        break;
                    case 5:
                        System.out.println("Por favor ingrese la cantidad a convertir de Dólares a Pesos colombianos");
                        cantidad = scanner.nextDouble();
                        var request5 = new Request();
                        var json5 = request5.obtenerDatos("https://v6.exchangerate-api.com/v6/e431cb2a41d057f1558b638a/pair/USD/COP/"+cantidad);
                        var resultado5 = gson.fromJson(json5, ResultadoConversion.class) ;
                        var total5 = resultado5.toString().replace("ResultadoConversion[conversion_result=","[");
                        System.out.println("["+cantidad+"] Dólares equivalen a "+total5+" Pesos colombianos");
                        break;
                    case 6:
                        System.out.println("Por favor ingrese la cantidad a convertir de Pesos colombianos a Dólares");
                        cantidad = scanner.nextDouble();
                        var request6 = new Request();
                        var json6 = request6.obtenerDatos("https://v6.exchangerate-api.com/v6/e431cb2a41d057f1558b638a/pair/COP/USD/"+cantidad);
                        var resultado6 = gson.fromJson(json6, ResultadoConversion.class) ;
                        var total6 = resultado6.toString().replace("ResultadoConversion[conversion_result=","[");
                        System.out.println("["+cantidad+"] Pesos colombianos equivalen a "+total6+" Dólares");
                        break;
                    case 7:
                        System.out.println("Gracias por utilizar nuestros servicios, vuelva pronto.");
                        break;
                    default:
                        System.out.println("Opcion no valida, porfavor elije otra opcion");
                        break;
                }
            }
    }
}
