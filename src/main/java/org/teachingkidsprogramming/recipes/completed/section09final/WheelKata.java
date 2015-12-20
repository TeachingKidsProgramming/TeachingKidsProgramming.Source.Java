package org.teachingkidsprogramming.recipes.completed.section09final;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class WheelKata
{
  public static void main(String[] args)
  {
    setUpTheDrawing();
    for (int i = 0; i < 20; i++)
    {
      drawTwoSides();
      Tortoise.move(150);
      Tortoise.turn(90);
    }
    Tortoise.move(2);
  }
  private static void setUpTheDrawing()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.setY(175);
    Tortoise.setPenColor(PenColors.Blues.Blue);
    Tortoise.setPenWidth(5);
  }
  private static void drawTwoSides()
  {
    for (int i = 0; i < 2; i++)
    {
      drawASide();
    }
  }
  private static void drawASide()
  {
    Tortoise.move(150);
    Tortoise.turn(125);
  }
}
