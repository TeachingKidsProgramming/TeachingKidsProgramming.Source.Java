package org.teachingkidsprogramming.recipes.completed.section02methods.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//
// For teacher - reflect on this code vs. the staring code block
// Ask students "Why is human readability for code important?"
// Also "What makes this code more readable than first code sample in this lesson?"
//
public class PyramidsOfGiza_ANSWER_04a
{
  public static void main(String[] args) throws Exception
  {
    setUpPyramidLand();
    drawPyramids(3);
  }
  private static void drawPyramids(int numberOfPyramids)
  {
    for (int i = 0; i < numberOfPyramids; i++)
    {
      drawPyramid();
      positionNextPyramid(90, 140, -45);
    }
  }
  private static void drawPyramid()
  {
    drawPyramidSide(100, 90);
    drawPyramidSide(100, 135);
    drawPyramidSide(140, 90);
  }
  private static void positionNextPyramid(int angleToTurn, int lengthToMove, int angleToTurnTwo)
  {
    Tortoise.turn(angleToTurn);
    Tortoise.move(lengthToMove);
    Tortoise.turn(angleToTurnTwo);
  }
  private static void drawPyramidSide(int move, int turn)
  {
    Tortoise.move(move);
    Tortoise.turn(turn);
  }
  private static void setUpPyramidLand()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Blues.AliceBlue);
    Tortoise.setPenColor(PenColors.Yellows.DarkGoldenrod);
    Tortoise.setPenWidth(2);
    Tortoise.hide();
    Tortoise.setX(500);
    Tortoise.turn(-90);
    Tortoise.move(423);
    Tortoise.turn(135);
  }
}
