package com.licuadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LicuadoraTest {
  private Licuadora licuadora;
  private static final double CAPACIDAD = 2.0;
  LicuadoraTest() {
  }
  @BeforeEach
  void setUp() {
    this.licuadora = new LicuadoraImpl(2.0);
  }
  @Test
  void testEncenderConContenido() {
    this.licuadora.llenar(1.0);
    this.licuadora.encender();
    Assertions.assertTrue(this.licuadora.estaEncendida(), "La licuadora debería estar encendida");
  }
  @Test
  void testEncenderSinContenido() {
    this.licuadora.encender();
    Assertions.assertFalse(this.licuadora.estaEncendida(); "La licuadora no debería encenderse sin contenido");
  }
  @Test
  void testLlenarExcedeCapacidad() {
    this.licuadora.llenar(3.0);
    Assertions.assertTrue(this.licuadora.estaLlena(), "La licuadora debería estar llena");
  }
  @Test
  void testIncrementarVelocidad() {
    this.licuadora.llenar(1.0);
    this.licuadora.encender();
    this.licuadora.incrementarVelocidad();
    Assertions.assertEquals(2, this.licuadora.consultarVelocidad(), "La velocidad debería ser 2");
  }
