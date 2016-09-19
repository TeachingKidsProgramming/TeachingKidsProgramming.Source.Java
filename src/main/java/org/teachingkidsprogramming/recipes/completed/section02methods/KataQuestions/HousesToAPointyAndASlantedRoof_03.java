package org.teachingkidsprogramming.recipes.completed.section02methods.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//------------Kata Question---------------//
//  How would you make a pointy roof
//      and how would make a slanted roof?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class HousesToAPointyAndASlantedRoof_03
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.setX(200);
    int height = 40;
    drawHouse(height);
    drawHouse(120);
    drawHouse(90);
    drawHouse(20);
  }
  public static void drawHouse(int height)
  {
    Tortoise.setPenColor(PenColors.Grays.LightGray);
    Tortoise.move(height);
    drawSlantedRoof();
    Tortoise.move(height);
    Tortoise.turn(-90);
    Tortoise.move(20);
    Tortoise.turn(-90);
  }
  private static void drawSlantedRoof()
  {
    Tortoise.turn(45);
    Tortoise.move(60);
    Tortoise.turn(135);
    Tortoise.move(45);
  }
  private static void drawPointyRoof()
  {
    Tortoise.turn(45);
    Tortoise.move(30);
    Tortoise.turn(90);
    Tortoise.move(30);
    Tortoise.turn(45);
  }
}
