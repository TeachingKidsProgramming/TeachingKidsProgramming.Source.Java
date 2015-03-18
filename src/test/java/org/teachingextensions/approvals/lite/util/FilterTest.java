package org.teachingextensions.approvals.lite.util;

import junit.framework.TestCase;

public class FilterTest extends TestCase {
    public void testAll() throws Exception {
        Integer[] array = {1, 2, 3, 4, 5};
        FilterOdd filter = new FilterOdd();
        assertEquals("null, extracted", 5, FilterUtils.retainExtracted(array, null).size());
        assertEquals("odd", 3, FilterUtils.retainExtracted(array, filter).size());
    }


    private static class FilterOdd implements Filter {

        public boolean isExtracted(Object o) throws IllegalArgumentException {
            ObjectUtils.assertInstance(Integer.class, o);
            return ((Integer) o).intValue() % 2 == 1;
        }

    }
}
