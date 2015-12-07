package org.teachingkidsprogramming.recipes.completed.section06modelviewcontroller;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ImageIcon;

import org.teachingextensions.logo.utils.EventUtils.FancyMessageBox;

//*************This Lesson is In Development*****************************//
public class OneFishTwoFish
{
  // Create a Scanner to make a string
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
    // Use your scanner with your input
    scanner = new Scanner(input);
    System.err.println("\nWe have:  " + input + '\n');
    // Now, tell a story with a new Scanner instance
    tellAStory(input);
  }
  private static void tellAStory(final String input)
  {
    // Use 'fish' as the base text w/your scanner [story]
    Scanner s = scanner.useDelimiter("\\s*fish\\s*");
    // Get the next number to use in your scanner [story]
    System.out.println("So:       " + s.nextInt() + " and " + s.nextInt());
    // Get the next value to use in your scanner [story]
    System.out.println("And:      " + s.next() + " and " + s.next() + '\n');
    // Iterate over each fish [string]
    for (String fish : new Iterable<String>()
    {
      @Override
      // Create a new string iterator 
      public Iterator<String> iterator()
      {
        // Create a new scanner for your input
        scanner = new Scanner(input);
        // Use a comma to separate the strings in your story
        scanner.useDelimiter(",");
        // Return the result
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
    // Use a switch...case on the number of fish
    switch (numberOfFish)
    {
      // If number of fish is -1
      case -1 :
        String image = "//Users//lynnlangit//Documents//workspace//TeachingKidsProgramming.Source.Java//src//main//resources//icons//thumb-up.png";
        ImageIcon icon = new ImageIcon(image);
        // Show a message with the fancy message box this text, this title and this icon...
        FancyMessageBox.showMesage("Had a Fish", "Not hungry anymore...", icon);
        // End
        break;
      case 0 :
        String image0 = "//Users//lynnlangit//Documents//workspace//TeachingKidsProgramming.Source.Java//src//main//resources//icons//information.png";
        ImageIcon icon0 = new ImageIcon(image0);
        FancyMessageBox.showMesage("No Fish", "Still hungry", icon0);
        break;
      case 1 :
        String image1 = "//Users//lynnlangit//Documents//workspace//TeachingKidsProgramming.Source.Java//src//main//resources//icons//star.png";
        ImageIcon icon1 = new ImageIcon(image1);
        FancyMessageBox.showMesage("One Fish", "This one has a little star", icon1);
        break;
      case 2 :
        String image2 = "//Users//lynnlangit//Documents//workspace//TeachingKidsProgramming.Source.Java//src//main//resources//icons//github.png";
        ImageIcon icon2 = new ImageIcon(image2);
        FancyMessageBox.showMesage("Two Fish", "Funny things are everywhere", icon2);
        break;
      default :
        String image4 = "//Users//lynnlangit//Documents//workspace//TeachingKidsProgramming.Source.Java//src//main//resources//icons//hint.png";
        ImageIcon icon4 = new ImageIcon(image4);
        FancyMessageBox.showMesage("Vegetaraian meal", "Fish are icky", icon4);
        break;
    }
  }
}
