package org.teachingkidsprogramming.recipes.completed.section00demos;

import java.awt.Color;
import java.util.Random;

import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class QuickSquare
{
  public static void main(String[] args) throws Exception
  {
    Random r = new Random();
    int sides = r.nextInt(10) + 1;
    Color color = PenColors.Reds.Red;
    int length = 50;
    int width = 40;
    //Have the Tortoise draw a blue square that is 50 pixel on each side
    Tortoise.drawShape(sides, color, length, width);
  }
}
