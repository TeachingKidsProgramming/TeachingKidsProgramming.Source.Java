package org.teachingkidsprogramming.section06modelviewcontroller;

import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizGrader;

public class AdLibsQuiz extends AdLibsQuizAdapter
{
  public void question1(String letter1, String letter3)
  {
    //set currentWord1 to be letter1 + 'o' + letter3
  }
  public void question2(String letter1)
  {
    //add the letter1 to the currentWord2 
  }
  //--in development
  //string concatenation
  //parser
  //setting variables or fields
  //create new fields in an existing object
  //string builder
  public void question3()
  {
    //        Ask the user to add tomorrow's weather, save it as tomorrowsWeather
    //        Add tomorrowsWeather to the Weather Report
  }
  public void question4()
  {
    //        Show the currentWeather in a message box as a message
  }
  public static void main(String[] args)
  {
    new AdLibsQuizGrader().grade(new AdLibsQuiz());
  }
}
