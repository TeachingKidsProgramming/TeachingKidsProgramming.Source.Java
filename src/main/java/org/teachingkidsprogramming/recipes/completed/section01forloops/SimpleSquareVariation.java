package org.teachingkidsprogramming.recipes.completed.section01forloops;

import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.windows.MessageBox;

public class SimpleSquareVariation {
  public static void main(String[] args) throws Exception {
    Tortoise.show();
    Tortoise.setSpeed(10);
    //use a number between 25-35
    int sides = MessageBox.askForNumericalInput("How many sides?");
    for (int i = 0; i <= sides; i++) {
      Tortoise.setPenColor(PenColors.getRandomColor());
      Tortoise.setPenWidth(i*2.5);
      Tortoise.move(i*1.5);
      Tortoise.turn(360/sides);
    }
  }
}
