package org.teachingkidsprogramming.approvals.lite.reporters;

import org.teachingkidsprogramming.approvals.lite.ApprovalFailureReporter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseReporter {
    Class<? extends ApprovalFailureReporter>[] value();
}
