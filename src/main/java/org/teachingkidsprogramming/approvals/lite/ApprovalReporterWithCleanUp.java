package org.teachingkidsprogramming.approvals.lite;

public interface ApprovalReporterWithCleanUp {
    public void cleanUp(String received, String approved) throws Exception;
}
