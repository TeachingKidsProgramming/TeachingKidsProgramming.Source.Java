package org.teachingkidsprogramming.approvals.lite.reporters;

import org.teachingkidsprogramming.approvals.lite.reporters.macosx.KaleidoscopeDiffReporter;
import org.teachingkidsprogramming.approvals.lite.reporters.windows.BeyondCompareReporter;
import org.teachingkidsprogramming.approvals.lite.reporters.windows.TortoiseImageDiffReporter;

public class ImageReporter extends FirstWorkingReporter
{
  public ImageReporter()
  {
    super(TortoiseImageDiffReporter.INSTANCE, BeyondCompareReporter.INSTANCE, KaleidoscopeDiffReporter.INSTANCE,
        ImageWebReporter.INSTANCE, QuietReporter.INSTANCE);
  }
}
