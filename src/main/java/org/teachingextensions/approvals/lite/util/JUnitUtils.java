package org.teachingextensions.approvals.lite.util;

import java.awt.GraphicsEnvironment;
import static org.junit.Assume.*;

public class JUnitUtils {
    public static void assumeNotHeadless() {
        boolean headless_check = GraphicsEnvironment.isHeadless();
        assumeFalse(headless_check);
    }
}
