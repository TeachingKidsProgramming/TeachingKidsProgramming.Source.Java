package org.teachingkidsprogramming.recipes.completed.section09final;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class RectangleKata
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.setPenColor(PenColors.Blues.Blue);
    for (int i = 0; i < 2; i++)
    {
      drawSide();
      drawTopOrBottom();
    }
  }
  private static void drawSide()
  {
    Tortoise.move(75);
    Tortoise.turn(90);
  }
  private static void drawTopOrBottom()
  {
    Tortoise.move(150);
    Tortoise.turn(90);
  }
}
