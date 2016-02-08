package org.teachingkidsprogramming.recipes.completed.section07objects;

import org.teachingkidsprogramming.recipes.quizzes.graders.SpiderQuiz;
import org.teachingkidsprogramming.recipes.quizzes.graders.SpiderWebQuizGrader;

public class SpiderWebQuiz extends SpiderQuiz
{
  @Override
  public void question1()
  {
    //        Do the following the current number of times
    for (int i = 0; i < number; i++)
    {
      //        Call circle()
      circle();
      //        Repeat
    }
  }
  public void question2()
  {
    circleAround();
  }
  @Override
  //      Create a subroutine called circleAround which 
  public void circleAround()
  {
    //      Does the following 3 times
    for (int i = 0; i < 3; i++)
    {
      //      Call adjust()
      adjust();
      //      Call question1
      question1();
      //      Repeat
    }
  }
  public void question3()
  {
    //      Create a subroutine called grow which 
    grow();
    //      Changes the current length so it is multiplied by 2.5
  }
  @Override
  public void grow()
  {
    length = length * 2.5;
  }
  public void question4()
  {
    //      Create a subroutine called shrink which 
    shrink();
    //      Decreases the current length by 9 pixels
  }
  @Override
  public void shrink()
  {
    length = length - 9;
  }
  public void question5()
  {
    //      Create a subroutine called expand which
    expand();
    //      Increases the current number by 12
  }
  @Override
  public void expand()
  {
    number = number + 12;
  }
  public static void main(String[] args)
  {
    new SpiderWebQuizGrader().grade(new SpiderWebQuiz());
  }
}
