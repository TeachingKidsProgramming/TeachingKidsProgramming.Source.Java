package org.teachingkidsprogramming.section05recursion;

import java.awt.Cursor;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.Tortoise;

//@Ignore
public class DeepDive05Recursion
{
  //  How to do deep dive:
  //  Step 1: Select the method name (doesABear on line 20) Press the Run Button
  //            PC: Ctrl+F11 
  //            Mac: Command+fn+F11
  //  Step 2: Read the name of the method that failed
  //  Step 3: Fill in the blank (___) to make it pass
  //  Step 4: Consider at least one thing you just learned
  //  Step 5: Advance to the next method
  //  Do not change anything except the blank (___)
  //
  //    concepts to cover: recursion
  //    collections (hashmaps and more...)
  //    getters and setters
  //    possible recursive ideas from lisp/clojure
  //    (defn is-even? [n] (if (= n 0) (___ (is-even? (dec n)))))
  //    (defn recursive-reverse [coll] __)
  @Test
  public void helloOne() throws Exception
  {
    int number = 2;
    Assert.assertEquals(number, ____);
  }
  @Test
  public void changeThePointer() throws Exception
  {
    //Set the cursor on the background window to a hand
    Tortoise.getBackgroundWindow().___();
    Assert.assertEquals(getCursor(), Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  }
  /**
   * Ignore the following, It's needed to run the homework
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   */
  public boolean _____  = false;
  public boolean ______ = true;
  public String  ___    = "You need to fill in the blank ___";
  public int     ____   = -100;
  public String ___()
  {
    return ___;
  }
  private Cursor getCursor()
  {
    Cursor cursor = Tortoise.getBackgroundWindow().getCursor();
    return cursor;
  }
}
