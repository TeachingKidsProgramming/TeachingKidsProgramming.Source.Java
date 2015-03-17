package org.teachingkidsprogramming.approvals.lite;

public interface ApprovalFailureReporter {
    public void report(String received, String approved) throws Exception;
}
