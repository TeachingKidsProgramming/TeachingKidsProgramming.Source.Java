package org.teachingkidsprogramming.approvals.lite.namer;

import org.teachingkidsprogramming.approvals.lite.namer.NamerFactory;
import org.teachingkidsprogramming.approvals.lite.namer.OsEnvironmentLabeller;

public class ApprovalResults {
    public static void UniqueForOs() {
        NamerFactory.asMachineSpecificTest(new OsEnvironmentLabeller());
    }
}
