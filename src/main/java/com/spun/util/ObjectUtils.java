package com.spun.util;

import org.teachingkidsprogramming.util.ArrayUtils;
import org.teachingkidsprogramming.util.ClassUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A static class of convenience functions for Manipulating objects
 **/
public class ObjectUtils {
	public static Method[] getMethodsForObject(Object o2, String[] passedMethods)
			throws SecurityException, NoSuchMethodException {
		Method methods[] = new Method[passedMethods.length];
		Class clazz = o2.getClass();
		for (int i = 0; i < passedMethods.length; i++) {
			methods[i] = clazz.getMethod(passedMethods[i], (Class[]) null);
		}
		return methods;
	}

	/**
	 * A convenience function to check if two objects are equal.
	 * 
	 * @param s1
	 *            The first object
	 * @param s2
	 *            The second object
	 * @return true if Equal.
	 **/
	public static boolean isEqual(Object s1, Object s2) {
		if (s1 == s2) {
			return true;
		} else if ((s1 != null) && s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isIn(Object target, Object[] objects) {
		for (int i = 0; i < objects.length; i++) {
			if (ObjectUtils.isEqual(objects[i], target)) {
				return true;
			}
		}
		return false;
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
	 * @deprecated use Query.select()
	 */
	public static Object[] extractArray(Object[] from, String methodName) {
		try {
			if (from == null || from.length == 0) {
				return new Object[0];
			}
			Method method = getGreatestCommonDenominator(from, methodName);
			Object[] array = null;
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
		List<Class> classes = new ArrayList<Class>();
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
		Class<? extends Object> clazz = object.getClass();
		ArrayList<Object> list = new ArrayList<Object>();
		while (clazz != null) {
			list.add(clazz);
			ArrayUtils.addArray(list, clazz.getInterfaces());
			clazz = clazz.getSuperclass();
		}
		Class[] found = (Class[]) list.toArray(new Class[list.size()]);
		ArrayUtils.toReverseArray(found);
		return found;
	}

	public static void assertInstance(Class clazz, Object object) {
		assertInstance(new Class[] { clazz }, object);
	}

	public static void assertInstance(Class classes[], Object object) {
		if (object == null) {
			throw new NullPointerException("Expected Object of Type "
					+ Arrays.asList(extractArray(classes, "getName"))
					+ " but was null");
		}
		for (int i = 0; i < classes.length; i++) {
			if (ClassUtils.getWrapperClass(classes[i]).isInstance(object)) {
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