package org.teachingkidsprogramming.recipes.completed.section02methods;

import org.teachingextensions.logo.Tortoise;
import org.teachingkidsprogramming.recipes.quizzes.graders.HousesQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.HousesQuizGrader;

public class HousesQuiz extends HousesQuizAdapter
{
  public void small()
  {
    //        'The current length is 7
    length = 7;
  }
  //      'Create a subroutine called Medium
  public void medium()
  {
    //      ' that sets the current length to 21
    length = 21;
  }
  //      'Create a subroutine called Large
  public void large()
  {
    //      that sets the current length to 63
    length = 63;
  }
  //      Create a subroutine called MoveTheLength
  public void moveTheLength()
  {
    //      ' that moves the Tortoise the current length
    Tortoise.move(length);
  }
  //      Create a subroutine called TurnTheCorner
  public void turnTheCorner()
  {
    //     that turns the Tortoise 1/3 of 360 degrees to the left
    Tortoise.turn(-360.0 / 3);
  }
  //      Create a subroutine called DrawASide
  public void drawASide()
  {
    //      that calls MoveTheLength and TurnTheCorner
    question4();
    question5();
  }
  public static void main(String[] args)
  {
    new HousesQuizGrader().grade(new HousesQuiz());
  }
}
