package org.teachingextensions.WindowUtils;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.LineSegment;

/**
 * Use this window when you want to put more than one turtle on the same window
 */
public class MultiTurtleWindow extends TurtlePanel
{
  private static final long serialVersionUID = 1810849469483511849L;
  private List<Turtle>      turtles          = new ArrayList<Turtle>();
  private Image             image;
  private Animals           animal           = Animals.Turtle;
  public MultiTurtleWindow()
  {
    super("Turtles, Turtles, Turtles!");
    this.image = loadAnimal();
  }
  /**
   * Adds a turtle instance to a window 
   * NOTE: this method must be called BEFORE calling any other methods on turtle instances
   * <p><b>Example:</b> {@code multiTurtleWindow.addTurtle(myTurtle)}</p>
   *
   * @param turtle
   *     A turtle instance
   */
  public void addTurtle(Turtle turtle)
  {
    if (turtle == null) { return; }
    this.turtles.add(turtle);
    turtle.setFrame(this.getFrame());
    turtle.setPanel(this);
  }
  @Override
  public void paint(Graphics g)
  {
    // We must call JPanel paint to get the correct behavior on windows...
    super.paint(g);
    Graphics2D g2d = ProgramWindow.configureGraphics2D(g);
    super.setBackground(PenColors.Blues.DarkSlateBlue);
    paintLines(g2d);
    paintTurtle(g2d);
    g2d.dispose();
  }
  @Override
  public synchronized Image getImage()
  {
    return image;
  }
  /**
   * Sets the Animal type on the window
   * <p><b>Example:</b> {@code multiTurtlePanel.setAnimal(animal)} </p>
   *
   * @see Animals
   */
  @Override
  public synchronized void setAnimal(Animals animal)
  {
    this.animal = animal;
    this.image = loadAnimal();
  }
  private Image loadAnimal()
  {
    return ObjectUtils.loadImage(MultiTurtleWindow.class, this.animal + ".png");
  }
  private void paintLines(Graphics2D g2d)
  {
    // Paint can be called before the constructor finishes when super() shows the window.
    if (this.turtles == null) { return; }
    for (Turtle turtle : turtles)
    {
      paintTrail(g2d, turtle.getTrail());
    }
  }
  private void paintTrail(Graphics2D g2d, LineSegment[] trail)
  {
    for (LineSegment l : trail)
    {
      //g2d.setColor(l.getColor());
      g2d.setColor(PenColors.Yellows.Gold);
      g2d.setStroke(new BasicStroke(l.getWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
      g2d.draw(new Line2D.Double(l.getStart().x, l.getStart().y, l.getEnd().x, l.getEnd().y));
    }
  }
  private void paintTurtle(Graphics2D g)
  {
    for (Turtle turtle : turtles)
    {
      if (turtle.isHidden())
      {
        continue;
      }
      Image image = getImage();
      int xCenter = image.getWidth(null) / 2;
      int yCenter = image.getHeight(null) / 2;
      int x = turtle.getX() - xCenter;
      int y = turtle.getY() - yCenter;
      AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(turtle.getHeadingInDegrees()),
          xCenter, yCenter);
      AffineTransform move = AffineTransform.getTranslateInstance(x, y);
      move.concatenate(rotate);
      g.drawImage(image, move, null);
    }
  }
  public int getTurtleCount()
  {
    return this.turtles.size();
  }
  /**
   * Adds a turtle instance to a window and shows it on the window
   * <p><b>Example:</b> {@code multiTurtleWindow.addAndShowTurtle(myTurtle)}</p>
   *
   * @param turtle
   *     A turtle instance
   */
  public void addAndShowTurtle(Turtle turtle)
  {
    this.addTurtle(turtle);
    this.showTurtle(turtle);
  }
  private void showTurtle(Turtle turtle)
  {
    turtle.show();
  }
}
