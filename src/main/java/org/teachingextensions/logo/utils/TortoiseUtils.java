package org.teachingextensions.logo.utils;

import org.teachingkidsprogramming.approvals.lite.Approvals;
import org.teachingkidsprogramming.approvals.lite.namer.ApprovalResults;
import org.teachingextensions.logo.Turtle;

import org.teachingkidsprogramming.util.ObjectUtils;

public class TortoiseUtils
{
  private static Turtle TURTLE = new Turtle();
  /**
   * Captures an image of the result of your program and displays it to you
   */
  public static void verify()
  {
    try
    {
      Approvals.verify(TURTLE.getImage());
    }
    catch (Exception e)
    {
      throw ObjectUtils.throwAsError(e);
    }
    finally
    {
      TortoiseUtils.resetTurtle();
    }
  }
  public static void resetTurtle()
  {
    TURTLE = new Turtle();
  }
  public static void setOrientation(int x, int y, int angle)
  {
    TURTLE.setX(x);
    TURTLE.setY(y);
    TURTLE.setAngleInDegrees(angle);
  }
  public static Turtle getTurtle()
  {
    return TURTLE;
  }
  public static void setTurtle(Turtle turtle)
  {
    TortoiseUtils.TURTLE = turtle;
  }
  public static void verifyForOs()
  {
    ApprovalResults.UniqueForOs();
    verify();
  }
  public static void writeMessage(String string, int x, int y)
  {
    TURTLE.setX(x);
    TURTLE.setY(y);
    TURTLE.print(string);
  }
}
