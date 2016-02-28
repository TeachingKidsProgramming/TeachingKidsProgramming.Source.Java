package org.teachingkidsprogramming.recipes.completed.section09final;

public class FizzBuzzAlternateSolution
{
  public static void main(String[] args)
  {
    for (int i = 1; i < 101; i++)
    {
      String result = "";
      if (isMultipleOfThree(i))
        result += "Fizz";
      if (isMultipleOfFive(i))
        result += "Buzz";
      if (result.equals(""))
        result += i;
      System.out.println(result);
    }
  }
  private static boolean isMultipleOfFive(int i)
  {
    return i % 5 == 0;
  }
  private static boolean isMultipleOfThree(int i)
  {
    return i % 3 == 0;
  }
}
