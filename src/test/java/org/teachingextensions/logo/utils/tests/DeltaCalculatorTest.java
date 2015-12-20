package org.teachingextensions.logo.utils.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.utils.DeltaCalculator;

public class DeltaCalculatorTest {
  @Test
  public void testDelta() throws Exception {
    JUnitUtils.assumeNotHeadless();
    String out = "";
    for (int i = 0; i < 9; i++) {
      DeltaCalculator calculator = new DeltaCalculator(i * 45.0, 5);
      double deltaY = calculator.getY();
      double deltaX = calculator.getX();
      out += String.format("%s=>[%s, %s]\r\n", i * 45, deltaX, deltaY);
    }
    Approvals.verify(out);
  }
}
