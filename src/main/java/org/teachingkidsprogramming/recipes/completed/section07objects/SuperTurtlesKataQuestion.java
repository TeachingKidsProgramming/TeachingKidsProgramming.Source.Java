package org.teachingkidsprogramming.recipes.completed.section07objects;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.logo.Turtle;

//
//------------Kata Question---------------//
//  How would you add a sound when the crazy turtle draws lightning?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class SuperTurtlesKataQuestion
{
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  public SuperTurtlesKataQuestion()
  {
    showSomeTurtles();
  }
  public static void main(String[] args)
  {
    new SuperTurtlesKataQuestion();
  }
  private void showSomeTurtles()
  {
    makeSpeedyTurtle();
    makeSlowTurtle();
    makeCrazyTurtle();
  }
  private void makeSpeedyTurtle()
  {
    Turtle speedyTurtle = new Turtle();
    mtw.addAndShowTurtle(speedyTurtle);
    speedyTurtle.setSpeed(10);
    speedyTurtle.drawTriangle(100);
  }
  private void makeSlowTurtle()
  {
    Turtle slowTurtle = new Turtle();
    mtw.addAndShowTurtle(slowTurtle);
    slowTurtle.drawTriangle(-50);
  }
  private void makeCrazyTurtle()
  {
    Turtle crazyTurtle = new Turtle();
    mtw.addTurtle(crazyTurtle);
    crazyTurtle.drawLightning(55);
  }
}