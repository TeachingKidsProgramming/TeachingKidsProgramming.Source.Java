package org.teachingextensions.approvals.lite.util;

import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ObjectUtilsTest extends TestCase {
    public void testGreatestCommonDenominator() throws Exception {
        Method gcd = ObjectUtils.getGreatestCommonDenominator(new Object[]{"this", new ArrayList<>()}, "getClass");
        assertEquals(Object.class, gcd.getDeclaringClass());
    }

    /**
     * ********************************************************************
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(ObjectUtilsTest.class);
    }
    /***********************************************************************/
    /***********************************************************************/
}
