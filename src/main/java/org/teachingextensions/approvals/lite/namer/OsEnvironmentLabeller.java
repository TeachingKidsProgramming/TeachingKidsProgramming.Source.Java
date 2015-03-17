package org.teachingextensions.approvals.lite.namer;

import org.teachingkidsprogramming.util.lambda.Function0;

public class OsEnvironmentLabeller implements Function0<String> {
    @Override
    public String call() {
        return System.getProperty("os.name").replace(' ', '_');
    }
}
