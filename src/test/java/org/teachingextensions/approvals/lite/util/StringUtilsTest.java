package org.teachingextensions.approvals.lite.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest
{
  @Test
  public void testStripNonNumericFromNull() throws Exception
  {
    String s = StringUtils.stripNonNumeric(null, false, false);
    assertEquals("", s);
  }
  @Test
  public void testStripNonNumericAllAlpha() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a", false, false);
    assertEquals("", s);
  }
  @Test
  public void testStripNonNumeric() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a1", false, false);
    assertEquals("1", s);
  }
  @Test
  public void testStripNonNumericWithNegativeDisallowed() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a-1", false, false);
    assertEquals("1", s);
  }
  @Test
  public void testStripNonNumericWithNegative() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a-1", false, true);
    assertEquals("-1", s);
  }
  @Test
  public void testStripNonNumericWithDecimalDisallowed() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a-1.0", false, false);
    assertEquals("10", s);
  }
  @Test
  public void testStripNonNumericWithDecimalAllowed() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a-1.0", true, false);
    assertEquals("1.0", s);
  }
  @Test
  public void testStripNonNumericWithExponent() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a-1.0e2", true, false);
    assertEquals("1.0e2", s);
  }
  @Test
  public void testStripNonNumericWithNegativeExponent() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a-1.0e-2", true, false);
    assertEquals("1.0e-2", s);
  }
  @Test
  public void testStripNonNumericWithExponentDisallowed() throws Exception
  {
    String s = StringUtils.stripNonNumeric("a-1.0e2", false, false);
    assertEquals("102", s);
  }
  @Test
  public void testIsNullNonZero() throws Exception
  {
    assertFalse(StringUtils.isNonZero(null));
  }
  @Test
  public void testIsEmptyNonZero() throws Exception
  {
    assertFalse(StringUtils.isNonZero("   "));
  }
  @Test
  public void testIsNonZero() throws Exception
  {
    assertTrue(StringUtils.isNonZero(" a  "));
  }
  @Test
  public void testNullIsEmpty() throws Exception
  {
    assertTrue(StringUtils.isEmpty(null));
  }
  @Test
  public void testEmptyIsEmpty() throws Exception
  {
    assertTrue(StringUtils.isEmpty("    "));
  }
  @Test
  public void testIsEmpty() throws Exception
  {
    assertFalse(StringUtils.isEmpty(" a   "));
  }
}
