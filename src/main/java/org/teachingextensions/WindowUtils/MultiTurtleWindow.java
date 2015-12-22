package org.teachingextensions.WindowUtils;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.InterfaceUtils.MultiTurtlePainter;
import org.teachingextensions.logo.utils.InterfaceUtils.MultiTurtleTrailPainter;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Use this window when you want to put more than one turtle on the same window
 */
public class MultiTurtleWindow extends TurtlePanel {
  private List<Turtle> turtles = new ArrayList<Turtle>();
  private Animals      animal  = Animals.Turtle;
  private Paintable multiTurtlePainter;
  private Paintable multiTurtleTrailPainter;

  public MultiTurtleWindow() {
    super("Turtles, Turtles, Turtles!");
    this.image = loadAnimal();
    this.getWindow()
        .add(this.createTurtlePainter())
        .add(this.createTurtleTrailPainter())
        .setBackground(PenColors.Blues.DarkSlateBlue);
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
    this.getWindow()
        .remove(this.multiTurtlePainter)
        .remove(this.multiTurtleTrailPainter)
        .add(this.createTurtlePainter())
        .add(this.createTurtleTrailPainter());
  }

  private Image loadAnimal() {
    return ObjectUtils.loadImage(MultiTurtleWindow.class, this.animal + ".png");
  }

  private Paintable createTurtleTrailPainter() {
    return this.multiTurtleTrailPainter = new MultiTurtleTrailPainter(this.turtles);
  }

  private Paintable createTurtlePainter() {
    return this.multiTurtlePainter = new MultiTurtlePainter(this.turtles, this.getImage());
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
