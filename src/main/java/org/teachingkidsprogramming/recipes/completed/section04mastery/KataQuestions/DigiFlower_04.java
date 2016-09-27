package org.teachingkidsprogramming.recipes.completed.section04mastery.KataQuestions;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
//------------Kata Question---------------//
//How would you change the shape of a flower petal?
//Refactor the number of petals as a method
//Refactor (rename) the petal-making method
//Draw more than one flower
//Write out the steps in English 
//Then translate the steps into code
//Make sure to run after each line
//
public class DigiFlower_04
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Grays.Silver);
    Tortoise.setPenWidth(3);
    createColorPalette();
    Tortoise.setX(150);
    Tortoise.setY(150);
    drawFlower();
    Tortoise.setX(400);
    Tortoise.setY(300);
    drawFlower();
  }
  private static void drawFlower()
  {
    for (int i = 0; i < 15; i++)
    {
      drawPetal();
      Tortoise.turn(360.0 / 15);
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
  private static void drawPetal()
  {
    for (int i = 0; i < 8; i++)
    {
      Tortoise.setPenColor(ColorWheel.getNextColor());
      Tortoise.move(50);
      Tortoise.turn(360.0 / 8);
    }
  }
}
