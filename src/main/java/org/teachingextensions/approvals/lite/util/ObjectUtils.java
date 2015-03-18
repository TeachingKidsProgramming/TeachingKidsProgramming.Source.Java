package org.teachingextensions.approvals.lite.util;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A static class of convenience functions for Manipulating objects
 */
public class ObjectUtils {

    /**
     * A convenience function to check if two objects are equal.
     *
     * @param s1 The first object
     * @param s2 The second object
     * @return true if Equal.
     */
    public static boolean isEqual(Object s1, Object s2) {
        return s1 == s2 || (s1 != null) && s1.equals(s2);
    }

    public static boolean isThisInstanceOfThat(Class<?> thiz, Class<?> that) {
        return that.isAssignableFrom(thiz);
    }

    public static Error throwAsError(Throwable t) throws Error {
        if (t instanceof RuntimeException) {
            throw (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new Error(t);
        }
    }

    /**
     * @param from       the source array
     * @param methodName the filter method
     * @return a filtered array
     */
    public static Object[] extractArray(Object[] from, String methodName) {
        try {
            if (from == null || from.length == 0) {
                return new Object[0];
            }
            Method method = getGreatestCommonDenominator(from, methodName);
            Object[] array;
            if (Object.class.isAssignableFrom(method.getReturnType())) {
                array = (Object[]) Array.newInstance(method.getReturnType(),
                        from.length);
            } else {
                array = (Object[]) Array.newInstance(
                        ClassUtils.getWrapperClass(method.getReturnType()),
                        from.length);
            }
            for (int i = 0; i < from.length; i++) {
                array[i] = method.invoke(from[i], (Object[]) null);
            }
            return array;
        } catch (Exception e) {
            MySystem.warning(e);
            throw ObjectUtils.throwAsError(e);
        }
    }

    public static Method getGreatestCommonDenominator(Object[] from,
                                                      String methodName) throws SecurityException, NoSuchMethodException {
        List<Class> classes = new ArrayList<>();
        ArrayUtils.addArray(classes, getAllCastableClasses(from[0]));
        for (Object o : from) {
            for (int i = classes.size() - 1; i >= 0; i--) {
                Class clazz = classes.get(i);
                if (!isThisInstanceOfThat(o.getClass(), clazz)
                        || !ClassUtils.hasMethod(clazz, methodName)) {
                    classes.remove(i);
                }
            }
        }
        return classes.size() == 0 ? null : ArrayUtils.getLast(classes)
                .getMethod(methodName, (Class[]) null);
    }

    private static Class[] getAllCastableClasses(Object object) {
        Class<?> clazz = object.getClass();
        ArrayList<Object> list = new ArrayList<>();
        while (clazz != null) {
            list.add(clazz);
            ArrayUtils.addArray(list, clazz.getInterfaces());
            clazz = clazz.getSuperclass();
        }
        Class[] found = list.toArray(new Class[list.size()]);
        ArrayUtils.toReverseArray(found);
        return found;
    }

    public static void assertInstance(Class clazz, Object object) {
        assertInstance(new Class[]{clazz}, object);
    }

    public static void assertInstance(Class classes[], Object object) {
        if (object == null) {
            throw new NullPointerException("Expected Object of Type "
                    + Arrays.asList(extractArray(classes, "getName"))
                    + " but was null");
        }
        for (Class aClass : classes) {
            if (ClassUtils.getWrapperClass(aClass).isInstance(object)) {
                return;
            }
        }
        throw new IllegalArgumentException("Expected Object of Type "
                + Arrays.asList(extractArray(classes, "getName")) + " but got "
                + object.getClass().getName());
    }

    public static String getClassName(Object o) {
        return o == null ? "null" : o.getClass().getName();
    }
}