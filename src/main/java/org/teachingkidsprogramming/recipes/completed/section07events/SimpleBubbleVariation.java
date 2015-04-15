package org.teachingkidsprogramming.recipes.completed.section07events;

import java.util.ArrayList;

import org.teachingextensions.approvals.lite.util.NumberUtils;
import org.teachingextensions.logo.ColorWheel;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.shapes.Circle;
import org.teachingextensions.windows.MouseLeftClickListener;
import org.teachingextensions.windows.MouseRightClickListener;
import org.teachingextensions.windows.ProgramWindow;

public class SimpleBubbleVariation implements MouseLeftClickListener, MouseRightClickListener
{
  private ProgramWindow programWindow;
  public SimpleBubbleVariation()
  {
    programWindow = new ProgramWindow("Bubbles");
    programWindow.addMouseLeftClickListener(this);
    programWindow.addMouseRightClickListener(this);
    prepareColorPalette();
  }
  private void prepareColorPalette()
  {
    ColorWheel.addColor(PenColors.Blues.AliceBlue);
    ColorWheel.addColor(PenColors.Blues.Blue);
    ColorWheel.addColor(PenColors.Blues.DarkBlue);
    ColorWheel.addColor(PenColors.Purples.Purple);
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    createBubbles(x, y);
  }
  @Override
  public void onRightMouseClick(int x, int y)
  {
    for (Circle circle : circles)
    {
      circle.removeFrom(programWindow);
      Unicorn u = new Unicorn(circle.getX(), circle.getY(), circle.getRadius());
      u.addTo(programWindow);
    }
  }
  ArrayList<Circle> circles = new ArrayList<Circle>();
  private void createBubble(int x, int y)
  {
    int radius = NumberUtils.getRandomInt(10, 50);
    Circle circle = new Circle(radius, ColorWheel.getNextColor());
    circle.setCenter(x, y);
    circle.addTo(programWindow);
    circles.add(circle);
  }
  private void createBubbles(int x1, int y1)
  {
    int size = 7;
    for (int i = 0; i < size; i++)
    {
      createBubble(x1 + i * 15, y1 + i * 15);
    }
  }
  public static void main(String[] args)
  {
    new SimpleBubbleVariation();
  }
}
