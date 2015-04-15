package org.teachingkidsprogramming.recipes.completed.section07events;

import org.teachingextensions.approvals.lite.util.NumberUtils;
import org.teachingextensions.logo.ColorWheel;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.shapes.Circle;
import org.teachingextensions.windows.MouseLeftClickListener;
import org.teachingextensions.windows.ProgramWindow;

public class SimpleBubbleVariation implements MouseLeftClickListener
{
  //TODO: Need to add array to make this into a Bubble "Wand"
  private ProgramWindow programWindow;
  public SimpleBubbleVariation()
  {
    programWindow = new ProgramWindow("Bubbles");
    programWindow.addMouseLeftClickListener(this);
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
    createBubble(x, y);
  }
  private void createBubble(int x, int y)
  {
    programWindow.removePaintable();
    int radius = NumberUtils.getRandomInt(10, 50);
    Circle circle = new Circle(radius, ColorWheel.getNextColor());
    circle.setCenter(x, y);
    circle.addTo(programWindow);
  }
  public static void main(String[] args)
  {
    new SimpleBubbleVariation();
  }
}