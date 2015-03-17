package org.teachingkidsprogramming.approvals.lite.reporters;

import org.teachingkidsprogramming.approvals.lite.ApprovalFailureReporter;

public interface EnvironmentAwareReporter extends ApprovalFailureReporter
{
  boolean isWorkingInThisEnvironment(String forFile);
}
