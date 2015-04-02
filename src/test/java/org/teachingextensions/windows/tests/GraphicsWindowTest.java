package org.teachingextensions.windows.tests;

import junit.framework.TestCase;

import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.FileLauncherReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;

@UseReporter({FileLauncherReporter.class, DelayedClipboardReporter.class})
public class GraphicsWindowTest extends TestCase
{
  public void testEmptyWindow() throws Exception
  {
  }
}
