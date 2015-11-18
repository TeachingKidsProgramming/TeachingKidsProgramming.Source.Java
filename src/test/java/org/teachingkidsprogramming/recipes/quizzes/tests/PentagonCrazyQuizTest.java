package org.teachingkidsprogramming.recipes.quizzes.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingkidsprogramming.recipes.quizzes.graders.PentagonCrazyQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.PentagonQuizAdapter;

@UseReporter({DelayedClipboardReporter.class, DiffReporter.class})
public class PentagonCrazyQuizTest
{
  public static class PentagonCrazyCorrectQuiz extends PentagonQuizAdapter
  {
    //      Create a method called thread
    public void question1()
    {
      thread();
    }
    public void thread()
    {
      //       that moves the tortoise 6 pixels
      Tortoise.move(6);
    }
    @Override
    public void question2()
    {
      //        Do the following 76 times
      for (int i = 0; i < 76; i++)
      {
        //        Quiz.Stitch()
        sewAStitch();
      }
    }
    @Override
    public void question3()
    {
      //        Add lime to the color wheel
      ColorWheel.addColor(PenColors.Greens.Lime);
    }
    @Override
    public void question4()
    {
      //        Add red to the color wheel
      ColorWheel.addColor(PenColors.Reds.Red);
    }
  }
  @Test
  public void testCorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    PentagonCrazyQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new PentagonCrazyQuizGrader().grade(new PentagonCrazyCorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
  public static class PentagonCrazyIncorrectQuiz extends PentagonQuizAdapter
  {
    public void question1()
    {
      thread();
    }
    public void thread()
    {
      Tortoise.move(2);
    }
    @Override
    public void question2()
    {
      for (int i = 0; i < 50; i++)
      {
        sewAStitch();
      }
    }
    @Override
    public void question3()
    {
      ColorWheel.addColor(PenColors.Greens.LimeGreen);
    }
    @Override
    public void question4()
    {
      ColorWheel.addColor(PenColors.Reds.Tomato);
    }
  }
  @Test
  public void testIncorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    PentagonCrazyQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new PentagonCrazyQuizGrader().grade(new PentagonCrazyIncorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
}
