
package com.licuadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LicuadoraTest {
    private Licuadora licuadora;
    private static final double CAPACIDAD = 2.0;

    @BeforeEach
    void setUp() {
        licuadora = new LicuadoraImpl(CAPACIDAD);
    }

    @Test
    void testEncenderConContenido() {
        licuadora.llenar(1.0);
        licuadora.encender();
        assertTrue(licuadora.estaEncendida(), "La licuadora debería estar encendida");
    }

    @Test
    void testEncenderSinContenido() {
        licuadora.encender();
        assertFalse(licuadora.estaEncendida(), "La licuadora no debería encenderse sin contenido");
    }

    @Test
    void testLlenarExcedeCapacidad() {
        licuadora.llenar(3.0);
        assertTrue(licuadora.estaLlena(), "La licuadora debería estar llena");
    }

    @Test
    void testIncrementarVelocidad() {
        licuadora.llenar(1.0);
        licuadora.encender();
        licuadora.incrementarVelocidad();
        assertEquals(2, licuadora.consultarVelocidad(), "La velocidad debería ser 2");
    }

    @Test
    void testDecrementarVelocidad() {
        licuadora.llenar(1.0);
        licuadora.encender();
        licuadora.incrementarVelocidad();
        licuadora.decrementarVelocidad();
        assertEquals(1, licuadora.consultarVelocidad(), "La velocidad debería ser 1");
    }

    @Test
    void testApagar() {
        licuadora.llenar(1.0);
        licuadora.encender();
        licuadora.apagar();
        assertFalse(licuadora.estaEncendida(), "La licuadora debería estar apagada");
        assertEquals(0, licuadora.consultarVelocidad(), "La velocidad debería ser 0");
    }

    @Test
    void testServir() {
        licuadora.llenar(2.0);
        licuadora.servir(1.0);
        assertFalse(licuadora.estaLlena(), "La licuadora no debería estar llena después de servir");
    }

    @Test
    void testServirConLicuadoraEncendida() {
        licuadora.llenar(1.0);
        licuadora.encender();
        licuadora.servir(0.5);
        assertTrue(licuadora.estaEncendida(), "La licuadora debería seguir encendida");
    }

    @Test
    void testVaciar() {
        licuadora.llenar(1.0);
        licuadora.vaciar();
        assertFalse(licuadora.estaLlena(), "La licuadora debería estar vacía");
    }
}
