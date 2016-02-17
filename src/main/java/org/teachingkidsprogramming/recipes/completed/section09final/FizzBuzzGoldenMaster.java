package org.teachingkidsprogramming.recipes.completed.section09final;

import org.junit.Ignore;
import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;

//********In Progress************************//
public class FizzBuzzGoldenMaster
{
  //   Remove this when working - for build process only
  @Ignore
  @Test
  public void testNumbers() throws Exception
  {
    //  Arrange - create a list of numbers from 1-20
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    //  Act - call the convertNumbers method on the list
    //  Assert that the list is a Golden Master
    Approvals.verify(numbers);
  }
  public static String convertNumbers(Integer[] numbers)
  {
    for (Integer number : numbers)
    {
      convert(number);
    }
    //need to fix or override the ToString here
    return ("" + numbers);
  }
  public static String convert(int i)
  {
    if (0 == i % 15) { return "\n FizzBuzz"; }
    if (0 == i % 5) { return "\n Buzz"; }
    if (0 == i % 3) { return "\n Fizz"; }
    return "" + i;
  }
}
