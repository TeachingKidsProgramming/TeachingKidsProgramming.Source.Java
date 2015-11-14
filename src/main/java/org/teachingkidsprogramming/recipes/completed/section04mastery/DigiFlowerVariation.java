package org.teachingkidsprogramming.recipes.completed.section04mastery;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class DigiFlowerVariation
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Whites.Ivory);
    Tortoise.setPenWidth(1);
    createColorPalette();
    int outerNumber = 200;
    for (int i = 0; i < outerNumber; i++)
    {
      drawOctogon();
      Tortoise.turn(360.0 / (outerNumber / 50));
      Tortoise.move(outerNumber / 50);
    }
  }
  private static void createColorPalette()
  {
    Color color1 = PenColors.getRandomColor();
    Color color2 = PenColors.getRandomColor();
    Color color3 = PenColors.getRandomColor();
    Color color4 = PenColors.getRandomColor();
    ColorWheel.addColor(color1);
    ColorWheel.addColor(color2);
    ColorWheel.addColor(color3);
    ColorWheel.addColor(color4);
    ColorWheel.addColor(color4);
    ColorWheel.addColor(color3);
    ColorWheel.addColor(color2);
    ColorWheel.addColor(color1);
  }
  private static void drawOctogon()
  {
    int integralNumber = 13;
    for (int i = 0; i < integralNumber; i++)
    {
      Tortoise.setPenColor(ColorWheel.getNextColor());
      Tortoise.move(7 * (i + 8));
      Tortoise.turn(361.0 * 5 / integralNumber);
    }
  }
}
