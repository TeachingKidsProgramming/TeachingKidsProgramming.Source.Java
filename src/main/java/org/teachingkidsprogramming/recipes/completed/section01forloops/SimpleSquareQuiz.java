package org.teachingkidsprogramming.recipes.completed.section01forloops;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleSquareQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.SquareQuiz;

public class SimpleSquareQuiz implements SquareQuiz
{
  @Override
  public void question1()
  {
    // Move the tortoise 110 pixels
    Tortoise.move(110);
  }
  @Override
  public void question2()
  {
    // Turn the tortoise 1/5 of 360 degrees to the right
    Tortoise.turn(360 / 5);
  }
  @Override
  public void question3()
  {
    // Change the color the tortoise draws to yellow
    Tortoise.setPenColor(PenColors.Yellows.Yellow);
  }
  @Override
  public void question4()
  {
    // Change the width of the line the tortoise draws to 5 pixels
    Tortoise.setPenWidth(5);
  }
  public static void main(String[] args)
  {
    new SimpleSquareQuizGrader().grade(new SimpleSquareQuiz());
  }
}
