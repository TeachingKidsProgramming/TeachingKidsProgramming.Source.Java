package org.teachingkidsprogramming.recipes.completed.section07objects.KataQuestions;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.logo.Sound;
import org.teachingextensions.logo.Turtle;

//
//------------Kata Question---------------//
//  How would you add an applause sound after the slow turtle draws a triangle?
//  NOTE for teacher - add to the makeSlowTurtle method due to object instantiation order
//
public class ApplaudTheSlowTurtle_ANSWER
{
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  public ApplaudTheSlowTurtle_ANSWER()
  {
    showSomeTurtles();
  }
  public static void main(String[] args)
  {
    new ApplaudTheSlowTurtle_ANSWER();
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
    Sound s = new Sound();
    s.setSound(Sound.TKPSound.Applause);
    s.playSound();
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