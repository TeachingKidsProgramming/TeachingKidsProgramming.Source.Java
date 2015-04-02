package org.teachingextensions.approvals.lite;

import junit.framework.TestCase;

import org.teachingextensions.approvals.lite.reporters.QuietReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;

@UseReporter(QuietReporter.class)
public class ReportInjectionTest extends TestCase
{
  public static class MyReporter implements ApprovalFailureReporter, ApprovalFailureOverrider
  {
    @Override
    public void report(String received, String approved) throws Exception
    {
    }
    @Override
    public boolean askToChangeReceivedToApproved(String received, String approved) throws Exception
    {
      called = getClass();
      return true;
    }
  }
  private static Class<? extends MyReporter> called = null;
  @UseReporter(MyReporter.class)
  public void testOverrideReporterByParameter() throws Exception
  {
    Approvals.verify("some text");
    assertEquals(MyReporter.class, called);
  }
}
