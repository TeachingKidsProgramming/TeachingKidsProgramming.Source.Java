package org.teachingkidsprogramming.recipes.completed.section07objects;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.logo.Turtle;

public class SuperSoundingTurtles
{
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  public SuperSoundingTurtles()
  {
    showSomeTurtles();
  }
  public static void main(String[] args)
  {
    new SuperSoundingTurtles();
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
    //
    //***Need to add the ability to play sounds to MultiTurtleWindow (sync)****//
    //***Add 'funny' sounds to each drawing section of this recipe*************//
    //Sound s = new Sound();
    //s.setSound(Sound.TKPSound.LLCoolJYaKnow);
    //s.playSound();
  }
  private void makeSlowTurtle()
  {
    Turtle slowTurtle = new Turtle();
    mtw.addAndShowTurtle(slowTurtle);
    slowTurtle.drawTriangle(-50);
    //Add sound
  }
  private void makeCrazyTurtle()
  {
    Turtle crazyTurtle = new Turtle();
    mtw.addTurtle(crazyTurtle);
    crazyTurtle.drawLightning(55);
    //Add Sound
  }
}