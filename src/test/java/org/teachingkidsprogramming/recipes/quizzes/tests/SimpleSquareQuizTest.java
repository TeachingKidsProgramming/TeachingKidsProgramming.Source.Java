package org.teachingkidsprogramming.recipes.quizzes.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.reporters.ClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleSquareQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.SquareQuiz;

@UseReporter({ClipboardReporter.class, DiffReporter.class})
public class SimpleSquareQuizTest
{
  public static class SimpleSquareCorrectQuiz implements SquareQuiz
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
  }
  @Test
  public void testCorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    SimpleSquareQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new SimpleSquareQuizGrader().grade(new SimpleSquareCorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
  public static class SimpleSquareIncorrectQuiz implements SquareQuiz
  {
    @Override
    public void question1()
    {
      // Move the tortoise 110 pixels
      Tortoise.move(75);
    }
    @Override
    public void question2()
    {
      // Turn the tortoise 1/5 of 360 degrees to the right
      Tortoise.turn(360.0 / 6);
    }
    @Override
    public void question3()
    {
      // Change the color the tortoise draws to yellow
      Tortoise.setPenColor(PenColors.Yellows.Gold);
    }
    @Override
    public void question4()
    {
      // Change the width of the line the tortoise draws to 5 pixels
      Tortoise.setPenWidth(9);
    }
  }
  @Test
  public void testIncorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    SimpleSquareQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new SimpleSquareQuizGrader().grade(new SimpleSquareIncorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
}
