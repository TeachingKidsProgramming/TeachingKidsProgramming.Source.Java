package org.teachingextensions.approvals.lite.reporters;

import org.teachingextensions.approvals.lite.ApprovalFailureReporter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseReporter {
    Class<? extends ApprovalFailureReporter>[] value();
}
