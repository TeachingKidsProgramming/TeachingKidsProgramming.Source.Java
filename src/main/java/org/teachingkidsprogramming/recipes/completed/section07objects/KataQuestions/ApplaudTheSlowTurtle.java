package org.teachingkidsprogramming.recipes.completed.section07objects.KataQuestions;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.logo.Turtle;

//
//------------Kata Question---------------//
//  How would you add an applause sound AFTER the slow turtle draws a triangle?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class ApplaudTheSlowTurtle
{
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  public ApplaudTheSlowTurtle()
  {
    showSomeTurtles();
  }
  public static void main(String[] args)
  {
    new ApplaudTheSlowTurtle();
  }
  private void showSomeTurtles()
  {
    makeSlowTurtle();
    makeSpeedyTurtle();
    makeCrazyTurtle();
  }
  private void makeSlowTurtle()
  {
    Turtle slowTurtle = new Turtle();
    mtw.addAndShowTurtle(slowTurtle);
    slowTurtle.drawTriangle(-50);
  }
  private void makeSpeedyTurtle()
  {
    Turtle speedyTurtle = new Turtle();
    mtw.addAndShowTurtle(speedyTurtle);
    speedyTurtle.setSpeed(10);
    speedyTurtle.drawTriangle(100);
  }
  private void makeCrazyTurtle()
  {
    Turtle crazyTurtle = new Turtle();
    mtw.addTurtle(crazyTurtle);
    crazyTurtle.drawLightning(55);
  }
}