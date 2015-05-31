package org.teachingkidsprogramming.recipes.completed.section07events;

import java.util.ArrayList;

import org.teachingextensions.logo.MultiTurtleWindow;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.shapes.Text;

public class MyTurtles
{
  //Uncomment the two lines of code below to create a container and a window for your turtles --#1
  public ArrayList<Turtle> turtles = new ArrayList<Turtle>();
  public MultiTurtleWindow mtw     = new MultiTurtleWindow();
  //
  public MyTurtles()
  {
    showSomeTurtles();
  }
  //
  private void showSomeTurtles()
  {
    //Use a FOR loop to add your three turtles --#4.1
    for (int i = 0; i < 3; i++)
    {
      //Create a turtle instance  --#2.1
      Turtle myTurtle = new Turtle();
      //Add your turtles to your turtle container --#2.2
      turtles.add(myTurtle);
      //Repeat --#4.2
    }
    //Create a variable to count the number of turtles in the container --#3.1
    int numberOfTurtles = turtles.size();
    //Uncomment to Show the number of turtles in the container on the window --#3.2
    new Text("There are " + numberOfTurtles + " turtles in the turtle container").setTopLeft(50, 50)
        .setPenColor(PenColors.Yellows.Gold).addTo(mtw);
    //
    //Use a FOREACH loop to add your turtles to your window --#5.1
    for (Turtle turtle : turtles)
    {
      //Add and Show your turtles on your window --#5.3
      mtw.addAndShowTurtle(turtle);
      //Repeat --#5.2
    }
    //Use a FOR loop to teleport all of your turtles around your window  --#6.1
    for (int i = 0; i < 3; i++)
    {
      //Get your turtle's current position and then set the X position to i*100 + 350 --#6.3
      turtles.get(i).setX(i * 100 + 350);
      //Get your turtle's current position and then set the Y position to i*100 + 100 --#6.4
      turtles.get(i).setY(i * 100 + 100);
      //Repeat --#6.2
    }
    //Use a FOREACH loop to set values for all of your turtles --#7.1
    for (Turtle turtle : turtles)
    {
      //Set the pen width to 10 pixels -- #7.3
      turtle.setPenWidth(10);
      //Set the turtle speed to 9 --#7.4
      turtle.setSpeed(9);
      //Have each turtle draw a star with a side that is 100 pixels --#7.5
      turtle.drawStar(100);
      //Repeat --#7.2
    }
  }
  //
  public static void main(String[] args)
  {
    new MyTurtles();
  }
}
