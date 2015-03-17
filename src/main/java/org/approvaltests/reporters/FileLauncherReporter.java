package org.approvaltests.reporters;


import org.approvaltests.core.ApprovalFailureReporter;

import org.teachingkidsprogramming.util.TestUtils;
import com.spun.util.io.FileUtils;

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
