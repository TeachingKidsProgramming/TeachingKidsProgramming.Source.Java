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
    //    Make the tortoise move as fast as possible --#7
    Tortoise.setSpeed(10);
    //    Make the background silver (use PenColors) --#8
    Tortoise.getBackgroundWindow().setBackground(PenColors.Grays.Silver);
    //    Make the line the tortoise draws 3 pixels wide --#15
    Tortoise.setPenWidth(3);
    //    CreateColorPalette (recipe below) --#9
    createColorPalette();
    //    Do the following 15 times --#13
    for (int i = 0; i < 15; i++)
    {
      //    DrawOctogon (recipe below) --#10
      drawOctogon();
      //     Turn the tortoise 1/15th of 360 degrees to the right --#12
      Tortoise.turn(360.0 / 15);
    }
  }
  //    ------------- Recipe for CreateColorPalette --#9
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
    //
  }
  //    ------------- Recipe for DrawOctogon --#10
  private static void drawOctogon()
  {
    //     Do the following 8 times --#6
    for (int i = 0; i < 8; i++)
    {
      //     Change the pen color of the line the tortoise draws to the next color on the color wheel --#4
      Tortoise.setPenColor(ColorWheel.getNextColor());
      //     Move the tortoise 50 pixels --#2
      Tortoise.move(50);
      //     Turn the tortoise 1/8th of 360 degrees to the right --#5
      Tortoise.turn(360.0 / 8);
    }
  }
}
