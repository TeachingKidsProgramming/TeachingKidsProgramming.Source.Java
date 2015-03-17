package org.teachingkidsprogramming.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Listens to the state of a EnabledConditions object
 **/
public class FilterUtils
{
  /***********************************************************************/
    /***********************************************************************/
    /***********************************************************************/
  /**
   * @return a new List containing all elements of the list for which isExtracted() would return true
   **/
  public static <T> ArrayList<T> retainExtracted(T fromObjects[], Filter filter) throws IllegalArgumentException
  {
    return fromObjects == null ? new ArrayList<>() : filter(Arrays.asList(fromObjects), filter, true);
  }
  /***********************************************************************/
  /**
   * @return a new List containing all elements of the list for which isExtracted() would return true
   **/
  private static <T> ArrayList<T> filter(Iterable<? extends T> collection, Filter filter, boolean retainExtracted) throws IllegalArgumentException
  {
    ArrayList<T> extracted = new ArrayList<>();
    if (collection != null)
    {
      for (T t : collection)
      {
        boolean ex = (filter == null || filter.isExtracted(t));
        if (ex == retainExtracted)
        {
          extracted.add(t);
        }
      }
    }
    return extracted;
  }
  /***********************************************************************/
    /***********************************************************************/
  /*                         INNER CLASSES                               */
    /***********************************************************************/
  /***********************************************************************/
}