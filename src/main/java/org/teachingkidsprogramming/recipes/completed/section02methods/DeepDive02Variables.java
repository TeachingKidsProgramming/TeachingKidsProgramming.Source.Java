package org.teachingkidsprogramming.recipes.completed.section02methods;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("unused")
public class DeepDive02Variables
{
  //  How to do deep dive:
  //  Step 1: Select the method name (youCanReadVariables on line 20) Press the Run Button
  //            PC: Ctrl+F11 
  //            Mac: Command+fn+F11
  //  Step 2: Read the name of the method that failed
  //  Step 3: Fill in the blank (___) to make it pass
  //  Step 4: Consider at least one thing you just learned
  //  Step 5: Advance to the next method
  //  Do not change anything except the blank (___)
  //
  @Test
  public void youCanReadVariables() throws Exception
  {
    int numberOfDesserts = 5;
    Assert.assertEquals(numberOfDesserts, 5);
  }
  @Test
  public void youCanSaveVariables() throws Exception
  {
    int ickynessOfBrothers = 10;
    Assert.assertEquals(10, ickynessOfBrothers);
  }
  @Test
  public void youCanDoMathWithVariables() throws Exception
  {
    int numberOfHarryPotterBooks = 3 + 4;
    Assert.assertEquals(7, numberOfHarryPotterBooks);
  }
  @Test
  public void youCanChangeVariables() throws Exception
  {
    int milkTastiness = 6;
    addChocolate();
    milkTastiness = 10;
    Assert.assertEquals(milkTastiness, 10);
  }
  @Test
  public void variablesAreSnotStuck() throws Exception
  {
    int boogers = 4;
    blowNose();
    boogers = 0;
    Assert.assertEquals(0, boogers);
  }
  @Test
  public void youCanAddToAVariable() throws Exception
  {
    int age = 11;
    celebrateBirthday();
    age += 1;
    Assert.assertEquals(12, age);
  }
  @Test
  public void youCanAddInMultipleWays() throws Exception
  {
    int bakersDozen = 12;
    bakersDozen = bakersDozen + 1;
    Assert.assertEquals(13, bakersDozen);
  }
  @Test
  public void youCanAddOneInOneMoreWay() throws Exception
  {
    int bearsInABed = 3;
    andTheLittleOneSaid("I'm lonely, come back here");
    bearsInABed++;
    Assert.assertEquals(bearsInABed, 4);
  }
  @Test
  public void youCanSubtractFromAVariable() throws Exception
  {
    int amountOfHomework = 3;
    amountOfHomework -= 3;
    Assert.assertEquals(0, amountOfHomework);
  }
  @Test
  public void youCanSubtractOneInOneMoreWay() throws Exception
  {
    int bottlesOfBeerOnTheWall = 99;
    bottlesOfBeerOnTheWall--;
    Assert.assertEquals(bottlesOfBeerOnTheWall, 98);
  }
  @Test
  public void youCanMultiplyVariables() throws Exception
  {
    int volumeOfMyVoice = 2;
    int volumeMyMomHears = volumeOfMyVoice * 5;
    Assert.assertEquals(10, volumeMyMomHears);
  }
  @Test
  public void youCanDivideVariables() throws Exception
  {
    int inches = 36;
    int feet = inches / 12;
    Assert.assertEquals(3, feet);
  }
  @Test
  public void variablesOnlyExistWithinTheMethod() throws Exception
  {
    String xmasList = "bike";
    dreamBigger(); //This method is directly below
    Assert.assertEquals(xmasList, "bike");
  }
  private void dreamBigger()
  {
    String xmasList = "hippopotamus";
  }
  @Test
  public void methodsCanReturnValues() throws Exception
  {
    String bedPost = prepareForBed(); //This method is directly below
    Assert.assertEquals(bedPost, "gum");
  }
  public String prepareForBed()
  {
    return "gum";
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
  public String ___  = "You need to fill in the blank ___";
  public int    ____ = 10000;
  public int    numberOfHarryPotterBooks;
  public String ___()
  {
    return ___;
  }
  private void addChocolate()
  {
  }
  private void celebrateBirthday()
  {
  }
  private void blowNose()
  {
  }
  private void andTheLittleOneSaid(String string)
  {
  }
}
