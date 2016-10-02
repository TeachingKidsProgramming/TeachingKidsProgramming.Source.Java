package org.teachingkidsprogramming.recipes.completed.section01forloops.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//------------Kata Question---------------//
// How would you make a hexagon... 
//     with 20px thick sides...
//     and with randomly colored lines
//     and with side lengths of 10 that increase by 2x each time?
//
public class SquareToIncreasingThickHexagonMultiColor_ANSWER_06
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.setPenWidth(20);
    int sides = 7;
    for (int i = 0; i < sides; i++)
    {
      Tortoise.setPenColor(PenColors.getRandomColor());
      Tortoise.move(10 * 2 * i);
      Tortoise.turn(360 / sides);
    }
  }
}
