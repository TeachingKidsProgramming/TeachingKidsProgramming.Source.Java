package org.teachingextensions.logo.tests;

import junit.framework.TestCase;

import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.reporters.windows.TortoiseTextDiffReporter;
import org.teachingextensions.logo.utils.ColorUtils.Wheel;

public class WheelTest extends TestCase
{
  @UseReporter(TortoiseTextDiffReporter.class)
  public void testWheel() throws Exception
  {
    String out = "";
    Wheel<Integer> wheel = new Wheel<Integer>();
    wheel.add(4);
    wheel.add(6);
    wheel.add(8);
    for (int i = 0; i < 7; i++)
    {
      out += wheel.next() + " - ";
    }
    Approvals.verify(out);
  }
}
