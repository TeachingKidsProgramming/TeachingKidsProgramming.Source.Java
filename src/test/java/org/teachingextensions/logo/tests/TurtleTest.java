package org.teachingextensions.logo.tests;

import junit.framework.TestCase;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.lambda.Function1;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Wheel;
import static org.junit.Assert.*;

import java.awt.*;

@UseReporter({DiffReporter.class, DelayedClipboardReporter.class})
public class TurtleTest {

    @Test
    public void testShow() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testRotate() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        turtle.turn(90);
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testRotate45() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        turtle.turn(45);
        Approvals.verify(turtle.getImage());
        assertEquals(45.0, turtle.getAngleInDegrees(), 0.02);
    }

    @Test
    public void testRotate45CounterClockwise() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        turtle.turn(-45);
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testMove() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        turtle.move(50);
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testMove45DegreesLeft() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        turtle.turn(-45);
        turtle.move(50);
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testDelta() throws Exception {
        JUnitUtils.assumeNotHeadless();
        String out = "";
        for (int i = 0; i < 9; i++) {
            double deltaY = Turtle.getDeltaY(5, i * 45.0);
            double deltaX = Turtle.getDeltaX(5, i * 45.0);
            out += String.format("%s=>[%s, %s]\r\n", i * 45, deltaX, deltaY);
        }
        Approvals.verify(out);
    }

    @Test
    public void testCalculateAngle() throws Exception {
        assertEquals(-90.0, Turtle.angleCalculator(0, 0, -1, 0), 0.005);
        assertEquals(90.0, Turtle.angleCalculator(0, 0, 1, 0), 0.005);
    }

    @Test
    public void testPentagonCrazy() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        Wheel<Color> wheel = new Wheel<Color>();
        wheel.add(PenColors.Blues.SteelBlue);
        wheel.add(PenColors.Purples.DarkMagenta);
        wheel.add(PenColors.Blues.DarkSlateBlue);
        wheel.add(PenColors.Purples.Indigo);
        wheel.add(PenColors.Purples.DarkOrchid);
        Wheel<Integer> thickness = new Wheel<Integer>(1, 2, 3);
        for (int i = 0; i < 200; i++) {
            turtle.setPenColor(wheel.next());
            turtle.setPenWidth(thickness.next());
            turtle.move(i + 1);
            turtle.turn(360 / 5);
            turtle.turn(1);
        }
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testPenDown() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        for (int i = 0; i < 3; i++) {
            turtle.move(10);
            turtle.penUp();
            turtle.move(10);
            turtle.penDown();
        }
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testHide() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        turtle.move(50);
        turtle.hide();
        Approvals.verify(turtle.getImage());
    }

    @Test
    public void testSpeed() throws Exception {
        Integer[] speeds = {-5, 5, 15, Turtle.TEST_SPEED};
        Approvals.verifyAll("Speeds", speeds, new Function1<Integer, String>() {
            @Override
            public String call(Integer speed) {
                try {
                    Turtle turtle = TurtleUtils.getTurtle();
                    turtle.setSpeed(speed);
                    return speed + " => " + turtle.getSpeed();
                } catch (Exception e) {
                    return speed + " => " + e.getMessage();
                }
            }
        });
    }

    @Test
    public void testClear() throws Exception {
        JUnitUtils.assumeNotHeadless();
        Turtle turtle = TurtleUtils.getTurtle();
        turtle.clear();
        Approvals.verify(turtle.getImage());
    }
}
