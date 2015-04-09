package org.teachingkidsprogramming.recipes.quizzes.tests;

import junit.framework.TestCase;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingkidsprogramming.recipes.quizzes.graders.SpiderQuiz;
import org.teachingkidsprogramming.recipes.quizzes.graders.SpiderWebQuizGrader;

@UseReporter({DelayedClipboardReporter.class, DiffReporter.class})
public class SpiderWebQuizTest
{
  public static class SpiderWebCorrectQuiz extends SpiderQuiz
  {
    @Override
    public void question1()
    {
      //    Do the following the current number of times
      for (int i = 0; i < number; i++)
      {
        //        Call circle()
        circle();
      }
    }
    //       Create a method called circleAround which 
    public void circleAround()
    {
      //      Does the following 3 times
      for (int i = 0; i < 3; i++)
      {
        //      Call adjust()
        adjust();
        //       Call question1
        question1();
      }
    }
    //      Create a method called grow which 
    public void grow()
    {
      //       Changes the current length so it is multiplied by 2.5
      length *= 2.5;
    }
    //      Create a method called shrink which 
    public void shrink()
    {
      //       Decreases the current length by 9 pixels
      length -= 9;
    }
    //      Create a method called expand which
    public void expand()
    {
      //      Increases the current number by 12
      number += 12;
    }
  }
  
  @Test
  public void testCorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();    
    SpiderWebQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new SpiderWebQuizGrader().grade(new SpiderWebCorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
  public static class SpiderWebIncorrectQuiz extends SpiderQuiz
  {
    public void question1()
    {
      for (int i = 0; i <= 3; i++)
      {
        circle();
      }
    }
    public void circleAround()
    {
      for (int i = 0; i < 1; i++)
      {
        adjust();
        question1();
      }
    }
    public void grow()
    {
      length *= 3.4;
    }
    public void shrink()
    {
      length -= 6;
    }
    public void expand()
    {
      number += 8;
    }
  }
  
  @Test
  public void testIncorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    SpiderWebQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new SpiderWebQuizGrader().grade(new SpiderWebIncorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
  
  @Test
  public void testCircle() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    Tortoise.setSpeed(Turtle.TEST_SPEED);
    SpiderWebQuizGrader grader = new SpiderWebQuizGrader();
    SpiderWebCorrectQuiz quiz = new SpiderWebCorrectQuiz();
    quiz.grader = grader;
    grader.initialize(quiz);
    quiz.question1();
    TortoiseUtils.verifyForOs();
  }
}
