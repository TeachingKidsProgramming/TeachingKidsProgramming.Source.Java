package com.spun.util;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * A static class of convenience functions for Manipulating objects
 **/
public class ObjectUtils
{
  public static int generateHashCode(Object... relevantMembers)
  {
    final int PRIME = 31;
    int result = 1;
    for (Object member : relevantMembers)
    {
      result = PRIME * result + ((member == null) ? 0 : member.hashCode());
    }
    return result;
  }
  /***********************************************************************/
  /**
   * tests if two objects are equal for all functions passed.
   **/
  public static boolean isEqualForMethods(Object o1, Object o2, String[] methods)
  {
    try
    {
      Method[] m1 = getMethodsForObject(o1, methods);
      Method[] m2 = getMethodsForObject(o2, methods);
      for (int i = 0; i < m1.length; i++)
      {
        Object v1 = m1[i].invoke(o1, (Object[]) null);
        Object v2 = m2[i].invoke(o2, (Object[]) null);
        if (!isEqual(v1, v2)) { return false; }
      }
      return true;
    }
    catch (Throwable t)
    {
      throw new Error(t);
    }
  }
  /***********************************************************************/
  public static Method[] getMethodsForObject(Object o2, String[] passedMethods) throws SecurityException,
      NoSuchMethodException
  {
    Method methods[] = new Method[passedMethods.length];
    Class<? extends Object> clazz = o2.getClass();
    for (int i = 0; i < passedMethods.length; i++)
    {
      methods[i] = clazz.getMethod(passedMethods[i], (Class[]) null);
    }
    return methods;
  }
  /***********************************************************************/
  /**
   * A convenience function to check if 2 strings are equal.
   * @param s1 The string in question
   * @param s2 The other string
   * @return true if Equal.
   **/
  public static boolean isEqual(Object s1, Object s2)
  {
    if (s1 == s2)
    {
      return true;
    }
    else if ((s1 != null) && s1.equals(s2))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  /***********************************************************************/
  public static boolean isIn(Object target, Object[] objects)
  {
    for (int i = 0; i < objects.length; i++)
    {
      if (ObjectUtils.isEqual(objects[i], target)) { return true; }
    }
    return false;
  }

  /***********************************************************************/
  public static boolean isThisInstanceOfThat(Class<?> thiz, Class<?> that)
  {
    return that.isAssignableFrom(thiz);
  }
  /***********************************************************************/
  public static Error throwAsError(Throwable t) throws Error
  {
    if (t instanceof RuntimeException)
    {
      throw (RuntimeException) t;
    }
    else if (t instanceof Error)
    {
      throw (Error) t;
    }
    else
    {
      throw new Error(t);
    }
  }
  /***********************************************************************/
  public static <T> T getRandomIndex(T[] array)
  {
    if ((array == null) || (array.length == 0)) { return null; }
    return array[NumberUtils.RANDOM.nextInt(array.length)];
  }
  /***********************************************************************/
  private static Class[] getAllCastableClasses(Object object)
  {
    Class<? extends Object> clazz = object.getClass();
    ArrayList<Object> list = new ArrayList<Object>();
    while (clazz != null)
    {
      list.add(clazz);
      ArrayUtils.addArray(list, clazz.getInterfaces());
      clazz = clazz.getSuperclass();
    }
    Class[] found = (Class[]) list.toArray(new Class[list.size()]);
    ArrayUtils.toReverseArray(found);
    return found;
  }
  /***********************************************************************/
  public static Object executeMethod(Object object, String method, Class[] methodSignature, Object[] parameters)
  {
    try
    {
      return object.getClass().getMethod(method, methodSignature).invoke(object, parameters);
    }
    catch (Throwable t)
    {
      throw throwAsError(t);
    }
  }
  /***********************************************************************/
  public static String getClassName(Object o)
  {
    return o == null ? "null" : o.getClass().getName();
  }


  /************************************************************************/
  private static Class getBestClass(Object value, Method method)
  {
    return value == null ? method.getReturnType() : value.getClass();
  }
  /************************************************************************/
  /************************************************************************/
}