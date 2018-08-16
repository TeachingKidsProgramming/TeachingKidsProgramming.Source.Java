package org.teachingkidsprogramming.recipes.completed.section04mastery;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class BackgroundPhoto
{
  public static void main(String[] args)
  {
    //  Set the current picture to this url "https://usatftw.files.wordpress.com/2017/05/spongebob.jpg?w=1000&h=600&crop=1" --#1.0
    String picture = "https://usatftw.files.wordpress.com/2017/05/spongebob.jpg?w=1000&h=600&crop=1";
    //  Set the background image to the current picture--#1.1
    Tortoise.getBackgroundWindow().setBackgroundImage(picture);
    Tortoise.show();
    Tortoise.setSpeed(10);
    int side = 2;
    //  Do the following 75 times --#7.1
    for (int i = 0; i < 75; i++)
    {
      //     Set the current pen color to yellow --#6.1
      Color penColor = PenColors.Yellows.Yellow;
      //     Use the current pen color for the line the tortoise draws --#6.2
      Tortoise.setPenColor(penColor);
      //     Increase the length of a side by 1 pixel --#3.0
      side = side + 1;
      //     Move the tortoise the length of the current side --#3.1
      Tortoise.move(side);
      //     Set the X position of the tortoise to 555 pixels --#2.0
      Tortoise.setX(555);
      //     Set the Y position of the tortoise to 65 pixels --#2.1
      Tortoise.setY(65);
      //     Turn the tortoise 1/3rd of 360 degrees to the right --#4
      Tortoise.turn(360 / 3);
      //     Turn the tortoise 1 more degree --#5
      Tortoise.turn(1);
      //  End Repeat --#7.2
    }
  }
}
