package org.teachingkidsprogramming.recipes.completed.section05recursion.KataQuestions;

import org.teachingextensions.logo.Tortoise;

public class CompleteSnowflakeAnswer2
{
  //TODO: write comments and then code here
  public static void main(String[] args)
  {
    setUpTortoise();
    //have fun with the level
    int currentLevel = 9;
    drawTriangle(currentLevel);
  }
  private static void drawTriangle(int currentLevel)
  {
    drawTriangleCorner(currentLevel);
    if (currentLevel > 1)
    {
      Tortoise.turn(180);
      drawTriangle(currentLevel - 1);
      Tortoise.turn(180);
    }
    drawTriangleCorner(currentLevel);
    if (currentLevel > 1)
    {
      Tortoise.turn(180);
      drawTriangle(currentLevel - 1);
      Tortoise.turn(180);
    }
    drawTriangleCorner(currentLevel);
    if (currentLevel > 1)
    {
      Tortoise.turn(180);
      drawTriangle(currentLevel - 1);
      Tortoise.turn(180);
    }
  }
  private static void drawTriangleCorner(int currentLevel)
  {
    Tortoise.move(10 * currentLevel);
    Tortoise.turn(120);
    Tortoise.move(10 * currentLevel);
  }
  private static void setUpTortoise()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.turn(-90);
  }
}
