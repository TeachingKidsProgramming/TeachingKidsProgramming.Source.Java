package org.teachingkidsprogramming.recipes.completed.section07objects;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.logo.Turtle;

public class TurtleObjects
{
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  public TurtleObjects()
  {
    showSomeTurtles();
  }
  public static void main(String[] args)
  {
    new TurtleObjects();
  }
  private void showSomeTurtles()
  {
    //  Call the makeSpeedyTurtle method --#2
    makeSpeedyTurtle();
    //  Call the makeSlowTurtle method --#4
    makeSlowTurtle();
    //  Call the makeCrazyTurtle method --#6
    makeCrazyTurtle();
  }
  //
  //    NOTE: Teacher to point out the mtw.addAndShowTurtle method
  //    NOTE: Teacher to ask 'what are the steps of the drawTriangle method'?
  //    Create the makeSpeedyTurtle method --#1.0
  private void makeSpeedyTurtle()
  {
    //        Create a new speedyTurtle instance  
    Turtle speedyTurtle = new Turtle();
    //        Set the speed of your speedyTurtle to the fastest possible    
    speedyTurtle.setSpeed(10);
    //        Add your speedyTurtle to your MultiTurtleWindow
    mtw.addAndShowTurtle(speedyTurtle);
    //        Have your speedyTurtle draw a triangle with 100 pixel sides
    speedyTurtle.drawTriangle(100);
    //    End of makeSpeedyTurtle method --#1.1 
  }
  //
  //    NOTE: Teacher to ask why this turtle is slower than the first one
  //    NOTE: Teacher to ask why the two turtles start at the same spot
  //    Create the makeSlowTurtle method --#3.0
  private void makeSlowTurtle()
  {
    //        Create a new slowTurtle instance 
    Turtle slowTurtle = new Turtle();
    //        Add your slowTurtle to your MultiTurtleWindow
    mtw.addAndShowTurtle(slowTurtle);
    //        Have your slowTurtle draw a upside down triangle with 50 pixel sides
    slowTurtle.drawTriangle(-50);
    //    End of makeSlowTurtle method --#3.1
  }
  //
  //    NOTE: Teacher to ask why is this turtle faster than the second one
  //    NOTE: Teacher to ask why does this turtle 'start' in a different location
  //    NOTE: Teacher to ask why does this turtle show up AFTER the other two HINT: mtw.addTurtle method
  //    NOTE: Teacher to ask what does the drawLightning method do?
  //    Create the makeCrazyTurtle method --#5.0
  private void makeCrazyTurtle()
  {
    //        Create a new crazyTurtle instance  
    Turtle crazyTurtle = new Turtle();
    //        Add your crazyTurtle to your MultiTurtleWindow
    mtw.addTurtle(crazyTurtle);
    //        Have your crazyTurtle draw a 55 pixel long lightning bolt
    crazyTurtle.drawLightning(55);
    //    End of makeCrazyTurtle method --#5.1
  }
}