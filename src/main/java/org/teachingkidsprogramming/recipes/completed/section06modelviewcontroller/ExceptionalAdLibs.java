package org.teachingkidsprogramming.recipes.completed.section06modelviewcontroller;

import org.teachingextensions.logo.utils.EventUtils.MessageBox;

//***********this recipe is in development - watch for updates!**************
public class ExceptionalAdLibs
{
  public static void main(String[] args)
  {
    //Ask the user to enter an adverb, save it as currentAdverb --#2
    String adverb = MessageBox.askForTextInput("What is the adverb?");
    if (adverb.isEmpty())
    {
      MessageBox.showMessage("L Y don't you want to play? To start you need one adverb.");
      return;
    }
    else if (adverb.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers are NOT adverbs, try again");
      return;
    }
    String currentAdverb = adverb;
    //Ask the user to enter a verb ending in '-ed', save it as currentEdVerb --#4
    String edverb = MessageBox.askForTextInput("What is the -ed verb?");
    if (edverb.isEmpty())
    {
      MessageBox.showMessage("Don't like verbs? You need one now.");
      return;
    }
    else if (edverb.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers are != verbs, try again");
      return;
    }
    String currentEdVerb = edverb;
    //Ask the user to enter a body part, save it as currentBodyPart --#6
    String bodyPart = MessageBox.askForTextInput("What is the body part?");
    if (bodyPart.isEmpty())
    {
      MessageBox.showMessage("No body, no story, pay attention and start over");
      return;
    }
    else if (bodyPart.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers <> body parts, try again");
      return;
    }
    String currentBodyPart = bodyPart;
    //Set the value of the currentStory to the word "Today " --#1.2
    String currentStory = "Today ";
    //Add the words "I woke " + currentAdverb + ". " to the currentStory --#3
    currentStory = currentStory + "I woke " + currentAdverb + ". ";
    //Add the words '"Then I " + currentEdVerb + " " to the currentStory --#5
    currentStory = currentStory + "Then I " + currentEdVerb + " ";
    //Add the words "my " + currentBodyPart + ". " to the current story --#7
    currentStory = currentStory + "my " + currentBodyPart + ". ";
    //Show the currentStory in a message box as a message --#1.1
    MessageBox.showMessage(currentStory);
  }
}