package org.teachingextensions.logo.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.ClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.TurtlePanel;

@UseReporter({ClipboardReporter.class, DiffReporter.class})
public class TurtlePanelTest {
    @Test
    public void testImageForBackground() throws Exception {
        JUnitUtils.assumeNotHeadless();

        Turtle turtle = TurtleUtils.getTurtle();
        turtle.move(50);
        turtle.getBackgroundWindow()
              .setBackgroundImage("http://teachingkidsprogramming.org/blog/wp-content/uploads/teachingKidsProgramming_logo_sm.png");
        Approvals.verify(turtle.getImage());
    }

    // @Test
    public void testNamedPanel() {
        TurtlePanel panel = new TurtlePanel("Turtle Bay");
        Approvals.verify(panel);
    }
}
