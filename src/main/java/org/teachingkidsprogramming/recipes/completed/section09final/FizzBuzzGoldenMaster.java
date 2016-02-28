package org.teachingkidsprogramming.recipes.completed.section09final;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;

public class FizzBuzzGoldenMaster
{
  @Test
  public void testNumbers() throws Exception
  {
    //  ARRANGE - Create a list of numbers from 1-100
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < 10; i++)
    {
      // ACT - Call the convertNumbers method on the list
      sb.append(convert(i));
    }
    //  DOWNLOAD 'BeyondCompare' - http://www.scootersoftware.com/download.php
    //  VERIFY that the list is as a Golden Master using Approvals (uses .received and .approved files)
    Approvals.verify(sb);
  }
  public static String convert(int i)
  {
    if (0 == i % 15) { return "\nFizzBuzz"; }
    if (0 == i % 5) { return "\nBuzz"; }
    if (0 == i % 3) { return "\nFizz"; }
    return "\n" + i;
  }
}
