package org.teachingkidsprogramming.recipes.completed.section04mastery;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class BackgroundPhoto
{
  public static void main(String[] args)
  {
    Tortoise.show();
    //  Make the tortoise go as fast as possible --#3
    Tortoise.setSpeed(10);
    //  Set the current picture to this url "http://img2.timeinc.net/ew/dynamic/imgs/101110/sonny-cher_240.jpg" --#7.1
    String picture = "http://img2.timeinc.net/ew/dynamic/imgs/101110/sonny-cher_240.jpg";
    //  Set the background image to the current picture--#7.2
    Tortoise.getBackgroundWindow().setBackgroundImage(picture);
    //  Set the current side to 2 pixels long --#4.1
    int side = 2;
    //  Do the following 75 times --#2.1
    for (int i = 0; i < 75; i++)
    {
      //     Set the current pen color to crimson --#8.1
      Color penColor = PenColors.Reds.Crimson;
      //     Use the current pen color for the line the tortoise draws --#8.2
      Tortoise.setPenColor(penColor);
      //     Increase the length of a side by 1 pixel --#5
      side = side + 1;
      //     Move the tortoise the length of the current side --#4.2
      Tortoise.move(side);
      //     Set the X position of the tortoise to 555 pixels --#4.3
      Tortoise.setX(555);
      //     Set the Y position of the tortoise to 65 pixels --#4.4
      Tortoise.setY(65);
      //     Turn the tortoise 1/3rd of 360 degrees to the right --#1
      Tortoise.turn(360 / 4);
      //     Turn the tortoise 1 more degree --#6
      Tortoise.turn(1);
      //  Repeat --#2.2
    }
  }
}
