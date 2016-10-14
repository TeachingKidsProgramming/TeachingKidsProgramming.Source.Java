package org.teachingkidsprogramming.recipes.completed.section05recursion.KataQuestions;

import java.awt.Color;
import java.util.HashMap;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
//------------Kata Question---------------//
//How would you add a second tree?
//Write out the steps in English 
//Then translate the steps into code
//Make sure to run after each line
//
public class TurtleTreeKataQuestion
{
  public static void main(String[] args)
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Grays.Black);
    int branchLength = 60;
    drawBranch(branchLength);
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
  public static void adjustColor(int branchLength)
  {
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(10, PenColors.Greens.Lime);
    colors.put(20, PenColors.Greens.ForestGreen);
    colors.put(30, PenColors.Greens.DarkGreen);
    colors.put(40, PenColors.Greens.Olive);
    colors.put(50, PenColors.Browns.Sienna);
    colors.put(60, PenColors.Browns.SaddleBrown);
    Tortoise.setPenColor(colors.get(branchLength));
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
    drawBranch(branchLength - 10);
  }
}