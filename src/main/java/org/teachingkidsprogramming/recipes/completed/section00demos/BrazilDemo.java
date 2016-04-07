package org.teachingkidsprogramming.recipes.completed.section00demos;

import org.teachingextensions.WindowUtils.ProgramWindow;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Circle;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Diamond;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Text;

public class BrazilDemo implements MouseLeftClickListener
{
  private ProgramWindow programWindow;
  public BrazilDemo()
  {
    programWindow = new ProgramWindow("I <3 Brasil");
    programWindow.setWindowVisible(true);
    programWindow.addMouseLeftClickListener(this);
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    programWindow.setBackground(PenColors.Greens.Green);
    createFlag(x, y);
  }
  private void createFlag(int x, int y)
  {
    programWindow.clearWindow();
    Diamond diamond = new Diamond(200, PenColors.Yellows.Yellow);
    diamond.setCorners(x, y);
    diamond.addTo(programWindow);
    new Text("Olá São Paulo").setTopLeft(x, y).addTo(programWindow);
    Circle circle = new Circle(100, PenColors.Blues.DarkBlue);
    circle.setCenter(x + 200, y + 150);
    circle.addTo(programWindow);
  }
  public static void main(String[] args)
  {
    new BrazilDemo();
  }
}