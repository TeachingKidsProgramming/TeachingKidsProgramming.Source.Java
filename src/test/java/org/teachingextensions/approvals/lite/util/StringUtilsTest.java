package org.teachingextensions.approvals.lite.util;

import junit.framework.TestCase;
import org.teachingextensions.approvals.lite.Approvals;


public class StringUtilsTest extends TestCase {

    public void testWriteToString() throws Exception {
        Approvals.verify(StringUtils.toString("things", new Object[]{1, null, "hi"}));
    }

    /***********************************************************************/
    /***********************************************************************/
}
