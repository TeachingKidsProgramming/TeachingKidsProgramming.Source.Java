package org.teachingextensions.WindowUtils;

import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.InterfaceUtils.MultiTurtlePainter;
import org.teachingextensions.logo.utils.InterfaceUtils.MultiTurtleTrailPainter;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;

import java.util.ArrayList;
import java.util.List;

/**
 * Use this window when you want to put more than one turtle on the same window
 */
public class MultiTurtleWindow extends TurtlePanel {
  private List<Turtle> turtles = new ArrayList<Turtle>();

  public MultiTurtleWindow() {
    super("Turtles, Turtles, Turtles!");
    this.getWindow().setBackground(PenColors.Blues.DarkSlateBlue);
  }

  /**
   * Adds a turtle instance to a window
   * NOTE: this method must be called BEFORE calling any other methods on turtle instances
   * <p><b>Example:</b> {@code multiTurtleWindow.addTurtle(myTurtle)}</p>
   *
   * @param turtle
   *     A turtle instance
   */
  public void addTurtle(Turtle turtle) {
    if (turtle == null) {
      return;
    }
    turtle.setFrame(this.getWindow().getFrame());
    turtle.setPanel(this);

    this.turtles.add(turtle);
    clearPainters();
    configurePainters();
  }

  @Override
  protected Paintable createTurtleTrailPainter() {
    this.setTrailPainter(new MultiTurtleTrailPainter(this.turtles));
    return this.getTrailPainter();
  }

  @Override
  protected Paintable createTurtlePainter() {
    this.setTurtlePainter(new MultiTurtlePainter(this.turtles, this.getImage()));
    return this.getTurtlePainter();
  }

  public int getTurtleCount() {
    return this.turtles.size();
  }

  /**
   * Adds a turtle instance to a window and shows it on the window
   * <p><b>Example:</b> {@code multiTurtleWindow.addAndShowTurtle(myTurtle)}</p>
   *
   * @param turtle
   *     A turtle instance
   */
  public void addAndShowTurtle(Turtle turtle) {
    this.addTurtle(turtle);
    this.showTurtle(turtle);
  }

  private void showTurtle(Turtle turtle) {
    turtle.show();
  }
}
