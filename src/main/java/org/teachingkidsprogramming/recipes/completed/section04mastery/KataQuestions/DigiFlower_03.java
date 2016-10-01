package org.teachingkidsprogramming.recipes.completed.section04mastery.KataQuestions;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
//------------Kata Question---------------//
//How would you draw more than one flower?
//
public class DigiFlower_03
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Grays.Silver);
    Tortoise.setPenWidth(3);
    createColorPalette();
    drawFlower();
  }
  private static void drawFlower()
  {
    int numberOfPetals = 15;
    for (int i = 0; i < numberOfPetals; i++)
    {
      drawPetal();
      Tortoise.turn(360.0 / numberOfPetals);
    }
  }
  private static void drawPetal()
  {
    int petalShape = 8;
    for (int i = 0; i < petalShape; i++)
    {
      Tortoise.setPenColor(ColorWheel.getNextColor());
      Tortoise.move(50);
      Tortoise.turn(360.0 / petalShape);
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
