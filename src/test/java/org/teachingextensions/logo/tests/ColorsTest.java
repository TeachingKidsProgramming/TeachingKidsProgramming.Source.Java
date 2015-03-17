package org.teachingextensions.logo.tests;

import junit.framework.TestCase;

import org.teachingextensions.logo.PenColors;

public class ColorsTest extends TestCase
{
  public void testTransparency() throws Exception
  {
    assertEquals(0, PenColors.calculateTransparency(100));
    assertEquals(255, PenColors.calculateTransparency(0));
  }
}
