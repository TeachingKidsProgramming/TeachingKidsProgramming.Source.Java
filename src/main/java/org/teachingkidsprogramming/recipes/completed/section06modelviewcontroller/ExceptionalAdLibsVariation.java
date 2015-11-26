package org.teachingkidsprogramming.recipes.completed.section06modelviewcontroller;

import org.teachingextensions.logo.utils.EventUtils.MessageBox;

public class ExceptionalAdLibsVariation
{
  public static void main(String[] args)
  {
    String adverb = MessageBox.askForTextInput("What is the adverb?");
    if (adverb.isEmpty())
    {
      MessageBox.showMessage("L Y don't you want to play? To start you need one adverb.");
      adverb = askAdverbAgain();
    }
    if (adverb.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers are NOT adverbs, try again");
      adverb = askAdverbAgain();
    }
    String currentAdverb = adverb;
    String edverb = MessageBox.askForTextInput("What is the -ed verb?");
    if (edverb.isEmpty())
    {
      MessageBox.showMessage("Don't like verbs? You need one now.");
      edverb = askEdVerbAgain();
    }
    if (edverb.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers are != verbs, try again");
      edverb = askEdVerbAgain();
    }
    String currentEdVerb = edverb;
    String bodyPart = MessageBox.askForTextInput("What is the body part?");
    if (bodyPart.isEmpty())
    {
      MessageBox.showMessage("No body, no story, pay attention and start over");
      bodyPart = askBodyPartAgain();
    }
    if (bodyPart.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers <> body parts, try again");
      bodyPart = askBodyPartAgain();
    }
    String currentBodyPart = bodyPart;
    String currentStory = "Today ";
    currentStory = currentStory + "I woke " + currentAdverb + ". ";
    currentStory = currentStory + "Then I " + currentEdVerb + " ";
    currentStory = currentStory + "my " + currentBodyPart + ". ";
    MessageBox.showMessage(currentStory);
  }

  private static String askBodyPartAgain()
  {
    String bodyPart;
    bodyPart = MessageBox.askForTextInput("What is the body part?");
    return bodyPart;
  }

  private static String askEdVerbAgain()
  {
    String edverb;
    edverb = MessageBox.askForTextInput("What is the -ed verb?");
    return edverb;
  }

  private static String askAdverbAgain()
  {
    String adverb;
    adverb = MessageBox.askForTextInput("What is the adverb?");
    return adverb;
  }
}