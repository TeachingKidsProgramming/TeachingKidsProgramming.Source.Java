package org.teachingkidsprogramming.approvals.lite.reporters;

import org.teachingkidsprogramming.approvals.lite.reporters.macosx.MacDiffReporter;
import org.teachingkidsprogramming.approvals.lite.reporters.windows.WindowsDiffReporter;

public class DiffReporter extends FirstWorkingReporter
{
  public static final DiffReporter INSTANCE = new DiffReporter();
  public DiffReporter()
  {
    super(WindowsDiffReporter.INSTANCE, MacDiffReporter.INSTANCE, JunitReporter.INSTANCE, QuietReporter.INSTANCE);
  }
}
