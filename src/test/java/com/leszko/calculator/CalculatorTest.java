package com.leszko.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

private Calculator calculator = new Calculator();

  @Test
  public void  testSum() {
      assertEquals(5, calculator.sum(3,2) );
  }
}
