package org.teachingkidsprogramming.recipes.completed.section04mastery;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class KnottedRing
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
      //       drawOctagonWithOverlap (recipe below) --#8.0
      drawOctagonWithOverlap();
      //       Turn the tortoise 1/30th of 360 degrees to the right --#9
      Tortoise.turn(360.0 / 30);
      //       Turn the tortoise 5 more degrees to the right --#11
      Tortoise.turn(5);
      //      Repeat --#10
    }
  }
  private static void createColorPalette()
  {
    ColorWheel.addColor(PenColors.Pinks.HotPink);
    ColorWheel.addColor(PenColors.Reds.Red);
    ColorWheel.addColor(PenColors.Pinks.Fuchsia);
    ColorWheel.addColor(PenColors.Reds.OrangeRed);
    ColorWheel.addColor(PenColors.Pinks.DeepPink);
    ColorWheel.addColor(PenColors.Reds.MediumVioletRed);
    ColorWheel.addColor(PenColors.Reds.Crimson);
    ColorWheel.addColor(PenColors.Reds.Tomato);
  }
  private static void drawOctagonWithOverlap()
  {
    //    ------------- Recipe for drawOctagonWithOverlap --#7.1
    //       Do the following 8 + 1 times --#3.1
    for (int i = 0; i < 9; i++)
    {
      //         Move the tortoise 110 pixels --#1
      Tortoise.move(110);
      //         Turn the tortoise 1/8th of 360 degrees to the right --#2
      Tortoise.turn(360.0 / 8);
    }
    //         Repeat --#3.2
    //      ------------- End of drawOctagonWithOverlap recipe --#7.2
  }
}
