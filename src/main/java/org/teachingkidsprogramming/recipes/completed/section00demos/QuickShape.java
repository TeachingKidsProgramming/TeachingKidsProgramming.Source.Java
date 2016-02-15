package org.teachingkidsprogramming.recipes.completed.section00demos;

import java.util.Random;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class QuickShape
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setAnimal(Animals.Squid);
    Tortoise.setX(150);
    Tortoise.drawShape(4, PenColors.Reds.Red, 75, 4);
    Tortoise.setX(425);
    Tortoise.drawShape(6, PenColors.Blues.Blue, 65, 40);
    Tortoise.setX(250);
    Tortoise.setY(375);
    Random r = new Random();
    int sides = r.nextInt(10) + 1;
    Tortoise.drawShape(sides, PenColors.Purples.Purple, 50, 10);
  }
}
