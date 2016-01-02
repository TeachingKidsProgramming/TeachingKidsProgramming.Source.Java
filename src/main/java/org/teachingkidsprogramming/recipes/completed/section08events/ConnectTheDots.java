package org.teachingkidsprogramming.recipes.completed.section08events;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.EventUtils.MouseRightClickListener;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Circle;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Text;

public class ConnectTheDots implements MouseRightClickListener, MouseLeftClickListener
{
  public static void main(String[] args)
  {
    new ConnectTheDots();
  }
  public ConnectTheDots()
  {
    setUpTheWindow();
    prepareColorPalette();
    // NOTE for teachers: Using the Tortoise object here as we are having the Tortoise draw a line (trail)  for this recipe
    // Listen for left clicks on the window for the tortoise 
    Tortoise.getBackgroundWindow().addMouseLeftClickListener(this);
    // Listen for right clicks on the window for the tortoise
    Tortoise.getBackgroundWindow().addMouseRightClickListener(this);
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    //  addDot at x and y (recipe below)
    addDot(x, y);
    //  Uncomment to write the text "Right click to clear the window" on the screen at position 100, 100
    new Text("Right click to clear the window").setTopLeft(100, 100).addTo(Tortoise.getBackgroundWindow());
  }
  private void addDot(int x, int y)
  {
    //   createCircle at x and y (recipe below)
    createCircle(x, y);
    //   Move the tortoise to the current position of the mouse (x,y)
    Tortoise.moveTo(x, y);
  }
  private void createCircle(int x, int y)
  {
    //   Create a new circle with a radius size of 11 using the next color on the Color wheel
    Circle circle = new Circle(11, ColorWheel.getNextColor());
    //   Change the circle to be 60% opaque
    circle.setTransparency(40);
    //   Move the center of the circle to the current position of the mouse (x,y)
    circle.setCenter(x, y);
    //   Add the circle to the window HINT: Use Tortoise to get the window
    circle.addTo(Tortoise.getBackgroundWindow());
  }
  @Override
  public void onRightMouseClick(int x, int y)
  {
    //   Clear everything from the window HINT: Use Tortoise
    Tortoise.clear();
  }
  private static void prepareColorPalette()
  {
    ColorWheel.addColor(PenColors.Reds.Red);
    ColorWheel.addColor(PenColors.Greens.Green);
    ColorWheel.addColor(PenColors.Blues.Blue);
    ColorWheel.addColor(PenColors.Purples.Purple);
    ColorWheel.addColor(PenColors.Pinks.Pink);
    ColorWheel.addColor(PenColors.Greens.Teal);
  }
  private void setUpTheWindow()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.hide();
  }
}
