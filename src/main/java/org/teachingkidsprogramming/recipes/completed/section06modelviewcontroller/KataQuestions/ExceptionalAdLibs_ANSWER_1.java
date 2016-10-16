package org.teachingkidsprogramming.recipes.completed.section06modelviewcontroller.KataQuestions;

import org.teachingextensions.logo.utils.EventUtils.MessageBox;

public class ExceptionalAdLibs_ANSWER_1
{
  public static void main(String[] args)
  {
    String adverb = askAdverb();
    String currentAdverb = adverb;
    String edverb = askEdVerb();
    String currentEdVerb = edverb;
    String bodyPart = askBodyPart();
    String currentBodyPart = bodyPart;
    String currentStory = "Today ";
    currentStory = currentStory + "I woke " + currentAdverb + ". ";
    currentStory = currentStory + "Then I " + currentEdVerb + " ";
    currentStory = currentStory + "my " + currentBodyPart + ". ";
    MessageBox.showMessage(currentStory);
  }
  private static String askBodyPart()
  {
    String bodyPart = MessageBox.askForTextInput("What is the body part?");
    if (bodyPart.isEmpty())
    {
      MessageBox.showMessage("No body, no story, pay attention and start over");
      bodyPart = askBodyPart();
    }
    if (bodyPart.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers <> body parts, try again");
      bodyPart = askBodyPart();
    }
    return bodyPart;
  }
  private static String askEdVerb()
  {
    String edverb = MessageBox.askForTextInput("What is the -ed verb?");
    if (edverb.isEmpty())
    {
      MessageBox.showMessage("Don't like verbs? You need one now.");
      edverb = askEdVerb();
    }
    if (edverb.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers are != verbs, try again");
      edverb = askEdVerb();
    }
    return edverb;
  }
  private static String askAdverb()
  {
    String adverb = MessageBox.askForTextInput("What is the adverb?");
    if (adverb.isEmpty())
    {
      MessageBox.showMessage("Y don't you want to play? To start you need one adverb.");
      adverb = askAdverb();
    }
    if (adverb.matches("[\\d]*"))
    {
      MessageBox.showMessage("Numbers are NOT adverbs, try again");
      adverb = askAdverb();
    }
    return adverb;
  }
}