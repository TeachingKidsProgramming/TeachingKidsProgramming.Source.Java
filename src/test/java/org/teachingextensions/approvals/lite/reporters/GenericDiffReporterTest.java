package org.teachingextensions.approvals.lite.reporters;

import junit.framework.TestCase;


public class GenericDiffReporterTest extends TestCase {
    public void testFileExtensions() throws Exception {
        assertTrue(new GenericDiffReporter("", "").isFileExtensionHandled("a.txt"));
    }

    public void testProgramsExist() throws Exception {
        assertFalse(new GenericDiffReporter("this_should_never_exist", "").isWorkingInThisEnvironment("a.txt"));
    }

}
