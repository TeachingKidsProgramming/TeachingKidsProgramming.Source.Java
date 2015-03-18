package org.teachingextensions.approvals.lite.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Listens to the state of a EnabledConditions object
 */
public class FilterUtils {
    /**
     * @param fromObjects a collection of objects to filter
     * @param filter an optional parameter which indicates whether the item is extracted
     * @return a new List containing all elements of the list for which isExtracted() would return true
     */
    public static <T> ArrayList<T> retainExtracted(T fromObjects[], Filter filter) throws IllegalArgumentException {
        return fromObjects == null ? new ArrayList<T>() : filter(Arrays.asList(fromObjects), filter, true);
    }

    /**
     * @param collection      the collection to filter
     * @param filter          an optional parameter which indicates whether the item is extracted
     * @param retainExtracted true if the filter should retained the extracted items
     * @return a new List containing all elements of the list for which isExtracted() would return true
     */
    private static <T> ArrayList<T> filter(Iterable<? extends T> collection, Filter filter, boolean retainExtracted) throws IllegalArgumentException {
        ArrayList<T> extracted = new ArrayList<>();
        if (collection != null) {
            for (T t : collection) {
                boolean ex = (filter == null || filter.isExtracted(t));
                if (ex == retainExtracted) {
                    extracted.add(t);
                }
            }
        }
        return extracted;
    }
}