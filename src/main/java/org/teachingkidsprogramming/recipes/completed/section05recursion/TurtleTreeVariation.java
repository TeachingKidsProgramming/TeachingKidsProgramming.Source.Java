package org.teachingkidsprogramming.recipes.completed.section05recursion;

import java.awt.Color;
import java.util.HashMap;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class TurtleTreeVariation
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Yellows.Goldenrod);
    int branchLength = 65;
    drawTree(branchLength, 170, 350);
    branchLength = 60;
    drawTree(branchLength, 450, 350);
  }
  private static void drawTree(int branchLength, int x, int y)
  {
    Tortoise.setX(x);
    Tortoise.setY(y);
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
    colors.put(51, PenColors.Greens.Olive);
    colors.put(54, PenColors.Browns.Sienna);
    colors.put(59, PenColors.Grays.DarkSlateGray);
    Tortoise.setPenColor(colors.get(branchLength));
  }
}