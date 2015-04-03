package org.teachingkidsprogramming.recipes.completed.section04mastery;

import org.teachingextensions.logo.ColorWheel;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;
import org.teachingkidsprogramming.recipes.quizzes.graders.PentagonCrazyQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.PentagonQuizAdapter;

public class PentagonCrazyQuiz extends PentagonQuizAdapter
{
  public void question1()
  {
    // Question 1 
    thread();
  }
  private void thread()
  {
    //   thread (recipe below) 
    //   ------------- Recipe for thread
    //       that moves the tortoise 6 pixels
    Tortoise.move(6);
    //   ------------- End of thread recipe
  }
  public void question2()
  {
    //        Do the following 76 times
    for (int i = 1; i <= 76; i++)
    {
      //           call stitch
      stitch();
    }//        Repeat
  }
  public void question3()
  {
    //        Add lime to the color wheel
    ColorWheel.addColor(PenColors.Greens.Lime);
  }
  public void question4()
  {
    //        Add red to the color wheel
    ColorWheel.addColor(PenColors.Reds.Red);
  }
  public static void main(String[] args)
  {
    new PentagonCrazyQuizGrader().grade(new PentagonCrazyQuiz());
  }
}
