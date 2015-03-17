package org.approvaltests.reporters;

import org.teachingkidsprogramming.approvals.lite.ApprovalFailureReporter;

public interface EnvironmentAwareReporter extends ApprovalFailureReporter
{
  boolean isWorkingInThisEnvironment(String forFile);
}
