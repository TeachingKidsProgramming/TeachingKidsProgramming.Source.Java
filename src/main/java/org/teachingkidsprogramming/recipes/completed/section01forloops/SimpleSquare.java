package org.teachingkidsprogramming.recipes.completed.section01forloops;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.virtualproctor.VirtualProctor;

public class SimpleSquare
{
  public static void main(String[] args) throws Exception
  {
    //  Show the tortoise --#1
    Tortoise.show();
    //  Make the tortoise move as fast as possible --#6
    Tortoise.setSpeed(10);
    //  Do the following 4 times --#5.1
    for (int i = 0; i < 4; i++)
    {
      //      Change the pen color of the line the tortoise draws to blue --#4
      Tortoise.setPenColor(PenColors.Blues.Blue);
      //      Move the tortoise 50 pixels --#2
      Tortoise.move(50);
      //      Turn the tortoise to the right (90 degrees) --#3
      Tortoise.turn(90);
    }
    //  End Repeat --#5.2
    //
    //  (Optional): Sign your work using the Virtual Proctor 
    //  See your work at http://virtualproctor.tkpjava.org
    VirtualProctor.setClassName("TKP House");
    VirtualProctor.setName("Lynn Langit");
  }
}
