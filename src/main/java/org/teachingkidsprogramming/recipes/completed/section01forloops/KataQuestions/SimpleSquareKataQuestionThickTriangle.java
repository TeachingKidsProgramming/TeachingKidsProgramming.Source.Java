package org.teachingkidsprogramming.recipes.completed.section01forloops.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
//------------Kata Question---------------//
//  How would you make a triangle with 20px thick sides?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class SimpleSquareKataQuestionThickTriangle
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    int sides = 3;
    for (int i = 0; i < sides; i++)
    {
      Tortoise.setPenColor(PenColors.Blues.Blue);
      Tortoise.move(50);
      Tortoise.turn(360 / sides);
    }
  }
}
