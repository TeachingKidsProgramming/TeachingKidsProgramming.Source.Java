package org.teachingkidsprogramming.recipes.completed.section04mastery.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
//------------Knotting Ring Kata---------------//
//  Use the Tortoise to draw a knotted ring (draw the shape FIRST)
//  Implement the createColorPalette() method to set up your colors, use blue tones
//  Write each of the English line comments (use at least 8 line comments)
//  Number each comment line at the end
//  Verify - step one -  Translate EACH comment line into code 
//  Verify - step two -  Run your code after each line
//
public class CompleteKnottedRing_ANSWER
{
  public static void main(String[] args)
  {
    Tortoise.show();
    //    Make the tortoise move as fast as possible --#4
    Tortoise.setSpeed(10);
    createColorPalette();
    //    Do the following 30 times --#10.1
    for (int i = 0; i < 30; i++)
    {
      //       Change the pen color of the line the tortoise draws to the next color from the color wheel --#5
      Tortoise.setPenColor(ColorWheel.getNextColor());
      //       drawSeptagonWithOverlap (recipe below) --#8.0
      drawSeptagonWithOverlap();
      //       Turn the tortoise 1/30th of 360 degrees to the right --#9
      Tortoise.turn(360.0 / 30);
      //       Turn the tortoise 5 more degrees to the right --#11
      Tortoise.turn(5);
      //      Repeat --#10
    }
  }
  //    ------------- Recipe for drawSeptagonWithOverlap --#7.1
  private static void drawSeptagonWithOverlap()
  {
    //       Do the following 7 + 1 times --#3.1
    for (int i = 0; i < 8; i++)
    {
      //         Move the tortoise 95 pixels --#1
      Tortoise.move(95);
      //         Turn the tortoise 1/7th of 360 degrees to the right --#2
      Tortoise.turn(360.0 / 7);
      //         Repeat --#3.2
    }
    //      ------------- End of drawSeptagonWithOverlap recipe --#7.2
  }
  private static void createColorPalette()
  {
    ColorWheel.addColor(PenColors.Blues.DarkBlue);
    ColorWheel.addColor(PenColors.Blues.Aqua);
    ColorWheel.addColor(PenColors.Blues.DarkCyan);
    ColorWheel.addColor(PenColors.Blues.DarkSlateBlue);
    ColorWheel.addColor(PenColors.Blues.Blue);
    ColorWheel.addColor(PenColors.Blues.DodgerBlue);
    ColorWheel.addColor(PenColors.Blues.CornflowerBlue);
    ColorWheel.addColor(PenColors.Blues.Cyan);
  }
}
