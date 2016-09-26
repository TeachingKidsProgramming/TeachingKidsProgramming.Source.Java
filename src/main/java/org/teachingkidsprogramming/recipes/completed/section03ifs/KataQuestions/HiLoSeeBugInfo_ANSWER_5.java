package org.teachingkidsprogramming.recipes.completed.section03ifs.KataQuestions;

import java.awt.Toolkit;

import org.teachingextensions.logo.utils.EventUtils.MessageBox;

//------------Kata Question---------------//
//  What happens when you enter letters (i.e. 'abc') as your guess?
//      How can you see what your guess is exactly? 
//
public class HiLoSeeBugInfo_ANSWER_5
{
  public static void main(String[] args)
  {
    // int answer = NumberUtils.getRandomInt(1, 100);
    int answer = 12;
    for (int i = 0; i < 8; i++)
    {
      int guess = MessageBox.askForNumericalInput("Can you guess the random number between 1 and 100?");
      MessageBox.showMessage("My guess is : " + guess);
      if (guess == 0)
      {
        MessageBox.showMessage("No Zero allowed, you lose!");
        System.exit(0);
      }
      if (guess > 100)
      {
        MessageBox.showMessage("Number too big, you lose!");
        System.exit(0);
      }
      if (guess == answer)
      {
        Toolkit.getDefaultToolkit().beep();
        MessageBox.showMessage("You won!");
        System.exit(0);
      }
      else if (guess < 1)
      {
        MessageBox.showMessage("Please guess a positive number only!");
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
