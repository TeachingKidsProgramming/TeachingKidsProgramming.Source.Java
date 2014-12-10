package org.teachingkidsprogramming.recipes.quizzes.tests;

import junit.framework.TestCase;

import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.FileLauncherReporter;
import org.approvaltests.reporters.UseReporter;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.TreeQuizGrader;

@UseReporter({DelayedClipboardReporter.class, FileLauncherReporter.class})
public class AdLibsQuizTest extends TestCase
{
  public static class AdLibsCorrectQuiz extends AdLibsQuizAdapter
  {
    public void question1(String letter1, String letter3)
    {
      //set currentWord1 to be letter1 + 'o' + letter3
      currentWord1 = letter1 + "o" + letter3;
    }
    public void question2(String letter1)
    {
      //add the letter1 to the currentWord2 
      currentWord2 += letter1;
    }
  }
  public void testCorrect() throws Exception
  {
    TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new AdLibsQuizGrader().grade(new AdLibsCorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
  public static class AdLibsIncorrectQuiz extends AdLibsQuizAdapter
  {
    public void question1(String letter1, String letter3)
    {
    }
  }
  public void testIncorrect() throws Exception
  {
    TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new AdLibsQuizGrader().grade(new AdLibsIncorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
}
