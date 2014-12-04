package org.teachingkidsprogramming.section06modelviewcontroller;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingkidsprogramming.recipes.quizzes.graders.QuizUtils;

public class AdLibsQuizGrader implements Paintable
{
  private boolean[]         answers;
  public static int         TURTLE_SPEED = 9;
  private AdLibsQuizAdapter quiz;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
    drawRewardShape();
  }
  public void grade(AdLibsQuizAdapter quiz)
  {
    this.quiz = quiz;
    answers = new boolean[]{grade1You(),};
    displayScreen();
  }
  public void paint(Graphics2D g, JPanel caller)
  {
    QuizUtils.displayScores(g, 300, answers);
  }
  public void drawRewardShape()
  {
    TortoiseUtils.setOrientation(100, 75, 90);
  }
  private boolean grade1You()
  {
    quiz.word1 = "fake";
    quiz.question1("f", "o");
    return "foo".equals(quiz.word1);
  }
}
