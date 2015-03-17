package org.teachingextensions.windows.tests;

import junit.framework.TestCase;

import org.teachingkidsprogramming.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingkidsprogramming.approvals.lite.reporters.FileLauncherReporter;
import org.teachingkidsprogramming.approvals.lite.reporters.UseReporter;

@UseReporter({FileLauncherReporter.class, DelayedClipboardReporter.class})
public class GraphicsWindowTest extends TestCase
{
  public void testEmptyWindow() throws Exception
  {
  }
}
