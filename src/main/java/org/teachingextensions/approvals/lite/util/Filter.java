package org.teachingextensions.approvals.lite.util;

public interface Filter<T> {
    /**
     * @param object the item to check
     * @return true if the object would be extracted by the filter
     * @throws IllegalArgumentException if the object is not supported by the filter
     */
    public boolean isExtracted(T object)
            throws IllegalArgumentException;
}