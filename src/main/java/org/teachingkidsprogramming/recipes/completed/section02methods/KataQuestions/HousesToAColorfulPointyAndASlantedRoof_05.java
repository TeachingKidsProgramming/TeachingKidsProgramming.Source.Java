package org.teachingkidsprogramming.recipes.completed.section02methods.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//------------Kata Question---------------//
//  How would you make a pointy roof
//      and how would make a slanted roof
//      and change the color of the houses?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class HousesToAColorfulPointyAndASlantedRoof_05
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.setX(200);
    int height = 40;
    drawSlantedRoofHouse(height);
    drawPointyRoofHouse(120);
    drawSlantedRoofHouse(90);
    drawPointyRoofHouse(20);
  }
  public static void drawSlantedRoofHouse(int height)
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
  public static void drawPointyRoofHouse(int height)
  {
    Tortoise.setPenColor(PenColors.Grays.LightGray);
    Tortoise.move(height);
    drawPointyRoof();
    Tortoise.move(height);
    Tortoise.turn(-90);
    Tortoise.move(20);
    Tortoise.turn(-90);
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
