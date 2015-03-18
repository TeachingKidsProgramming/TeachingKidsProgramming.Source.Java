package org.teachingextensions.approvals.lite.util.io;

import junit.framework.TestCase;


/**
 * A static class of convenience functions for Files
 */
public class FileUtilsTest extends TestCase {
    public void testExtensionWithDot() throws Exception {
        assertEquals(".txt", FileUtils.getExtensionWithDot("c:\\some.thing\\there\\a.txt"));
    }

}