package org.teachingextensions.logo;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.windows.ProgramWindow;

/**
 *  Use this window when you want to put more than one turtle on the same window
 */
@SuppressWarnings("serial")
public class MultiTurtlePanel extends TurtlePanel
{
  private List<Turtle> turtles;
  private Image        image;
  private Animals      animal;
  public MultiTurtlePanel()
  {
    turtles = new ArrayList<Turtle>();
  }
  /**
   * Adds a turtle instance to a window
   * <div><b>Example:</b> {@code  multiTurtlePanel.addTurtle(myTurtle)} </div>
   * 
   * @param turtle
   *            A turtle instance 
   */
  public void addTurtle(Turtle turtle)
  {
    this.turtles.add(turtle);
    turtle.setPanel(this);
  }
  /**
   * Shows a window that can hold more than one turtle
   * <div><b>Example:</b> {@code  multiTurtlePanel.showPanel( )} </div>
   * 
   */
  public void showPanel()
  {
    JFrame frame = new JFrame("So Many Turtles");
    frame.getContentPane().add(this);
    ProgramWindow.createStandardFrame(frame);
    this.repaint();
  }
  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    paintLines((Graphics2D) g);
    paintTurtle((Graphics2D) g);
  }
  private void paintLines(Graphics2D g)
  {
    for (Turtle turtle : turtles)
    {
      if (turtle == null) { return; }
      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
      g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
      g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
      for (LineSegment l : turtle.getTrail())
      {
        if (l != null)
        {
          g.setColor(l.getColor());
          g.setStroke(new BasicStroke(l.getWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
          g.draw(new Line2D.Double(l.getStart().x, l.getStart().y, l.getEnd().x, l.getEnd().y));
        }
      }
    }
  }
  private void paintTurtle(Graphics2D g)
  {
    for (Turtle turtle : turtles)
    {
      if (turtle == null || turtle.isHidden()) { return; }
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
  @Override
  public synchronized Image getImage()
  {
    if (image == null)
    {
      setAnimal(Animals.Turtle);
    }
    return image;
  }
  @Override
  public synchronized Animals getAnimal()
  {
    if (animal == null)
    {
      setAnimal(Animals.Turtle);
    }
    return animal;
  }
  /**
   * Sets the Animal
   * <div><b>Example:</b> {@code  multiTurtlePanel.setAnimal(animal)} </div>
   * 
   * @see Animals
   */
  @Override
  public synchronized void setAnimal(Animals animal)
  {
    this.animal = animal;
    this.image = ObjectUtils.loadImage(MultiTurtlePanel.class, this.animal + ".png");
  }
  @Override
  public void setCursor(int cursor)
  {
    this.setCursor(Cursor.getPredefinedCursor(cursor));
  }
  @Override
  public void ___()
  {
    // blank for the DeepDive
  }
}
