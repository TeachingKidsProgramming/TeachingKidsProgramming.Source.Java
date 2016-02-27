package org.teachingkidsprogramming.recipes.completed.section09final;

public class FizzBuzz
{
  public static void main(String[] args)
  {
    StringBuilder sb = new StringBuilder();
    //  For the whole numbers from 1 to 100, print either that number, or, 
    for (int i = 1; i < 101; i++)
    {
      sb.append(convert(i));
    }
    System.out.print(sb);
  }
  public static String convert(int i)
  {
    //  If that number is divisible by 3 and 5, then print the word 'FizzBuzz'
    if (0 == i % 15) { return "\n FizzBuzz"; }
    //  If that number is divisible by 5, then print the word 'Buzz', 
    if (0 == i % 5) { return "\n Buzz"; }
    //  If that number is divisible by 3, then print the word 'Fizz', 
    if (0 == i % 3) { return "\n Fizz"; }
    return "\n " + i;
  }
}
