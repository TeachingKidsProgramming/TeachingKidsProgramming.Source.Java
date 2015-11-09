package org.teachingkidsprogramming.recipes.completed.section05recursion;

import java.awt.Color;
import java.util.HashMap;

import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class TurtleTreeVariation
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Yellows.Goldenrod);
    int branchLength = 65;
    Tortoise.setX(175);
    Tortoise.setY(350);
    drawBranch(branchLength);
    drawBranch(branchLength - 1);
    Tortoise.setX(450);
    Tortoise.setY(350);
    drawBranch(branchLength);
    drawBranch(branchLength - 1);
  }
  public static void drawBranch(int branchLength)
  {
    if (branchLength > 0)
    {
      adjustColor(branchLength);
      Tortoise.move(branchLength);
      drawLowerBranches(branchLength);
    }
  }
  public static void drawLowerBranches(int branchLength)
  {
    Tortoise.turn(30);
    drawShorterBranches(branchLength);
    Tortoise.turn(-60);
    drawShorterBranches(branchLength);
    Tortoise.turn(30);
    adjustColor(branchLength);
    Tortoise.move(-branchLength);
  }
  public static void drawShorterBranches(int branchLength)
  {
    drawBranch(branchLength - 9);
  }
  public static void adjustColor(int branchLength)
  {
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(30, PenColors.Greens.Olive);
    colors.put(40, PenColors.Browns.Sienna);
    colors.put(50, PenColors.Browns.SaddleBrown);
    Tortoise.setPenColor(colors.get(branchLength));
  }
}