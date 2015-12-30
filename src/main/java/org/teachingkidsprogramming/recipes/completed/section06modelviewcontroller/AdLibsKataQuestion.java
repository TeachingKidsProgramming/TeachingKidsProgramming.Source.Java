package org.teachingkidsprogramming.recipes.completed.section06modelviewcontroller;

import org.teachingextensions.logo.utils.EventUtils.MessageBox;

//
//------------Kata Question---------------//
//  How would you make sure that a number was NOT entered in the story?
//  Write out the steps in English 
//  Then translate the steps into code
//  Make sure to run after each line
//
public class AdLibsKataQuestion
{
  public static void main(String[] args)
  {
    String currentAdverb = MessageBox.askForTextInput("What is the adverb?");
    String currentEdVerb = MessageBox.askForTextInput("What is the -ed verb?");
    String currentBodyPart = MessageBox.askForTextInput("What is the body part?");
    String currentStory = "Today ";
    currentStory = currentStory + "I woke " + currentAdverb + ". ";
    currentStory = currentStory + "Then I " + currentEdVerb + " ";
    currentStory = currentStory + "my " + currentBodyPart + ". ";
    MessageBox.showMessage(currentStory);
  }
}