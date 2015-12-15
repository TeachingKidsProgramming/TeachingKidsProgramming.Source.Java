package org.teachingkidsprogramming.recipes.completed.section09final;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.teachingextensions.approvals.lite.ApprovalWriter;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.logo.Tortoise;

//--------------------This recipe is in progress-------------------------------//
public class SquareKataTDD
{
  //    Draw a square 
  //    HINT: Write each step in English FIRST, then translate to Java one line at a time
  //    TIP: Be sure to run after each line of Java to make sure it works as expected
  //    Write tests using the Assert object via the TDD style shown below
  //    TIP: Fix this test to make it pass to get started
  @Test
  public void test1Returns1()
  {
    String result = FizzBuzzTDD.convert(1);
    assertEquals("1", result);
  }
  @Test
  public void testShowsTheTortoise() throws Exception
  {
    //Set up
    Tortoise.show();
    ApprovalWriter approver = null;
    //Verify
    Approvals.verify(approver, "png");
  }
  @Test
  public void testMovesTheTortoise50()
  {
    //Set up
    //Verify
  }
  @Test
  public void testTurnsTheTortoise90()
  {
    //Set up
    //Verify
  }
  @Test
  public void testDrawsFourSides()
  {
    //Set up
    //Verify
  }
}
