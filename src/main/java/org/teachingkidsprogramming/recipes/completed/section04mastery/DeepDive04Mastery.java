package org.teachingkidsprogramming.recipes.completed.section04mastery;

import org.junit.Assert;
import org.junit.Test;

public class DeepDive04Mastery
{
  //  How to do deep dive:
  //  Step 1: Select the method name (theseNumbersCount on line 19) Press the Run Button
  //            PC: Ctrl+F11 
  //            Mac: Command+fn+F11
  //  Step 2: Read the name of the method that failed
  //  Step 3: Fill in the blank (___) to make it pass
  //  Step 4: Consider at least one thing you just learned
  //  Step 5: Advance to the next method
  //  Do not change anything except the blank (___)
  //
  @Test
  public void theseNumbersCount() throws Exception
  {
    Integer number = 2;
    Assert.assertEquals(number.getClass(), Integer.class);
  }
  @Test
  public void textTypes() throws Exception
  {
    String text = "Beans";
    Assert.assertEquals(text.getClass(), String.class);
  }
  @Test
  public void theNumbersAfterTheDot() throws Exception
  {
    Double number = 2.3;
    Assert.assertEquals(number.getClass(), Double.class);
  }
  @Test
  public void everythingIsAnObject() throws Exception
  {
    Object number = 2.3;
    Assert.assertEquals(number.getClass(), Double.class);
  }
  @Test
  public void iMeanEverythingIsAnObject() throws Exception
  {
    Object number = 2;
    Assert.assertEquals(number.getClass(), Integer.class);
  }
  @Test
  public void iMeanEverySinglethingIsAnObject() throws Exception
  {
    Object number = "Everything";
    Assert.assertEquals(number.getClass(), String.class);
  }
  @Test
  public void integersAreATypeOfNumber() throws Exception
  {
    Number number = 2;
    Assert.assertEquals(number.getClass(), Integer.class);
  }
  @Test
  public void doublesAreATypeOfNumber() throws Exception
  {
    Number number = 2.0;
    Assert.assertEquals(number.getClass(), Double.class);
  }
  @Test
  public void addingIntegers() throws Exception
  {
    Number number = 2 + 3;
    Assert.assertEquals(number.getClass(), Integer.class);
  }
  @Test
  public void addingDoubles() throws Exception
  {
    Number number = 2.1 + 3.2;
    Assert.assertEquals(number.getClass(), Double.class);
  }
  @Test
  public void addingMixedTypes() throws Exception
  {
    Number number = 2 + 0.1;
    Assert.assertEquals(number.getClass(), Double.class);
    Assert.assertEquals(number, 2.1);
  }
  @Test
  public void addingMixingMoreTypes() throws Exception
  {
    Object number = "19 fought 20, " + 21;
    Assert.assertEquals(number.getClass(), String.class);
    Assert.assertEquals(number, "19 fought 20, 21");
  }
  @Test
  public void convertingToText() throws Exception
  {
    Integer number = 21;
    String text = number.toString();
    Assert.assertEquals(text.getClass(), String.class);
    Assert.assertEquals(text, "21");
  }
  @Test
  public void convertingToText2() throws Exception
  {
    Integer number = 21;
    String text = "" + number;
    Assert.assertEquals(text.getClass(), String.class);
    Assert.assertEquals(text, "21");
  }
  @Test
  public void dividing() throws Exception
  {
    Number number = 1.0 / 5;
    Assert.assertEquals(number.getClass(), Double.class);
    Assert.assertEquals(number, .2);
  }
  @Test
  public void dividingIntegers() throws Exception
  {
    Number number = 11 / 5;
    Assert.assertEquals(number.getClass(), Integer.class);
    Assert.assertEquals(number, 2);
  }
  @Test
  public void understandingNumbers() throws Exception
  {
    String text = "42";
    Number theAnswer = Integer.parseInt(text);
    Assert.assertEquals(theAnswer.getClass(), Integer.class);
    Assert.assertEquals(theAnswer, 42);
  }
  @Test
  public void understandingDoubleNumbers() throws Exception
  {
    String text = "42";
    Number theAnswer = Double.parseDouble(text);
    Assert.assertEquals(theAnswer.getClass(), Double.class);
    Assert.assertEquals(theAnswer, 42.0);
  }
  /**
   * Ignore the following, It's needed to run the deep dive
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
  public Integer ____   = null;
  public String ___()
  {
    return ___;
  }
}
