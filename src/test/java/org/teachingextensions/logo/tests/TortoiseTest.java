package org.teachingextensions.logo.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.reporters.ClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;

@UseReporter({DiffReporter.class, ClipboardReporter.class})
public class TortoiseTest
{
  @Test
  public void testSimpleSquare() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    Tortoise.setSpeed(Turtle.TEST_SPEED);
    Tortoise.show();
    int sides = 4;
    for (int i = 1; i <= sides; i++)
    {
      Tortoise.setPenColor(PenColors.Blues.Blue);
      Tortoise.move(50);
      Tortoise.turn(90);
    }
    TortoiseUtils.verify();
  }
  
  @Test
  public void testBigWidth() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    Tortoise.setSpeed(Turtle.TEST_SPEED);
    Tortoise.show();
    Tortoise.setPenColor(PenColors.Browns.Maroon);
    Tortoise.setPenWidth(100);
    Tortoise.move(10);
    TortoiseUtils.verify();
  }
}
