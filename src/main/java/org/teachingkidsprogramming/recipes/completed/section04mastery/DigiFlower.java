package org.teachingkidsprogramming.recipes.completed.section04mastery;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class DigiFlower
{
  public static void main(String[] args)
  {
    //    Show the tortoise --#1
    Tortoise.show();
    //    Make the tortoise move as fast as possible --#6
    Tortoise.setSpeed(10);
    //    Make the background silver (use PenColors) --#7
    Tortoise.getBackgroundWindow().setBackground(PenColors.Grays.Silver);
    //    Make the line the tortoise draws 3 pixels wide --#12
    Tortoise.setPenWidth(3);
    //    CreateColorPalette (recipe below) --#8.1
    createColorPalette();
    //    Do the following 15 times --#11.1
    for (int i = 0; i < 15; i++)
    {
      //    DrawOctogon (recipe below) --#9.1
      drawOctogon();
      //     Turn the tortoise 1/15th of 360 degrees to the right --#10
      Tortoise.turn(360.0 / 15);
    }
  }
  //    ------------- Recipe for CreateColorPalette --#8.2
  private static void createColorPalette()
  {
    Color color1 = PenColors.Reds.Red;
    Color color2 = PenColors.Oranges.DarkOrange;
    Color color3 = PenColors.Yellows.Gold;
    Color color4 = PenColors.Yellows.Yellow;
    ColorWheel.addColor(color1);
    ColorWheel.addColor(color2);
    ColorWheel.addColor(color3);
    ColorWheel.addColor(color4);
    ColorWheel.addColor(color4);
    ColorWheel.addColor(color3);
    ColorWheel.addColor(color2);
    ColorWheel.addColor(color1);
    //  ------------- End of createColorPalette recipe --#8.3
  }
  //    ------------- Recipe for DrawOctogon --#9.2
  private static void drawOctogon()
  {
    //     Do the following 8 times --#5.1
    for (int i = 0; i < 8; i++)
    {
      //     Change the pen color of the line the tortoise draws to the next color on the color wheel --#3
      Tortoise.setPenColor(ColorWheel.getNextColor());
      //     Move the tortoise 50 pixels --#2
      Tortoise.move(50);
      //     Turn the tortoise 1/8th of 360 degrees to the right --#4
      Tortoise.turn(360.0 / 8);
      //    End Repeat --#5.2 
    }
    //    ------------- End of drawOctogon recipe --#10.3
  }
}
