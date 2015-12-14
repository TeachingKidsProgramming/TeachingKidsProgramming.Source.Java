package org.teachingkidsprogramming.recipes.completed.section06modelviewcontroller;

import java.util.Iterator;
import java.util.Scanner;

//*************This Lesson is In Development*****************************//
public class OneFishTwoFish
{
  // Create a Scanner to make a string
  private static Scanner scanner;
  public static void main(String[] args)
  {
    makeAString();
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
      //  Display "And then: " and the fish in the console
      System.out.println("And then: " + fish);
    }
    System.out.println("");
  }
}
