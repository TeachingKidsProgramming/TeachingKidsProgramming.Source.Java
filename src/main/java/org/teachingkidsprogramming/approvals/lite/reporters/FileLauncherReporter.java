package org.teachingkidsprogramming.approvals.lite.reporters;


import org.teachingkidsprogramming.approvals.lite.ApprovalFailureReporter;

import org.teachingkidsprogramming.util.TestUtils;
import org.teachingkidsprogramming.util.io.FileUtils;

public class FileLauncherReporter implements ApprovalFailureReporter
{
  //@Override
  public void report(String received, String approved) throws Exception
  {
    if (FileUtils.isNonEmptyFile(approved))
    {
      TestUtils.displayFile(approved);
    }
    TestUtils.displayFile(received);
  }
}
