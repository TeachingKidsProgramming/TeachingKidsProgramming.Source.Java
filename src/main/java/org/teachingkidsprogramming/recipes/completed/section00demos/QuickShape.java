package org.teachingkidsprogramming.recipes.completed.section00demos;

import java.util.Random;

import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class QuickShape
{
  public static void main(String[] args) throws Exception
  {
    //Tip: Use the Tortoise to draw!
    //Draw a red square that is 50 pixels per side with a line that's 2 pixels thick
    Tortoise.setX(150);
    Tortoise.drawShape(4, PenColors.Reds.Red, 75, 4);
    //
    //Draw a blue hexagon that is 65 pixels per side with a line that's 40 pixels thick
    Tortoise.setX(425);
    Tortoise.drawShape(6, PenColors.Blues.Blue, 65, 40);
    //
    Tortoise.setX(250);
    Tortoise.setY(375);
    Random r = new Random();
    int sides = r.nextInt(10) + 1;
    //Draw a purple shape that is 50 pixel on each side with a line that's 10 pixels thick
    Tortoise.drawShape(sides, PenColors.Purples.Purple, 50, 10);
  }
}
