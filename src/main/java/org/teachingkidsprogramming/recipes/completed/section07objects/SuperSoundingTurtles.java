package org.teachingkidsprogramming.recipes.completed.section07objects;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.logo.Sound;
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
    Sound s = new Sound();
    s.setSound(Sound.TKPSound.LLCoolJYaKnow);
    speedyTurtle.setSound(s);
    mtw.addAndShowTurtle(speedyTurtle);
    speedyTurtle.setSpeed(10);
    speedyTurtle.drawTriangle(100);
    speedyTurtle.speak();
  }
  private void makeSlowTurtle()
  {
    Turtle slowTurtle = new Turtle();
    slowTurtle.setSound(new Sound(Sound.TKPSound.Ahem));
    mtw.addAndShowTurtle(slowTurtle);
    slowTurtle.drawTriangle(-50);
    slowTurtle.speak();
  }
  private void makeCrazyTurtle()
  {
    Turtle crazyTurtle = new Turtle();
    crazyTurtle.setSound(new Sound(Sound.TKPSound.Yahoo));
    mtw.addTurtle(crazyTurtle);
    crazyTurtle.drawLightning(55);
    crazyTurtle.speak();
  }
}
