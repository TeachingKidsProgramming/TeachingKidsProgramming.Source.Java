package org.teachingkidsprogramming.recipes.completed.section04mastery.KataQuestions;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
//------------Kata Question---------------//
//  How can you easily change the shape of a flower petal?
//      Re factor the number of petals as a method
//      Re factor (rename) the petal-making method
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class DigiFlower_01
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Grays.Silver);
    Tortoise.setPenWidth(3);
    createColorPalette();
    for (int i = 0; i < 15; i++)
    {
      drawOctogon();
      Tortoise.turn(360.0 / 15);
    }
  }
  private static void drawOctogon()
  {
    for (int i = 0; i < 8; i++)
    {
      Tortoise.setPenColor(ColorWheel.getNextColor());
      Tortoise.move(50);
      Tortoise.turn(360.0 / 8);
    }
  }
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
  }
}
