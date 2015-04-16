package org.teachingkidsprogramming.recipes.completed.section05recursion;

import org.teachingextensions.logo.Tortoise;

public class RecursiveSquare
{
  public static void main(String[] args) throws Exception
  {
    //Set the speed to the fastest
    Tortoise.setSpeed(10);
    //Set the length to 100.0
    double length = 100.0;
    //Run the recipe makeASquare with the current length
    makeASquare(length);
  }
  //
  //Create the makeASquare recipe 
  private static void makeASquare(double length)
  {
    //If the current length is greater than 10
    if (length > 10)
    {
      //  Run the recipe moveToTheSquareStart with the current length
      moveToTheSquareStart(length);
      //
      //  Do the following 4 times
      for (int i = 1; i <= 4; i++)
      {
        //    Move the Tortoise the current length  
        Tortoise.move(length);
        //    Run the recipe makeASquare with the current length divided by two  
        makeASquare(length / 2);
        //      If the current process count is less than 4
        if (i < 4)
        {
          //      Turn the tortoise 90 degrees to the right
          Tortoise.turn(90);
          //
        }
      }
      //  Run the recipe moveBackToCenter with the current length
      moveBackToCenter(length);
      //  Set the current length to the current length times two
      length = length * 2;
    }
    //End of makeASquare recipe
  }
  //  Create the moveToTheSquareStart recipe 
  private static void moveToTheSquareStart(double length)
  {
    //    Set the pen up for the tortoise
    Tortoise.penUp();
    //    Move the tortoise the current length divided by two
    Tortoise.move(length / 2);
    //    Turn the tortoise 90 degrees to the left
    Tortoise.turn(-90);
    //    Move the tortoise the current length divided by two
    Tortoise.move(length / 2);
    //    Turn the tortoise 180 degrees to the right
    Tortoise.turn(180);
    //    Set the pen down for the tortoise
    Tortoise.penDown();
    //  End of moveToTheSquareStart recipe 
  }
  //
  //  Create the moveBackToCenter recipe 
  private static void moveBackToCenter(double length)
  {
    //    Set the pen up for the tortoise
    Tortoise.penUp();
    //    Turn the tortoise 90 degrees to the right
    Tortoise.turn(90);
    //    Move the tortoise the current length divided by two
    Tortoise.move(length / 2);
    //    Turn the tortoise 90 degrees to the right
    Tortoise.turn(90);
    //    Move the tortoise the current length divided by two
    Tortoise.move(length / 2);
    //    Turn the tortoise 180 degrees to the right
    Tortoise.turn(180);
    //    Set the pen down for the tortoise
    Tortoise.penDown();
    //
  }
  //  End of moveToTheSquareStart recipe
}
