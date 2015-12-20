package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;

import static org.junit.Assert.assertEquals;

@UseReporter({DiffReporter.class, DelayedClipboardReporter.class})
public class MultiTurtlePanelTest
{
  @Test
  public void testPaintNoTurtles()
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    Approvals.verify(panel);
  }


  @Test
  public void testPaintWithGhostTurtle()
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    panel.addTurtle(null);
    panel.addTurtle(new Turtle());
    Approvals.verify(panel);
  }
  @Test
  public void testPaintWithHiddenTurtle()
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    Turtle hiddenTurtle = new Turtle();
    hiddenTurtle.hide();
    panel.addTurtle(hiddenTurtle);
    panel.addTurtle(new Turtle());
    Approvals.verify(panel);
  }
  @Test
  public void testPaintWithTwoTurtle()
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    Turtle crouchingTurtle = new Turtle();
    crouchingTurtle.setX(35);
    crouchingTurtle.setY(35);
    panel.addTurtle(crouchingTurtle);
    panel.addTurtle(new Turtle());
    Approvals.verify(panel);
  }
  @Test
  public void testTwoTurtlesDrawBeforeAdding()
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    Turtle turtle = new Turtle();
    turtle.setSpeed(Integer.MIN_VALUE);
    turtle.move(100);
    turtle.drawStar(50);
    Turtle crouchingTurtle = new Turtle();
    crouchingTurtle.setSpeed(Integer.MIN_VALUE);
    crouchingTurtle.setX(35);
    crouchingTurtle.setY(35);
    crouchingTurtle.drawStar(50);
    panel.addTurtle(crouchingTurtle);
    panel.addTurtle(turtle);
    Approvals.verify(panel);
  }
  @Test
  public void testPaint()
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    panel.addTurtle(null);
    Turtle turtle = new Turtle();
    panel.addTurtle(turtle);
    turtle.setSpeed(10);
    turtle.move(100);
    Approvals.verify(panel);
  }
  @Test
  public void testAddGhostTurtle() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    panel.addTurtle(null);
    assertEquals(0, panel.getTurtleCount());
  }
  @Test
  public void testAddTurtle() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    panel.addTurtle(new Turtle());
    assertEquals(1, panel.getTurtleCount());
  }
  @Test
  public void testSetAnimal() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    MultiTurtleWindow panel = new MultiTurtleWindow();
    panel.addTurtle(new Turtle());
    panel.setAnimal(Turtle.Animals.ExplodedTurtle);
    Approvals.verify(panel);
  }
}
