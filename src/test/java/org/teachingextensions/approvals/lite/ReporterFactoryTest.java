package org.teachingextensions.approvals.lite;

import junit.framework.TestCase;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.QuietReporter;


public class ReporterFactoryTest extends TestCase
{
  public void testReporters() throws Exception
  {
    assertEquals(DiffReporter.class, getClassFor("txt"));
    assertEquals(DiffReporter.class, getClassFor("html"));
    assertEquals(QuietReporter.class, getClassFor("other"));
  }
  private Class getClassFor(String type)
  {
    return ReporterFactory.get(type).getClass();
  }
}
