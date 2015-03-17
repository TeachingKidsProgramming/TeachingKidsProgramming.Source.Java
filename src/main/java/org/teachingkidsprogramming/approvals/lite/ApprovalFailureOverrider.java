package org.teachingkidsprogramming.approvals.lite;


public interface ApprovalFailureOverrider extends ApprovalFailureReporter {
    public boolean askToChangeReceivedToApproved(String received, String approved) throws Exception;
}
