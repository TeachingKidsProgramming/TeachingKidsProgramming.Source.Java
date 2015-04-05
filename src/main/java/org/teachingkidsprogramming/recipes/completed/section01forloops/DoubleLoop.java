package org.teachingkidsprogramming.recipes.completed.section01forloops;

import org.teachingextensions.logo.ColorWheel;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class DoubleLoop
{
  public static void main(String[] args)
  {
    //    Show the tortoise --#1
	  Tortoise.show();
    //    Set the tortoise speed to 9 --#4
	  Tortoise.setSpeed(9);
    //    Add Crimson to the Color Wheel --#6.1
	  ColorWheel.addColor(PenColors.Reds.Crimson);
    //    Add Red to the Color Wheel --#6.2
	  ColorWheel.addColor(PenColors.Reds.Red);
    //    Add Fire Brick to the Color Wheel --#6.3
	  ColorWheel.addColor(PenColors.Reds.FireBrick);
    //    Do the following 6 times --#3.1
	  for (int i = 0; i < 6; i++) {
		
    //         Change the pen color of the line the tortoise draws the next color on the Color Wheel --#7
		  Tortoise.setPenColor(ColorWheel.getNextColor());
    //         Move the tortoise 4 times the current line number you are drawing --#5
		  Tortoise.move(i*4);
    //         Turn the tortoise 1/6 of 360 degrees to the left --#2
	  Tortoise.turn(-360/6);
	// 
	//    	    Do the following 15 times --#3.1 (HINT: Use a new 'j' not 'i'!) --#8.1
	  for (int j = 0; j < 15; j++) {
		
    //         		Set the pen width of the line the tortoise draws to 17 --#11
		  Tortoise.setPenWidth(17);
    //         		Move the tortoise 8 times the current line number you are drawing --#9
		  Tortoise.move(j*8);
    //         		Turn the tortoise 1/5 of 360 degrees to the right --#10
		  Tortoise.turn(360/5);
	  }
    //    		Repeat --#8.2 
	//  
	  //    Hide the Tortoise --#12
	  Tortoise.hide();
	  }
    //    Repeat --#3.2
  }
}
