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
    Assertions.assertFalse(this.licuadora.estaEncendida(), "La licuadora no debería encenderse sin contenido");
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
  @Test
  void testDecrementarVelocidad() {
    this.licuadora.llenar(1.0);
    this.licuadora.encender();
    this.licuadora.incrementarVelocidad();
    this.licuadora.decrementarVelocidad();
    Assertions.assertEquals(1, this.licuadora.consultarVelocidad(), "La velocidad debería ser 1");
  }
  @Test
  void testApagar() {
    this.licuadora.llenar(1.0);
    this.licuadora.encender();
    this.licuadora.apagar();
    Assertions.assertFalse(this.licuadora.estaEncendida(), "La licuadora debería estar apagada");
    Assertions.assertEquals(0, this.licuadora.consultarVelocidad(), "La velocidad debería ser 0");
  }
  @Test
  void testServir() {
    this.licuadora.llenar(2.0);
    this.licuadora.servir(1.0);
    Assertions.assertFalse(this.licuadora.estaLlena(), "La licuadora no debería estar llena después de servir");
  }
  @Test
  void testServirConLicuadoraEncendida() {
    this.licuadora.llenar(1.0);
    this.licuadora.encender();
    this.licuadora.servir(0.5);
    Assertions.assertTrue(this.licuadora.estaEncendida(), "La licuadora debería seguir encendida");
  }
  @Test
  void testVaciar() {
    this.licuadora.llenar(1.0);
    this.licuadora.vaciar();
    Assertions.assertFalse(this.licuadora.estaLlena(), "La licuadora debería estar vacía");
  }
}
