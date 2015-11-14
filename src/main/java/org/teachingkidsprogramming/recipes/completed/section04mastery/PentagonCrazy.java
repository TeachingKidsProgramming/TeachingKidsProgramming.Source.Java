package org.teachingkidsprogramming.recipes.completed.section04mastery;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class PentagonCrazy
{
  public static void main(String[] args)
  {
    Tortoise.show();
    //    Make the tortoise move as fast as possible --#3
    Tortoise.setSpeed(10);
    //    CreateColorPalette (recipe below) --#8
    createColorPalette();
    //    DrawPentagon (recipe below) --#10
    drawPentagon();
  }
  //    ------------- Recipe for CreateColorPalette (HINT: Use PenColors) --#8
  private static void createColorPalette()
  {
    //     Add steel blue to the color wheel --#7
    ColorWheel.addColor(PenColors.Blues.SteelBlue);
    //     Add dark orchid to the color wheel --#11
    ColorWheel.addColor(PenColors.Purples.DarkOrchid);
    //     Add dark slate blue to the color wheel --#12
    ColorWheel.addColor(PenColors.Blues.DarkSlateBlue);
    //     Add teal to the color wheel --#13
    ColorWheel.addColor(PenColors.Blues.Teal);
    //     Add indigo to the color wheel --#14
    ColorWheel.addColor(PenColors.Purples.Indigo);
  }
  //    ------------- End of CreateColorPalette recipe 
  //    ------------- Recipe for AdjustPen --#9
  private static void adjustPen()
  {
    //     Change the color of the line the tortoise draws to the next color on the color wheel --#6
    Tortoise.setPenColor(ColorWheel.getNextColor());
    //     Increase the tortoises pen width by 1 --#15                                               
    Tortoise.setPenWidth(Tortoise.getPenWidth() + 1.0);
    //     If the tortoises pen width is greater than 4, then --#17
    if (Tortoise.getPenWidth() > 4)
    {
      //     Reset it to 1 --#16
      Tortoise.setPenWidth(1);
    }
  }
  //    ------------- End of AdjustPen recipe 
  //    ------------- Recipe for DrawPentagon --#10
  private static void drawPentagon()
  {
    //    Do the following 200 times --#2
    for (int i = 0; i < 200; i++)
    {
      //     AdjustPen (recipe below) --#9
      adjustPen();
      //     Move the tortoise the length of a side --#4
      Tortoise.move(i);
      //     Turn the tortoise 1/5th of 360 degrees --#1
      Tortoise.turn(360.0 / 5);
      //     Turn the tortoise 1 more degree --#5
      Tortoise.turn(1);
    }
  }
  //    ------------- End of DrawPentagon recipe
}
