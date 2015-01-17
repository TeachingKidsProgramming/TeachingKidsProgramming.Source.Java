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
  //Create a container to hold your turtles HINT: Use ArrayList --#2.1
  public ArrayList<Turtle> turtles = new ArrayList<Turtle>();
  //Create a window to show your turtles HINT: Use MultiTurtlePanel --#1.1
  public MultiTurtlePanel  mt      = new MultiTurtlePanel();
  private void showSomeTurtles()
  {
    //Show your panel --#1.2
    mt.showPanel();
    //Set the size to 100 --#5.4
    int size = 100;
    //Add your three turtles HINT: FOR loop which 'does an action' --#2.2
    for (int i = 1; i <= 3; i++)
    {
      //Create your turtle --#2.4
      Turtle turtle = new Turtle();
      //Add your turtles to your turtle container --#2.5
      turtles.add(turtle);
      //Repeat --#2.2
    }
    //Add your turtles to your window HINT: Use a foreach loop --#3.1
    for (Turtle turtle : turtles)
    {
      //Must call addTurtle BEFORE calling other methods --INFO
      //Add your turtles to your window --#3.3
      mt.addTurtle(turtle);
      //Repeat --#3.2
    }
    //Teleport your turtles around your window HINT: Use a FOR loop and ZERO --#4.1
    for (int i = 0; i < 3; i++)
    {
      //Get your turtle's current position and then set the X position to i*100 + 350 --#4.3
      turtles.get(i).setX(i * 100 + 350);
      //Get your turtle's current position and then set the Y position to i*100 + 100 --#4.4
      turtles.get(i).setY(i * 100 + 100);
      //Repeat --#4.2
    }
    //Set some values for your turtles HINT: Use a foreach loop --#5.1
    for (Turtle turtle : turtles)
    {
      //Set the speed of your turtles to 7 --#5.3
      turtle.setSpeed(7);
      //Have every turtle draw a star of the current size --#5.4
      turtle.drawStar(size);
      //Repeat --#5.2
    }
  }
  public static void main(String[] args)
  {
    new ManyAnimals();
  }
}
