package org.teachingkidsprogramming.util;

import java.io.Serializable;
import java.lang.reflect.Method;

import com.spun.util.ObjectUtils;
import com.spun.util.filters.Filter;
import com.spun.util.filters.FilterUtils;

public class MethodExecutionPath implements Serializable {
	private static final long serialVersionUID = 880073980003375984L;

	public static class Parameters {
		public static Method getBestFitMethod(Class<?> clazz,
				String currentMethodName, Class[] definitions)
				throws NoSuchMethodException {
			try {
				return clazz.getMethod(currentMethodName, definitions);
			} catch (NoSuchMethodException e) {
				Method[] methods = FilterUtils.retainExtracted(
						clazz.getMethods(),
						new MethodParameterFilter(currentMethodName,
								definitions)).toArray(new Method[0]);
				if (methods.length == 0) {
					throw e;
				}
				if (methods.length == 1) {
					return methods[0];
				} else {
					throw new Error(
							"Don't know how to handle multiple available methods yet.");
				}
			}
		}
	}

	public static class MethodParameterFilter implements Filter {

		private String methodName;
		private Class[] classParameters;

		public MethodParameterFilter(String methodName, Class[] classParameters) {
			super();
			this.methodName = methodName;
			this.classParameters = classParameters;
		}

		@Override
		public boolean isExtracted(Object object)
				throws IllegalArgumentException {
			ObjectUtils.assertInstance(Method.class, object);
			Method m = (Method) object;
			if (m.getName().equals(methodName)
					&& m.getParameterTypes().length == classParameters.length) {
				Class<?>[] params = m.getParameterTypes();
				for (int i = 0; i < params.length; i++) {
					if (!ObjectUtils.isThisInstanceOfThat(classParameters[i],
							params[i])) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		}
	}
}
