package com.licuadora;

import java.util.Scanner;

public class Main {
    private static Licuadora licuadora;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido a su Licuadora Virtual");
        System.out.print("Por favor, ingrese la capacidad máxima de su licuadora (en litros): ");
        double capacidad = scanner.nextDouble();
        licuadora = new LicuadoraImpl(capacidad);
        
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    if (licuadora.estaEncendida()) {
                        licuadora.apagar();
                    } else {
                        licuadora.encender();
                    }
                    System.out.println("Estado: " + (licuadora.estaEncendida() ? "Encendida" : "Apagada"));
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a llenar (litros): ");
                    double cantidadLlenar = scanner.nextDouble();
                    licuadora.llenar(cantidadLlenar);
                    break;
                case 3:
                    licuadora.incrementarVelocidad();
                    System.out.println("Velocidad actual: " + licuadora.consultarVelocidad());
                    break;
                case 4:
                    licuadora.decrementarVelocidad();
                    System.out.println("Velocidad actual: " + licuadora.consultarVelocidad());
                    break;
                case 5:
                    System.out.println("Velocidad actual: " + licuadora.consultarVelocidad());
                    break;
                case 6:
                    System.out.println(licuadora.estaLlena() ? "La licuadora está llena" : "La licuadora no está llena");
                    break;
                case 7:
                    licuadora.vaciar();
                    break;
                case 8:
                    System.out.print("Ingrese la cantidad a servir (litros): ");
                    double cantidadServir = scanner.nextDouble();
                    licuadora.servir(cantidadServir);
                    break;
                case 0:
                    System.out.println("¡Gracias por usar la Licuadora Virtual!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Licuadora Virtual ===");
        System.out.println("1. Encender/Apagar licuadora");
        System.out.println("2. Llenar licuadora");
        System.out.println("3. Incrementar velocidad");
        System.out.println("4. Decrementar velocidad");
        System.out.println("5. Consultar velocidad");
        System.out.println("6. Consultar si está llena");
        System.out.println("7. Vaciar licuadora");
        System.out.println("8. Servir contenido");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }

    public static Licuadora getLicuadora() {
        return licuadora;
    }

    public static void setLicuadora(Licuadora licuadora) {
        Main.licuadora = licuadora;
    }
}