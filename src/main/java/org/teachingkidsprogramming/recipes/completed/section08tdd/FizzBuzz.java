package org.teachingkidsprogramming.recipes.completed.section08tdd;

public class FizzBuzz
{
  public static void main(String[] args)
  {
    StringBuilder sb = new StringBuilder();
    //for the whole numbers from 1 to 100, print either that number, or, 
    for (int i = 1; i <= 100; i++)
    {
      sb.append(convert(i));
    }
    System.out.print(sb);
  }
  public static String convert(int i)
  {
    //if that number is evenly divisible by either 3 or 5, then print the word 'FizzBuzz'
    if (0 == i % 15) { return "\n FizzBuzz"; }
    //if that number is evenly divisible by 5, then print the word 'Buzz', 
    if (0 == i % 5) { return "\n Buzz"; }
    //if that number is evenly divisible by 3, then print the word 'Fizz', 
    if (0 == i % 3) { return "\n Fizz"; }
    return "\n " + i;
  }
  //for more complete directions see this page
  //https://www.penflip.com/lynnlangit/tkp-lesson-plans/blob/master/course09.txt
}
