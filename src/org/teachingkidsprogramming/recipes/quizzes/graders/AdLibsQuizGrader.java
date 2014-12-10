package org.teachingkidsprogramming.recipes.quizzes.graders;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.Tortoise;

public class AdLibsQuizGrader implements Paintable
{
  private boolean[]         answers;
  public static int         TURTLE_SPEED = 9;
  private AdLibsQuizAdapter quiz;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
  }
  public void grade(AdLibsQuizAdapter quiz)
  {
    this.quiz = quiz;
    answers = new boolean[]{grade1You(), grade2Won()};
    displayScreen();
  }
  public void paint(Graphics2D g, JPanel caller)
  {
    QuizUtils.displayScores(g, 300, answers);
    Tortoise.hide();
    drawRewardShape(g);
  }
  public void drawRewardShape(Graphics2D g)
  {
    drawYou(g);
    drawWin(g);
  }
  private void drawWin(Graphics2D g)
  {
    quiz.currentWord2 = "WO";
    quiz.question2("n");
    char[] word = quiz.currentWord2.toUpperCase().toCharArray();
    for (int i = 0; i < word.length; i++)
    {
      char c = word[i];
      drawLetter(getPosition(1), getPosition(i), c, g);
    }
  }
  private int getPosition(int i)
  {
    return 100 + i * 53;
  }
  private void drawYou(Graphics2D g)
  {
    quiz.currentWord1 = "NOT";
    quiz.question1("y", "u");
    char[] word = quiz.currentWord1.toUpperCase().toCharArray();
    for (int i = 0; i < word.length; i++)
    {
      char c = word[i];
      drawLetter(getPosition(i), getPosition(1), c, g);
    }
  }
  private void drawLetter(int x, int y, char c, Graphics2D g)
  {
    g.setColor(Colors.Browns.BurlyWood);
    g.drawRect(x, y, 50, 50);
    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
    int charWidth = g.getFontMetrics().charWidth(c);
    int charHeight = g.getFontMetrics().getAscent();
    int textY = y + (40 - charHeight) / 2 + charHeight;
    int textX = x + (50 - charWidth) / 2;
    g.drawString("" + c, textX, textY);
  }
  private boolean grade1You()
  {
    quiz.currentWord1 = "fake";
    quiz.question1("f", "o");
    return "foo".equals(quiz.currentWord1);
  }
  private boolean grade2Won()
  {
    quiz.currentWord2 = "passe";
    quiz.question2("d");
    return "passed".equals(quiz.currentWord2);
  }
}
