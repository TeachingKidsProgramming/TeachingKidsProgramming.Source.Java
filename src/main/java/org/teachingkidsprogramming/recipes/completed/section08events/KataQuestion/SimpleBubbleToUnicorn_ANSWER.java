package org.teachingkidsprogramming.recipes.completed.section08events.KataQuestion;

import org.teachingextensions.WindowUtils.ProgramWindow;
import org.teachingextensions.approvals.lite.util.NumberUtils;
import org.teachingextensions.logo.Unicorn;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.EventUtils.MouseRightClickListener;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Circle;

//
//------------Kata Question---------------//
//  How would you change your bubble into a unicorn when you right click on the window?
//  Write out the steps in English
//  Then translate the steps into code
//  Make sure to run after each line
//
public class SimpleBubbleToUnicorn_ANSWER implements MouseLeftClickListener, MouseRightClickListener
{
  private ProgramWindow programWindow;
  public SimpleBubbleToUnicorn_ANSWER()
  {
    programWindow = new ProgramWindow("My Bubble --> Unicorn");
    programWindow.setWindowVisible(true);
    programWindow.addMouseLeftClickListener(this);
    programWindow.addMouseRightClickListener(this);
    prepareColorPalette();
  }
  private void prepareColorPalette()
  {
    ColorWheel.addColor(PenColors.Blues.LightSteelBlue);
    ColorWheel.addColor(PenColors.Blues.Blue);
    ColorWheel.addColor(PenColors.Blues.DarkBlue);
    ColorWheel.addColor(PenColors.Purples.Purple);
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    createBubble(x, y);
  }
  @Override
  public void onRightMouseClick(int x, int y)
  {
    createUnicorn(x, y, 50);
  }
  private void createUnicorn(int x, int y, int size)
  {
    programWindow.clearWindow();
    Unicorn u = new Unicorn(x, y, size);
    u.addTo(programWindow);
  }
  private void createBubble(int x, int y)
  {
    programWindow.clearWindow();
    int radius = NumberUtils.getRandomInt(10, 50);
    Circle circle = new Circle(radius, ColorWheel.getNextColor());
    circle.setCenter(x, y);
    circle.addTo(programWindow);
  }
  public static void main(String[] args)
  {
    new SimpleBubbleToUnicorn_ANSWER();
  }
}
