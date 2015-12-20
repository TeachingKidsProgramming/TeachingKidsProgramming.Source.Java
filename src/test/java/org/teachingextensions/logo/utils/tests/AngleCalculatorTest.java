package org.teachingextensions.logo.utils.tests;

import org.junit.Test;
import org.teachingextensions.logo.utils.AngleCalculator;

import static org.junit.Assert.assertEquals;

public class AngleCalculatorTest {
  @Test
  public void testCalculateAngle() throws Exception {
    assertEquals(-90.0, new AngleCalculator(0, 0, -1, 0).getDegreesWith0North(), 0.005);
    assertEquals(90.0, new AngleCalculator(0, 0, 1, 0).getDegreesWith0North(), 0.005);
  }
}
