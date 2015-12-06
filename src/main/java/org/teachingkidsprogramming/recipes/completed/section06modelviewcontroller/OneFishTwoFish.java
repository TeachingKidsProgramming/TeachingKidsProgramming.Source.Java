package org.teachingkidsprogramming.recipes.completed.section06modelviewcontroller;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ImageIcon;

import org.teachingextensions.logo.utils.EventUtils.FancyMessageBox;

//*************This Lesson is In Development*****************************//
public class OneFishTwoFish
{
  private static Scanner scanner;
  public static void main(String[] args)
  {
    makeAString();
    int numberOfFish = FancyMessageBox.askForNumericalInput("How many fishes?", "Are Fishes Like Wishes?");
    makeAFishyDecision(numberOfFish);
  }
  public static void makeAString()
  {
    final String input = "1 fish 2 fish red fish blue fish,black fish,blue fish,old fish,new fish ";
    scanner = new Scanner(input);
    System.err.println("\nWe have:  " + input + '\n');
    tellAStory(input);
  }
  private static void tellAStory(final String input)
  {
    Scanner s = scanner.useDelimiter("\\s*fish\\s*");
    System.out.println("So:       " + s.nextInt() + " and " + s.nextInt());
    System.out.println("And:      " + s.next() + " and " + s.next() + '\n');
    for (String fish : new Iterable<String>()
    {
      @Override
      public Iterator<String> iterator()
      {
        scanner = new Scanner(input);
        scanner.useDelimiter(",");
        return scanner;
      }
    })
    {
      System.out.println("And then: " + fish);
    }
    System.out.println("");
  }
  public static void makeAFishyDecision(int numberOfFish)
  {
    String image = "//Users//lynnlangit//Documents//workspace//TeachingKidsProgramming.Source.Java//src//main//resources//icons//thumb-up.png";
    final ImageIcon icon = new ImageIcon(image);
    switch (numberOfFish)
    {
      case -1 :
        FancyMessageBox.showMesage("Had a Fish", "Not hungry anymore...", icon);
        break;
      case 0 :
        FancyMessageBox.showMesage("No Fish", "None", icon);
        break;
      case 1 :
        FancyMessageBox.showMesage("One Fish", "One", icon);
        break;
      case 2 :
        FancyMessageBox.showMesage("Two Fish", "Two", icon);
        break;
      default :
        FancyMessageBox.showMesage("Vegetaraian meal", "Fish are icky", icon);
        break;
    }
  }
}
