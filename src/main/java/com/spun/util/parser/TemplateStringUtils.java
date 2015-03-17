package com.spun.util.parser;


public class TemplateStringUtils {
	public static TemplateStringUtils INSTANCE = new TemplateStringUtils();

	private TemplateStringUtils() {
	}

	public static String clearNull(String value) {
		return clearNull(value, "");
	}

	public static String clearNull(Object value, String replacingValue) {
		return (("null".equals(value) || value == null) ? replacingValue
				: value.toString());
	}

	public static String formatExcelString(String in) {
		if ("0".equals(in) || "null".equals(in) || in == null) // So that null's
																// & int(0) show
																// up empty
		{
			return "\"\"";
		} else if (in.indexOf('\"') == -1) {
			return '\"' + in + '\"';
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append('\"');
			for (int i = 0; i < in.length(); i++) {
				char c = in.charAt(i);
				buffer.append((c == '\"') ? "\"\"" : "" + c);
			}
			buffer.append('\"');
			return buffer.toString();
		}
	}

	public static String toJavaScriptEncode(Object n) {
		if (n == null) {
			return "null";
		} else if (n instanceof Number) {
			return toJavaScriptEncode((Number) n);
		} else {
			return toJavaScriptEncode(n.toString());
		}
	}
}