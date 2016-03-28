package org.teachingkidsprogramming.recipes.completed.section00demos;

import org.teachingextensions.WindowUtils.ProgramWindow;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Circle;
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
    Circle circle = new Circle(100, PenColors.Blues.DarkBlue);
    circle.setCenter(x, y);
    circle.addTo(programWindow);
    Circle circle1 = new Circle(150, PenColors.Yellows.Yellow);
    circle1.setCenter(x + 150, y + 120);
    circle1.addTo(programWindow);
    new Text("Olá São Paulo").setTopLeft(100, 100).addTo(programWindow);
  }
  public static void main(String[] args)
  {
    new BrazilDemo();
  }
}