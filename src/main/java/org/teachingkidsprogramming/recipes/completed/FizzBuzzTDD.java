package org.teachingkidsprogramming.recipes.completed;

public class FizzBuzzTDD
{
  public static String convert(int i)
  {
    if (0 == i % 15) { return "FizzBuzz"; }
    if (0 == i % 5) { return "Buzz"; }
    if (0 == i % 3) { return "Fizz"; }
    return "" + i;
  }
  //for the numbers being tested, print out either that number, or, 
  //if that number is evenly divisible by 3, then print the word 'Fizz', 
  //if that number is evenly divisible by 5, then print the word 'Buzz', 
  //if that number is evenly divisible by either 3 or 5, then print the word 'FizzBuzz'
  //
  //write tests using the Assert object via the TDD style
  //
  //for more complete directions see this page
  //https://www.penflip.com/lynnlangit/tkp-lesson-plans/blob/master/course09.txt
}
