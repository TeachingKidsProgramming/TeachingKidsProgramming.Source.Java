package org.teachingkidsprogramming.recipes.completed.section02methods.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//------------Kata Question---------------//
//  Where do you see duplicate lines of code?
//      and how can you re-factor to make this code more readable?
//
//  Note: This answer is more advanced than the student's knowledge at this point
//  The answer is for teacher preparation (for future lessons)
//  It is also somewhat academic to illustrate 'too much re-factoring'
//  Which results in reduced human readability
//
public class PyramidsOfGizaRemoveEvenMoreDuplication_ANSWER_04
{
  public static void main(String[] args) throws Exception
  {
    setUpPyramidLand();
    int[][] degreesAndLength = {{-90, 220},
                                {135, 100},
                                {90, 100},
                                {-90, 100},
                                {90, 100},
                                {-90, 100},
                                {90, 100},
                                {135, 210}};
    for (int[] i : degreesAndLength)
    {
      Tortoise.turn(i[0]);
      Tortoise.move(i[1]);
    }
  }
  private static void setUpPyramidLand()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Blues.AliceBlue);
    Tortoise.setPenColor(PenColors.Yellows.DarkGoldenrod);
    Tortoise.setPenWidth(2);
    Tortoise.hide();
  }
}
