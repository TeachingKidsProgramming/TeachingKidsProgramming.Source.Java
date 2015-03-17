package org.teachingextensions.logo.tests;

import junit.framework.TestCase;

import org.teachingkidsprogramming.approvals.lite.Approvals;
import org.teachingkidsprogramming.approvals.lite.reporters.ClipboardReporter;
import org.teachingkidsprogramming.approvals.lite.reporters.DiffReporter;
import org.teachingkidsprogramming.approvals.lite.reporters.UseReporter;
import org.teachingextensions.logo.Turtle;

@UseReporter({ClipboardReporter.class, DiffReporter.class})
public class TurtlePanelTest extends TestCase
{
  public void testImageForBackground() throws Exception
  {
    Turtle turtle = TurtleUtils.getTurtle();
    turtle.move(50);
    turtle.getBackgroundWindow().setBackgroundImage(
        "http://teachingkidsprogramming.org/blog/wp-content/uploads/teachingKidsProgramming_logo_sm.png");
    Approvals.verify(turtle.getImage());
  }
}
