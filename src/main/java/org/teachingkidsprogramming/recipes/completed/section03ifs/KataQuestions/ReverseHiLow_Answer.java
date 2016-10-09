package org.teachingkidsprogramming.recipes.completed.section03ifs.KataQuestions;

import org.teachingextensions.logo.utils.EventUtils.MessageBox;

//Your user knows the answer, the computer gets 8 guesses to determine the answer
//You tell the computer whether its guess is too high or too low
//Write each of the English line comments (use at least 8 line comments)
//Number each comment line at the end
//Verify - step one - Translate EACH comment line into code
//Verify - step two - Run your code after each line
public class ReverseHiLow_Answer
{
  public static void main(String[] args)
  {
    MessageBox
        .showMessage("Hello, actual human! Think of a number between 1 and 100, and I will attempt to guess it.");
    MessageBox.showMessage("Click OK when you have one in mind.");
    int attemptNumber = 1;
    int currentGuess = 50;
    int highestPossible = 100;
    int lowestPossible = 1;
    while (attemptNumber < 8)
    {
      MessageBox.showMessage("Beginning attempt number " + attemptNumber);
      String feedback = MessageBox.askForTextInput("Is " + currentGuess
          + " the correct number? Write 'yes' if it is, if not write 'too high' or 'too low'.");
      if (feedback.equals("yes"))
      {
        MessageBox.showMessage("Got it on attempt number " + attemptNumber + "! Darn, I'm good. See ya!");
        System.exit(0);
      }
      else
      {
        if (feedback.equalsIgnoreCase("too high"))
        {
          highestPossible = currentGuess;
          currentGuess = currentGuess - ((currentGuess - lowestPossible) / 2);
        }
        else if (feedback.equalsIgnoreCase("too low"))
        {
          lowestPossible = currentGuess;
          currentGuess = currentGuess + ((highestPossible - currentGuess) / 2);
        }
        attemptNumber++;
      }
    }
    // Variable: currentGuess
    // Computer guesses currentGuess, asks if too high or too low
    // User inputs
    // If right, computer congratulates itself and ends
    // If wrong, computer takes feedback and adjusts currentGuess accordingly    
  }
}
