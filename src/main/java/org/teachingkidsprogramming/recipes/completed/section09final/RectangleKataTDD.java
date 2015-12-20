package org.teachingkidsprogramming.recipes.completed.section09final;

import org.junit.Test;
import org.teachingextensions.approvals.lite.ApprovalWriter;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.logo.Tortoise;

//--------------------This recipe is in progress-------------------------------//
public class RectangleKataTDD
{
  //    Draw a rectangle 
  //    HINT: Write each step in English FIRST, then translate to Java one line at a time
  //    TIP: Be sure to run after each line of Java to make sure it works as expected
  //    Write tests using the Approvals object via the TDD style shown below (using the 'Golden Master paradigm')
  //    TIP: Fix this test to make it pass to get started
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
