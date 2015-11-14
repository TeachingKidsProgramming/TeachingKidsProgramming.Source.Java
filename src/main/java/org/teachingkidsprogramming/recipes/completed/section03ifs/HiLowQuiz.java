package org.teachingkidsprogramming.recipes.completed.section03ifs;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.EventUtils.MessageBox;
import org.teachingkidsprogramming.recipes.quizzes.graders.HiLowQuizGrader;

public class HiLowQuiz extends org.teachingkidsprogramming.recipes.quizzes.graders.HiLowQuiz
{
  @Override
  public void question1()
  {
    //        if the Y position of the tortoise is 115
    if (Tortoise.getY() == 115)
    {
      //         turn the tortoise to the right 63 degrees 
      Tortoise.turn(63);
    }
  }
  @Override
  public void question2()
  {
    //        if the X position of tortoise is less than Y position of tortoise
    if (Tortoise.getX() < Tortoise.getY())
    {
      //         turn the tortoise 54 degrees to the left
      Tortoise.turn(-54);
    }
    else
    {
      //        otherwise turn the tortoise 22 degrees to the right
      Tortoise.turn(22);
    }
  }
  @Override
  public void question3()
  {
    //        display the message "elcomeway omehay!"
    MessageBox.showMessage("elcomeway omehay!");
  }
  @Override
  public void question4()
  {
    //    if the Y position of tortoise is greater than 50
    if (Tortoise.getY() > 50)
    {
      //         turn the tortoise 177 degrees to the left
      Tortoise.turn(-177);
    }
  }
  public static void main(String[] args)
  {
    new HiLowQuizGrader().grade(new HiLowQuiz());
  }
}
