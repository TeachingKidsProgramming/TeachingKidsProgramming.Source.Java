package org.teachingkidsprogramming.recipes.quizzes.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingextensions.logo.utils.MVCUtils.Parser;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.TreeQuizGrader;

@UseReporter({DelayedClipboardReporter.class, DiffReporter.class})
public class SimpleBubbleQuizTest
{
  public static class AdLibsCorrectQuiz extends AdLibsQuizAdapter
  {
    @Override
    public void question1(String letter1, String letter3)
    {
      //set current value of word1 to be letter1 + 'o' + letter3
      word1 = letter1 + "o" + letter3;
    }
    @Override
    public void question2(String letter1)
    {
      //add the letter1 to the end of word2 
      word2 += letter1;
    }
    @Override
    public void question3(String templateText, Object model)
    {
      //use the parser to combine the template and the model as word3
      word3 = Parser.parse(templateText, model);
    }
    @Override
    public void question4(Pieces pieces)
    {
      //set template4 to the template which does'g' + pieces.middle + 'e'
      template4 = "g{middle}e";
    }
  }
  @Test
  public void testCorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new AdLibsQuizGrader().grade(new AdLibsCorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
  public static class AdLibsIncorrectQuiz extends AdLibsQuizAdapter
  {
    @Override
    public void question1(String letter1, String letter3)
    {
    }
    @Override
    public void question2(String letter1)
    {
    }
    @Override
    public void question3(String templateText, Object model)
    {
    }
    @Override
    public void question4(Pieces pieces)
    {
    }
  }
  @Test
  public void testIncorrect() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
    new AdLibsQuizGrader().grade(new AdLibsIncorrectQuiz());
    TortoiseUtils.verifyForOs();
  }
}
