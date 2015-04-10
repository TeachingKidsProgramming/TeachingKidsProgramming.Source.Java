package org.teachingextensions.logo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.util.JUnitUtils;

import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;

@UseReporter({DiffReporter.class, DelayedClipboardReporter.class})
public class MultiTurtlePanelTest {
    @Test
    public void testPaintNoTurtles() {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
        Approvals.verify(panel);
    }

    @Test
    public void testPaintOneTurtle() {
             JUnitUtils.assumeNotHeadless();
   MultiTurtlePanel panel = new MultiTurtlePanel();
        panel.addTurtle(new Turtle());
        Approvals.verify(panel);
    }

    @Test
    public void testPaintWithGhostTurtle() {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
        panel.addTurtle(null);
        panel.addTurtle(new Turtle());
        Approvals.verify(panel);
    }

    @Test
    public void testPaintWithHiddenTurtle() {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
        Turtle hiddenTurtle = new Turtle();
        hiddenTurtle.hide();
        panel.addTurtle(hiddenTurtle);
        panel.addTurtle(new Turtle());
        Approvals.verify(panel);
    }

    @Test
    public void testPaintWithTwoTurtle() {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
        Turtle crouchingTurtle = new Turtle();
        crouchingTurtle.setX(35);
        crouchingTurtle.setY(35);
        panel.addTurtle(crouchingTurtle);
        panel.addTurtle(new Turtle());
        Approvals.verify(panel);
    }

    @Test
    public void testTwoTurtlesDrawBeforeAdding() {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
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
    public void testPaint() {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
        panel.addTurtle(null);
        Turtle turtle = new Turtle();
        panel.addTurtle(turtle);
        turtle.setSpeed(10);
        turtle.move(100);
        Approvals.verify(panel);
    }

    @Test
    public void testAddGhostTurtle() throws Exception {
              JUnitUtils.assumeNotHeadless();
  MultiTurtlePanel panel = new MultiTurtlePanel();
        panel.addTurtle(null);
        assertEquals(0, panel.getTurtleCount());
    }

    @Test
    public void testAddTurtle() throws Exception {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
        panel.addTurtle(new Turtle());
        assertEquals(1, panel.getTurtleCount());
    }

    @Test
    public void testSetAnimal() throws Exception {
        JUnitUtils.assumeNotHeadless();
        MultiTurtlePanel panel = new MultiTurtlePanel();
        panel.addTurtle(new Turtle());
        panel.setAnimal(Turtle.Animals.ExplodedTurtle);
        Approvals.verify(panel);
    }
}
