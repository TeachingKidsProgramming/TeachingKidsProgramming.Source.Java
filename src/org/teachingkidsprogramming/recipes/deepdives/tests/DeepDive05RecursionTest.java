package org.teachingkidsprogramming.recipes.deepdives.tests;

import junit.framework.TestCase;

import org.teachingkidsprogramming.section05recursion.DeepDive05Recursion;

public class DeepDive05RecursionTest extends TestCase
{
  public void testQuestions() throws Exception
  {
    assertCurrentlyFailing("changeThePointer");
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
      DeepDive05Recursion h = new DeepDive05Recursion();
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
      DeepDive05Recursion.class.getMethod(methodName).invoke(h);
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
      DeepDive05Recursion h = new DeepDive05Recursion();
      DeepDive05Recursion.class.getMethod(methodName).invoke(h);
    }
    catch (Throwable e)
    {
      failed = true;
    }
    assertTrue("the method " + methodName + " is already passing", failed);
  }
}
