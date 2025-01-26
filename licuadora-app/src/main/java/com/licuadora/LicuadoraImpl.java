package com.licuadora;

public class LicuadoraImpl implements Licuadora {
    private boolean encendida;
    private int velocidad;
    private double contenidoActual;
    private final double capacidadMaxima;
    private static final int VELOCIDAD_MAXIMA = 10;

    public LicuadoraImpl(double capacidadMaxima) {
        this.encendida = false;
        this.velocidad = 0;
        this.contenidoActual = 0.0;
        this.capacidadMaxima = capacidadMaxima > 0 ? capacidadMaxima : 1.5;
    }

    @Override
    public void encender() {
        if (contenidoActual > 0 && !encendida) {
            this.encendida = true;
            this.velocidad = 1;
            System.out.println("Licuadora encendida");
        } else if (encendida) {
            System.out.println("La licuadora ya está encendida");
        } else {
            System.out.println("No se puede encender: licuadora vacía");
        }
    }

    @Override
    public void apagar() {
        this.encendida = false;
        this.velocidad = 0;
        System.out.println("Licuadora apagada");
    }

    @Override
    public boolean estaEncendida() {
        return this.encendida;
    }

    @Override
    public void llenar(double volumen) {
        if (volumen <= 0) {
            System.out.println("El volumen debe ser mayor a 0");
            return;
        }
        if (encendida) {
            System.out.println("No se puede llenar con la licuadora encendida");
            return;
        }
        
        double espacioDisponible = capacidadMaxima - contenidoActual;
        double cantidadLlenada = Math.min(volumen, espacioDisponible);
        
        contenidoActual += cantidadLlenada;
        System.out.println("Llenado: " + cantidadLlenada + " litros");
    }

    @Override
    public void incrementarVelocidad() {
        if (!encendida) {
            System.out.println("La licuadora está apagada");
            return;
        }
        
        if (velocidad < VELOCIDAD_MAXIMA) {
            velocidad++;
            System.out.println("Velocidad aumentada a: " + velocidad);
        } else {
            System.out.println("Velocidad máxima alcanzada");
        }
    }

    @Override
    public void decrementarVelocidad() {
        if (!encendida) {
            System.out.println("La licuadora está apagada");
            return;
        }
        
        if (velocidad > 0) {
            velocidad--;
            System.out.println("Velocidad reducida a: " + velocidad);
        }
        
        if (velocidad == 0) {
            apagar();
        }
    }

    @Override
    public int consultarVelocidad() {
        return this.velocidad;
    }

    @Override
    public boolean estaLlena() {
        return contenidoActual >= capacidadMaxima;
    }

    @Override
    public void vaciar() {
        contenidoActual = 0.0;
        apagar();
        System.out.println("Licuadora vaciada");
    }

    @Override
    public void servir(double cantidad) {
        if (encendida) {
            System.out.println("No se puede servir con la licuadora encendida");
            return;
        }
        if (cantidad <= 0 || cantidad > contenidoActual) {
            System.out.println("Cantidad inválida para servir");
            return;
        }

        contenidoActual -= cantidad;
        System.out.println("Servido: " + cantidad + " litros");
    }
}