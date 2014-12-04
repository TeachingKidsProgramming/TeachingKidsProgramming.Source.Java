package org.teachingkidsprogramming.section06modelviewcontroller;

public class AdLibsQuiz extends AdLibsQuizAdapter
{
  public void question1(String letter1, String letter3)
  {
    //set currentWord1 to be letter1 + 'o' + letter3
  }
  //--in development
  //string concatenation
  //parser
  //setting variables or fields
  //create new fields in an existing object
  //string builder
  public void question1()
  {
    //   createWeatherReport (recipe below) 
    //   ------------- Recipe for createWeatherReport
    //       Ask the user to enter a Weather Report, save it as currentWeather
    //   ------------- End of createWeatherReport recipe
  }
  public void question2()
  {
    //        Ask the user to enter a city, save it as currentCity
    //        Add the currentCity to the Weather Report
  }
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
