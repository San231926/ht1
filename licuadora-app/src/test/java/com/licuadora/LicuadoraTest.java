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
  
