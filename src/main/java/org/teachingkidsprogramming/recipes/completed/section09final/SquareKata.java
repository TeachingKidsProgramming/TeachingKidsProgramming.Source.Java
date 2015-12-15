package org.teachingkidsprogramming.recipes.completed.section09final;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class SquareKata
{
  public static void main(String[] args)
  {
    //    Draw a square 
    //    HINT: Write each step in English FIRST, then translate to Java one line at a time
    //    TIP: Be sure to run after each line of Java to make sure it works as expected
    //  Show the tortoise --#1
    Tortoise.show();
    //  Make the tortoise move as fast as possible --#6
    Tortoise.setSpeed(10);
    //  Do the following 4 times --#5.1
    for (int i = 0; i < 4; i++)
    {
      //      Change the pen color of the line the tortoise draws to blue --#4
      Tortoise.setPenColor(PenColors.Blues.Blue);
      //      Move the tortoise 50 pixels --#2
      Tortoise.move(50);
      //      Turn the tortoise to the right (90 degrees) --#3
      Tortoise.turn(90);
    }
    //  Repeat --#5.2
  }
}
