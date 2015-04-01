package org.teachingextensions.logo;

import org.teachingextensions.approvals.lite.util.ThreadLauncher;
import org.teachingextensions.approvals.lite.util.lambda.Action0;
import org.teachingextensions.approvals.lite.util.persistence.Saver;
import org.teachingextensions.approvals.lite.util.persistence.SavingException;
import org.teachingextensions.approvals.lite.writers.ComponentApprovalWriter;
import org.teachingextensions.windows.ProgramWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * <img src="https://lh5.googleusercontent.com/-B3Q59gpYW8o/T4tA2k_TYUI/AAAAAAAAAjo/WiqdoXjbkb0/s65/Tortoise.png" style="text-align: left" alt="A turtle drawing a line" >
 * The Turtle allows you to draw lines and shapes by moving it around on the window, and you can put more than one turtle on the same window...
 */
public class Turtle
{
  /**
   * Current types are: ExplodedTurtle, Turtle, Spider
   */
  public enum Animals {
    ExplodedTurtle, Turtle, Spider, Unicorn
  }
  private class Turner implements Saver<Double>
  {
    @Override
    public Double save(Double save) throws SavingException
    {
      smallTurn(save);
      return save;
    }
  }
  private class Mover implements Saver<Double>
  {
    private final Point starting;
    private LineSegment line = null;
    public Mover(Point point)
    {
      this.starting = point;
    }
    @Override
    public Double save(Double save) throws SavingException
    {
      moveWithoutAnimation(save);
      if (line != null)
      {
        trail.remove(line);
      }
      line = new LineSegment(color, starting, new Point(getX(), getY()), width);
      trail.add(line);
      return save;
    }
  }
  private class EmptyMover implements Saver<Double>
  {
    @Override
    public Double save(Double save) throws SavingException
    {
      moveWithoutAnimation(save);
      return save;
    }
  }
  private static final double MAX_MOVE_AMOUNT = 5.0;
  public static final int     TEST_SPEED      = Integer.MIN_VALUE;
  private double              x               = 640 / 2;
  private double              y               = 480 / 2;
  private double              angleInDegrees  = 0;
  private TurtlePanel         panel;
  private int                 speed           = 1;
  private List<LineSegment>   trail           = new ArrayList<LineSegment>();
  private Color               color           = Color.black;
  private int                 width           = 2;
  private boolean             penDown         = true;
  private boolean             hidden;
  private Animals             animal;
  //
  public BufferedImage getImage()
  {
    BufferedImage image = ComponentApprovalWriter.drawComponent(getPanel());
    clear();
    return image;
  }
  public void clear()
  {
    trail.clear();
    if (panel != null)
    {
      panel.removePaintable();
    }
  }
  private Component getPanel()
  {
    if (panel == null)
    {
      String title = "TKPJava Turtle";
      panel = new TurtlePanel();
      if (speed != TEST_SPEED)
      {
        JFrame frame = new JFrame(title);
        frame.getContentPane().add(panel);
        ProgramWindow.createStandardFrame(frame);
      }
      panel.setTurtle(this);
    }
    return panel;
  }
  public int getX()
  {
    return (int) x;
  }
  public int getY()
  {
    return (int) y;
  }
  public double getAngleInDegrees()
  {
    return angleInDegrees;
  }
  public void setAngleInDegrees(double angleInDegrees)
  {
    this.angleInDegrees = angleInDegrees;
  }
  public void setX(Number x)
  {
    this.x = x.doubleValue();
  }
  public void setY(Number y)
  {
    this.y = y.doubleValue();
  }
  public void turn(double amount)
  {
    double max = getTurnAmount(amount);
    Saver<Double> s = new Turner();
    animate(amount, max, s);
  }
  private double getTurnAmount(double amount)
  {
    amount = Math.abs(amount);
    if (getSpeed() == TEST_SPEED) { return amount; }
    return amount / (11 - getSpeed());
  }
  private void animate(double amount, double max, Saver<Double> s)
  {
    double sign = amount > 0 ? 1 : -1;
    amount = Math.abs(amount);
    while (amount > max)
    {
      s.save(max * sign);
      refreshPanel();
      amount -= max;
    }
    s.save(amount * sign);
    refreshPanel();
  }
  private void refreshPanel()
  {
    refreshPanel(getPanel());
  }
  private void refreshPanel(Component panel)
  {
    long delay = getDelay();
    if (delay != TEST_SPEED)
    {
      panel.repaint();
      try
      {
        Thread.sleep(delay);
      }
      catch (InterruptedException e)
      {
        // do nothing
      }
    }
  }
  private void smallTurn(double i)
  {
    angleInDegrees += i;
  }
  private long getDelay()
  {
    if (getSpeed() == 10) { return 1; }
    if (getSpeed() == TEST_SPEED) { return TEST_SPEED; }
    return 100 / getSpeed();
  }
  public void setSpeed(int speed)
  {
    if (speed != TEST_SPEED)
    {
      if (speed < 1 || 10 < speed) { throw new RuntimeException(
          String
              .format(
                  "I call shenanigans!!!\nThe speed '%s' is not between the acceptable range of [1-10]\nPerhaps you should read the documentation",
                  speed)); }
    }
    this.speed = speed;
  }
  public int getSpeed()
  {
    return speed;
  }
  public double getHeadingInDegrees()
  {
    return angleInDegrees;
  }
  public void move(Number amount)
  {
    double max = MAX_MOVE_AMOUNT;
    Saver<Double> s = penDown ? new Mover(new Point(getX(), getY())) : new EmptyMover();
    animate(amount.doubleValue(), max, s);
  }
  private void moveWithoutAnimation(Double save)
  {
    x += getDeltaX(save, angleInDegrees);
    y += getDeltaY(save, angleInDegrees);
  }
  public static double getDeltaY(double i, double angleInDegrees2)
  {
    return -i * Math.cos(Math.toRadians(angleInDegrees2));
  }
  public static double getDeltaX(double i, double angleInDegrees2)
  {
    return i * Math.sin(Math.toRadians(angleInDegrees2));
  }
  public LineSegment[] getTrail()
  {
    return trail.toArray(new LineSegment[trail.size()]);
  }
  public void setPenColor(Color color)
  {
    this.color = color;
  }
  public Color getPenColor()
  {
    return color;
  }
  public int getPenWidth()
  {
    return width;
  }
  public void setPenWidth(int width)
  {
    this.width = width;
  }
  public void show()
  {
    hidden = false;
    refreshPanel();
  }
  public TurtlePanel getBackgroundWindow()
  {
    return (TurtlePanel) getPanel();
  }
  public void setAnimal(Animals animal)
  {
    refreshPanel();
    getBackgroundWindow().setAnimal(animal);
    this.animal = animal;
  }
  public void penUp()
  {
    penDown = false;
  }
  public void penDown()
  {
    penDown = true;
  }
  public void print(String string)
  {
    // TODO Auto-generated method stub
  }
  public void hide()
  {
    hidden = true;
  }
  public boolean isHidden()
  {
    return hidden;
  }
  public void moveTo(final int x, final int y)
  {
    ThreadLauncher.launch(new Action0()
    {
      @Override
      public void call()
      {
        moveSynchronized(x, y);
      }
    });
  }
  public void moveSynchronized(int x, int y)
  {
    double angleOfWherePointIs = angleCalculator(getX(), getY(), x, y);
    double direction = angleOfWherePointIs - getAngleInDegrees();
    turn(direction);
    // move the turtle the distance to the x y point
    double distance = new Point(x, y).distance(getX(), getY());
    move(distance);
  }
  public static double angleCalculator(int x1, int y1, int x2, int y2)
  {
    int delta_x = x1 - x2;
    int delta_y = y1 - y2;
    double theta_radians = Math.atan2(delta_y, delta_x);
    double degrees = Math.toDegrees(theta_radians);
    double degreesWith0North = degrees - 90;
    return degreesWith0North;
  }
  public void setPanel(TurtlePanel panel)
  {
    this.panel = panel;
  }
  public void drawStar(int size)
  {
    for (int i = 1; i <= 5; i++)
    {
      this.turn(360 / 2.5);
      this.move(size);
    }
  }
  public boolean isDead()
  {
    return this.animal == Animals.ExplodedTurtle;
  }
}
