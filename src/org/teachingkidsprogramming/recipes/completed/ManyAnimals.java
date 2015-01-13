package org.teachingkidsprogramming.recipes.completed;

import java.util.ArrayList;

import org.teachingextensions.logo.MultiTurtlePanel;
import org.teachingextensions.logo.Turtle;

public class ManyAnimals
{
  public ManyAnimals()
  {
    showSomeTurtles();
  }
  //create container for Turtles HINT: Use ArrayList
  public ArrayList<Turtle> turtles = new ArrayList<Turtle>();
  //create a window for many turtles HINT: Use MultiTurtlePanel
  public MultiTurtlePanel  mt      = new MultiTurtlePanel();
  private void showSomeTurtles()
  {
    //show the panel
    mt.showPanel();
    //set the size to 100
    int size = 100;
    //add three turtles HINT: FOR loop which 'does an action'
    for (int i = 1; i <= 3; i++)
    {
      //create a turtle
      Turtle turtle = new Turtle();
      //add the turtles to the container for turtles
      turtles.add(turtle);
    }
    //add all turtles to the window HINT: Use a foreach loop
    for (Turtle turtle : turtles)
    {
      //NOTE: must call addTurtle BEFORE calling other methods 
      //add all turtles to the window
      mt.addTurtle(turtle);
    }
    //teleport all turtles on the window HINT: Use a FOR loop and ZERO
    for (int i = 0; i < 3; i++)
    {
      //set the X position to i*100 + 350 
      turtles.get(i).setX(i * 100 + 350);
      //set the Y position to i*100 + 100 
      turtles.get(i).setY(i * 100 + 100);
    }
    //set some values for all turtles HINT: Use a foreach loop
    for (Turtle turtle : turtles)
    {
      //set the speed of all turtle's to 7
      turtle.setSpeed(7);
      //have every turtle draw a star of the current size
      turtle.drawStar(size);
    }
  }
  public static void main(String[] args)
  {
    new ManyAnimals();
  }
}
