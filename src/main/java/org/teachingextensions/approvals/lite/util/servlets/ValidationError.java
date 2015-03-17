package org.teachingextensions.approvals.lite.util.servlets;

import org.teachingextensions.approvals.lite.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;

public class ValidationError extends RuntimeException {
	private static final long serialVersionUID = 7940285202708976073L;
    private HashMap<String, String> errors = new HashMap<>();
	private HashSet<String> assertions = null;

    /***********************************************************************/
	public ValidationError(Enum enumumations[]) {
		this.assertions = new HashSet<>();
		for (Enum e : enumumations) {
			this.assertions.add(e.toString());
		}
	}

    /***********************************************************************/
	public String getMessage() {
		return toString();
	}

	/***********************************************************************/
	public String toString() {
		return "Validation(s) failed " + errors.keySet().toString() + " - "
				+ errors.values().toString();
	}

    /***********************************************************************/
	public void set(Enum assertion, boolean isOk, String errorDescription) {
		setError(assertion.toString(), !isOk, errorDescription);
	}

	/***********************************************************************/
	public void setError(String assertion, boolean isError,
			String errorDescription) {
		if (isError && !StringUtils.isNonZero(errorDescription)) {
			throw new Error("You can not use empty error descriptions");
		}
		assertValidAssertion(assertion);
		if (isError) {
			errors.put(assertion, errorDescription);
		} else {
			errors.remove(assertion);
		}
	}

    /***********************************************************************/
	public ValidationError add(String prefix, int index, ValidationError error) {
		return add(getPrefixForIndex(prefix, index), error);
	}

    /***********************************************************************/
	public static String getPrefixForIndex(String prefix, int index) {
		return prefix + "[" + index + "]";
	}

	/***********************************************************************/
	public ValidationError add(String prefix, ValidationError error) {
		prefix = StringUtils.isEmpty(prefix) ? "" : (prefix + ".");
		String[] assertions = StringUtils.toArray(error.assertions);
        for (String assertion : assertions) {
            this.assertions.add(prefix + assertion);
        }
        for (Object key : error.errors.keySet()) {
            errors.put(prefix + key, error.errors.get(key));
        }
		return this;
	}

	/***********************************************************************/
	public boolean isOk() {
		return (errors.size() == 0);
	}

	/***********************************************************************/
	private void assertValidAssertion(String assertion) {
		if (!this.assertions.contains(assertion)) {
			// My_System.warning("Assertion '" + assertion + "' not found from "
			// + assertions.toString());
			throw new Error("Assertion '" + assertion + "' not found from "
					+ assertions.toString());
		}
	}

    /***********************************************************************/
	public int size() {
		return errors.size();
	}

    /***********************************************************************/

    /***********************************************************************/
}