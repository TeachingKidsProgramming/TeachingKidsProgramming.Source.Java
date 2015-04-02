package org.teachingextensions.approvals.lite.util;

import junit.framework.TestCase;

public class TupleTest extends TestCase
{
  public void test()
  {
    Tuple<String, Integer> tupleOne = new Tuple<>("foo", 1);
    assertEquals("string first", "foo", tupleOne.getFirst());
    assertEquals("integer second", 1, (int) tupleOne.getSecond());
  }
}
