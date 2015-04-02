package org.teachingextensions.approvals.lite.reporters;

import junit.framework.TestCase;


public class ReporterChainingTest extends TestCase
{
    public static class NonWorkingReporter implements EnvironmentAwareReporter
  {
    @Override
    public void report(String received, String approved) throws Exception
    {
    }
    @Override
    public boolean isWorkingInThisEnvironment(String forFile)
    {
      return false;
    }
  }
  public static class WorkingReporter implements EnvironmentAwareReporter
  {
    public String received;
    @Override
    public void report(String received, String approved) throws Exception
    {
      this.received = received;
    }
    @Override
    public boolean isWorkingInThisEnvironment(String forFile)
    {
      return true;
    }
  }
  public void testFirstWorkingReporter() throws Exception
  {
    WorkingReporter workingReporter = new WorkingReporter();
    WorkingReporter workingReporter2 = new WorkingReporter();
    FirstWorkingReporter reporter = new FirstWorkingReporter(new NonWorkingReporter(), workingReporter,
        workingReporter2);
    reporter.report("Hello", "world");
    assertEquals("Hello", workingReporter.received);
    assertNull(workingReporter2.received);
    assertTrue(reporter.isWorkingInThisEnvironment(""));
  }

}
