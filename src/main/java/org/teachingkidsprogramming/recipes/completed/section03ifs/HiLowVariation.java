package org.teachingkidsprogramming.recipes.completed.section03ifs;

import org.teachingextensions.approvals.lite.util.NumberUtils;
import org.teachingextensions.windows.MessageBox;
import java.awt.*;

public class HiLowVariation
{
  public static void main(String[] args)
  {
    int answer = NumberUtils.getRandomInt(1, 100);
    //TIP: for testing you may want to use a static answer
    //int answer = 12;
    for (int i = 1; i <= 8; i++)
    {
      int guess = MessageBox.askForNumericalInput("Can you guess the random number between 1 and 100?");
      if (guess < 1)
      {
        MessageBox.showMessage("Please guess a positive number!");
        System.exit(0);
      }
      if (guess > 100)
      {
        MessageBox.showMessage("Please guess a number less than 100!");
        System.exit(0);
      }
      if (guess == answer)
      {
        Toolkit.getDefaultToolkit().beep();
        MessageBox.showMessage("You won!");
        System.exit(0);
      }
      else if (guess > answer)
      {
        MessageBox.showMessage("Try a lower number.");
      }
      else if (guess < answer)
      {
        MessageBox.showMessage("Try a higher number.");
      }
    }
    MessageBox.showMessage("You lost!");
  }
}
