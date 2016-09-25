package org.teachingkidsprogramming.recipes.completed.section03ifs.KataQuestions;

import java.awt.Toolkit;

import org.teachingextensions.logo.utils.EventUtils.MessageBox;

//------------Kata Question---------------//
//  How would you make sure the guess is a positive number
//      and that the guess is less than 100
//      and is a whole number only
//      and not letters?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class HiLowToPosBoundWholeAndNotLettersGuess_05
{
  public static void main(String[] args)
  {
    // double answer = NumberUtils.getRandomInt(1, 100);
    int answer = 12;
    for (int i = 0; i < 8; i++)
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
