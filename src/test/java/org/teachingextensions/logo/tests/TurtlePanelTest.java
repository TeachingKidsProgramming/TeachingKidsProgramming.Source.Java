package org.teachingextensions.logo.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.ClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.Turtle;

@UseReporter({ClipboardReporter.class, DiffReporter.class})
public class TurtlePanelTest
{

  public static final String BACKGROUND_IMAGE = "http://teachingkidsprogramming.org/wp-content/uploads/jimcounts.jpg";

  @Test
  public void testImageForBackground() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    Turtle turtle1 = new Turtle();
    turtle1.setSpeed(Turtle.TEST_SPEED);
    turtle1.move(50);
    turtle1.getBackgroundWindow().setBackgroundImage(BACKGROUND_IMAGE);
    Approvals.verify(turtle1.getImage());
  }
}
