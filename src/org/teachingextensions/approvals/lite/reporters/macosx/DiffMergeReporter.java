package org.teachingextensions.approvals.lite.reporters.macosx;

import org.teachingextensions.approvals.lite.reporters.GenericDiffReporter;

import java.text.MessageFormat;

public class DiffMergeReporter extends GenericDiffReporter {
  public static final  DiffMergeReporter INSTANCE     = new DiffMergeReporter();
  private static final String            DIFF_PROGRAM = "/Applications/DiffMerge.app/Contents/MacOS/DiffMerge";
  static final         String            MESSAGE      = MessageFormat.format("Unable to find DiffMerge at {0}",
      DIFF_PROGRAM);

  public DiffMergeReporter() {
    super(DIFF_PROGRAM, GenericDiffReporter.STANDARD_ARGUMENTS, MESSAGE, GenericDiffReporter.TEXT_FILE_EXTENSIONS);
  }
}
