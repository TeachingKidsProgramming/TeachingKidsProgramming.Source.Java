package org.teachingkidsprogramming.recipes.completed.section01forloops;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
//------------Kata Question---------------//
//  How would you make a triangle?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class SimpleSquareKataQuestion
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    for (int i = 0; i < 4; i++)
    {
      Tortoise.setPenColor(PenColors.Blues.Blue);
      Tortoise.move(50);
      Tortoise.turn(90);
    }
  }
}
