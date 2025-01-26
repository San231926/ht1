package com.licuadora;

public interface Licuadora {

    void encender();

    void apagar();

    boolean estaEncendida();

    void llenar(double cantidad);

    void vaciar();

    void servir(double cantidad);

    boolean estaLlena();

    void incrementarVelocidad();

    void decrementarVelocidad();

    int consultarVelocidad();

}
