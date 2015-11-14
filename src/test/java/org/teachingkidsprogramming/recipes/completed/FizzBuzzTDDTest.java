package org.teachingkidsprogramming.recipes.completed;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.teachingkidsprogramming.recipes.completed.section09final.FizzBuzzTDD;

public class FizzBuzzTDDTest
{
  @Test
  public void test1Returns1()
  {
    String result = FizzBuzzTDD.convert(1);
    assertEquals("1", result);
  }
  @Test
  public void test2Returns2()
  {
    String result = FizzBuzzTDD.convert(2);
    assertEquals("2", result);
  }
  @Test
  public void test3ReturnsFizz()
  {
    String result = FizzBuzzTDD.convert(3);
    assertEquals("Fizz", result);
  }
  @Test
  public void test5ReturnsBuzz()
  {
    String result = FizzBuzzTDD.convert(5);
    assertEquals("Buzz", result);
  }
  @Test
  public void test6ReturnsFizz()
  {
    String result = FizzBuzzTDD.convert(6);
    assertEquals("Fizz", result);
  }
  @Test
  public void test10ReturnsBuzz()
  {
    String result = FizzBuzzTDD.convert(10);
    assertEquals("Buzz", result);
  }
  @Test
  public void test15ReturnsFizzBuzz()
  {
    String result = FizzBuzzTDD.convert(15);
    assertEquals("FizzBuzz", result);
  }
}
