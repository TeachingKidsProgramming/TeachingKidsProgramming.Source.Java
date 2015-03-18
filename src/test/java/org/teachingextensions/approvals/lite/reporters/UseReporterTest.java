package org.teachingextensions.approvals.lite.reporters;

import junit.framework.TestCase;
import org.teachingextensions.approvals.lite.ReporterFactory;
import org.teachingextensions.approvals.lite.reporters.windows.TortoiseTextDiffReporter;


public class UseReporterTest extends TestCase
{
  @UseReporter(TortoiseTextDiffReporter.class)
  public void testUseReporter() throws Exception
  {
    assertEquals(TortoiseTextDiffReporter.class, ReporterFactory.getFromAnnotation().getClass());
  }
  @UseReporter({TortoiseTextDiffReporter.class, ClipboardReporter.class})
  public void testMultipleUseReporter() throws Exception
  {
    assertEquals(MultiReporter.class, ReporterFactory.getFromAnnotation().getClass());
  }
}
