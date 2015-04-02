package org.teachingkidsprogramming.recipes.deepdives.tests;

import junit.framework.TestCase;

import org.teachingkidsprogramming.section04mastery.DeepDive04Mastery;

public class DeepDive04MasteryTest extends TestCase
{
  public void testQuestions() throws Exception
  {
    assertCurrentlyFailing("theseNumbersCount");
    assertCurrentlyFailing("textTypes");
    assertCurrentlyFailing("theNumbersAfterTheDot");
    assertCurrentlyFailing("everythingIsAnObject");
    assertCurrentlyFailing("iMeanEverythingIsAnObject");
    assertCurrentlyFailing("iMeanEverySinglethingIsAnObject");
    assertCurrentlyFailing("integersAreATypeOfNumber");
    assertCurrentlyFailing("doublesAreATypeOfNumber");
    assertCurrentlyFailing("addingIntegers");
    assertCurrentlyFailing("addingDoubles");
    assertCurrentlyFailing("addingMixedTypes");
    assertCurrentlyFailing("addingMixingMoreTypes");
    assertCurrentlyFailing("convertingToText");
    assertCurrentlyFailing("convertingToText2");
    assertCurrentlyFailing("dividing");
    assertCurrentlyFailing("dividingIntegers");
  }
  public void assertQuestion(String methodName, Object answer) throws Exception
  {
    assertCurrentlyFailing(methodName);
    assertCorrectAnswer(answer, methodName);
  }
  public void assertCorrectAnswer(Object answer, String methodName) throws Exception
  {
    try
    {
      DeepDive04Mastery h = new DeepDive04Mastery();
      if (answer instanceof Integer)
      {
        h.____ = (Integer) answer;
      }
      if (answer instanceof String)
      {
        h.___ = (String) answer;
      }
      if (answer instanceof Boolean)
      {
        h._____ = (Boolean) answer;
        h.______ = (Boolean) answer;
      }
      DeepDive04Mastery.class.getMethod(methodName).invoke(h);
    }
    catch (Exception e)
    {
      if (e.getCause() != null) { throw (Error) e.getCause(); }
      throw e;
    }
  }
  public void assertCurrentlyFailing(String methodName)
  {
    boolean failed = false;
    try
    {
      DeepDive04Mastery h = new DeepDive04Mastery();
      DeepDive04Mastery.class.getMethod(methodName).invoke(h);
    }
    catch (Throwable e)
    {
      failed = true;
    }
    assertTrue("the method " + methodName + " is already passing", failed);
  }
}
