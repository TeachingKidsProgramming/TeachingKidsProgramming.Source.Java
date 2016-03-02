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
  //
  //    TIP: Here's one possible set of English comments to solve this challenge
  //    note the re-factoring as well 
  //
  //    Show the tortoise 
  //    Make the tortoise move as fast as possible 
  //    Change the pen color of the line the tortoise draws to blue 
  //    Do the following 2 times 
  //      Draw one side
  //        Draw a line of 75 pixels
  //        Turn to the right
  //      Draw the top or bottom
  //        Draw a line of 150 pixels
  //        Turn to the right
  //    Repeat
  //
}
