package org.teachingkidsprogramming.recipes.completed.section01forloops;

import org.teachingextensions.logo.ColorWheel;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class DoubleLoop
{
  public static void main(String[] args)
  {
    //    Set the tortoise x position to 225 --#1.1
	  Tortoise.setX(225);
	//    Set the tortoise y position to 150 --#1.2
      Tortoise.setY(150);  
    //    UPDATE the tortoise speed to 10 --#8.2
	  Tortoise.setSpeed(10);
	//  
	  ColorWheel.addColor(PenColors.Reds.Crimson);
	  ColorWheel.addColor(PenColors.Reds.DarkRed);
	  ColorWheel.addColor(PenColors.Reds.FireBrick);
    //    Do the following 6 times --#3.1
	  for (int i = 0; i < 6; i++) {
    //         Change the pen color of the line the tortoise draws to the next color on the Color Wheel --#5
		  Tortoise.setPenColor(ColorWheel.getNextColor());
    //         Move the tortoise 4 times the current line number you are drawing --#4
		  Tortoise.move(i*4);
    //         Turn the tortoise 1/6 of 360 degrees to the left --#2
		  Tortoise.turn(-360/6);
	// 
	//    	    Do the following 15 times --#3.1 (HINT: The new line number is j) --#7.1
		    for (int j = 0; j < 15; j++) {
    //         		Set the pen width of the line the tortoise draws to 17 --#9
		      Tortoise.setPenWidth(17);
    //         		Move the tortoise 8 times the current line number you are drawing --#8.1
		      Tortoise.move(j*8);
    //         		Turn the tortoise 1/5 of 360 degrees to the right --#6
		      Tortoise.turn(360/5);
		  //    		Repeat --#7.2 
	  }
	//  
	//    Hide the Tortoise --#10
	  Tortoise.hide();
	  Tortoise.getBackgroundWindow().setBackground(PenColors.Yellows.PeachPuff);
	  }
	  //    Repeat --#3.2
    //    Set the tortoise x position to 300 --#15.1
      Tortoise.setX(300);
    //    Set the tortoise y position to 200 --#15.2
      Tortoise.setY(200); 
    //    Do the following 5 times --#12.1
  
	  for (int i = 0; i < 5; i++)
      {
    //      Change the pen color of the line the tortoise draws to black --#14 
        Tortoise.setPenColor(PenColors.Grays.Black);
	//   Move the Tortoise 25 pixels --#11
	  Tortoise.move(25);
	//    Turn the tortoise 1/5 of 360 degrees to the right --#13
	  Tortoise.turn(360/5);
    //    Repeat --#12.2
      }
}
}
