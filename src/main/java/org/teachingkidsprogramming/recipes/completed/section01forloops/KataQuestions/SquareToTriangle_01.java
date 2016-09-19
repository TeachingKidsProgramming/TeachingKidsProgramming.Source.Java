package org.teachingkidsprogramming.recipes.completed.section01forloops.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//------------Kata Question---------------//
//  How would you make an equilateral triangle?
//
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class SquareToTriangle_01
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
