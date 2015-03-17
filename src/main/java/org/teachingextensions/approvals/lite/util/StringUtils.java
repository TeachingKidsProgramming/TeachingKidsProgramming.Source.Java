package org.teachingextensions.approvals.lite.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

/**
 * A static class of convenience functions for database access
 */
public class StringUtils {
    public static final String NEW_LINE = System.getProperty("line.separator");

    /**
     * *******************************************************************
     */
    public static String loadNullableString(String i) {
        return StringUtils.isNonZero(i) ? i.trim() : null;
    }
    /***********************************************************************/

    /**
     * *******************************************************************
     */
    public static String stripWhiteSpace(String text) {
        return stripWhiteSpace(text, false);
    }

    /**
     * *******************************************************************
     */
    public static String padNumber(long number, int digits) {
        String text = "" + number;
        while (text.length() < digits) {
            text = "0" + text;
        }
        return text;
    }

    /**
     * *******************************************************************
     */
    public static String padNumber(int number, int digits) {
        return padNumber((long) number, digits);
    }

    /**
     * *******************************************************************
     */
    public static String stripWhiteSpace(String text, boolean all) {
        StringBuilder newText = new StringBuilder();
        boolean whitespace = false;
        int num = text.length();
        char whiteSpaceChar = ' ';
        boolean atStart = true;
        for (int i = 0; i < num; i++) {
            char c = text.charAt(i);
            switch (c) {
                case '\r':
                case '\n':
                    whiteSpaceChar = '\n';
                    whitespace = true;
                    break;
                case '\t':
                case ' ':
                    whitespace = true;
                    break;
                default:
                    if (whitespace && atStart) {
                        whitespace = false;
                    }
                    if (whitespace) {
                        whitespace = false;
                        newText.append(all ? '_' : whiteSpaceChar);
                        whiteSpaceChar = ' ';
                    }
                    atStart = false;
                    newText.append(c);
                    break;
            }
        }
        return newText.toString();
    }
    /************************************************************************/
    /************************************************************************/
    /**
     * ********************************************************************
     */
    public static String stripNonNumeric(String number, boolean allowDecimal, boolean allowNegative) {
        boolean allowExponential = allowDecimal;
        boolean afterE = false;
        if (number == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    result.append(c);
                    afterE = false;
                    break;
                case '-':
                    if (allowNegative || afterE) {
                        result.append(c);
                        allowNegative = false;
                    }
                    break;
                case '.':
                    if (allowDecimal) {
                        result.append(c);
                        allowDecimal = false;
                    }
                    afterE = false;
                    break;
                case 'e':
                case 'E':
                    if (allowExponential) {
                        result.append(c);
                        allowExponential = false;
                    }
                    afterE = true;
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }
    /***********************************************************************/
    /**
     * A convenience function to check that a String has at least 1 character.
     *
     * @param string The string in question
     * @return true if Non Zero.
     */
    public static boolean isNonZero(String string) {
        return ((string != null) && string.trim().length() > 0);
    }

    /**
     * *******************************************************************
     */
    public static boolean isEmpty(String string) {
        return !isNonZero(string);
    }
    /************************************************************************/
    /**
     * A convenience function to turn a vector of String objects into an Array
     * of the String objects.
     *
     * @param vectorOf a Vector of String objects
     * @return the array of String.
     * @throws Error if an element of vectorOf is not a String object.
     */
    public static String[] toArray(java.util.Collection<String> vectorOf) {
        if (vectorOf == null) {
            return new String[0];
        }
        String array[] = new String[vectorOf.size()];
        java.util.Iterator<String> iterator = vectorOf.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String rowObject = iterator.next();
            if (rowObject != null) {
                array[i++] = rowObject;
            } else {
                throw new Error("toArray[" + i + "] is not an instance of String but a "
                        + ObjectUtils.getClassName(null));
            }
        }
        return array;
    }

    /**
     * *******************************************************************
     */
    public static <T> String toString(String name, T[] array) {
        StringBuilder buffer = new StringBuilder();
        name = (name == null ? "array" : name);
        if (array == null || array.length == 0) {
            buffer.append(name).append(".length = 0");
        } else {
            int maxPadding = ("" + array.length).length();
            for (int i = 0; i < array.length; i++) {
                buffer.append(name).append("[").append(padNumber(i, maxPadding)).append("] = ").append(array[i]).append("\r\n");
            }
        }
        return buffer.toString();
    }

    /**
     * *******************************************************************
     */
    public static <T> String toString(String name, Iterable<T> array) {
        StringBuilder buffer = new StringBuilder();
        name = (name == null ? "array" : name);
        if (array != null) {
            int count = 0;
            for (T t : array) {
                buffer.append(name).append("[").append(count).append("] = ").append(arrayStringHelper(t)).append("\r\n");
                count++;
            }
        }
        if (buffer.length() == 0) {
            buffer.append(name).append(".length = 0");
        }
        return buffer.toString();
    }

    public static String arrayStringHelper(Object o) {
        if (o == null) {
            return "null";
        }
        return o.getClass().isArray() ? Arrays.toString((Object[]) o) : o.toString();
    }

    /***********************************************************************/
    /**
     * *******************************************************************
     */
    public static InputStream convertToInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }

    public static String toString(Map map) {
        StringBuilder b = new StringBuilder();
        Object keySet[] = map.keySet().toArray();
        Arrays.sort(keySet);
        for (Object key : keySet) {
            b.append(String.format("%s : %s \r\n", key, map.get(key)));
        }
        return b.toString();
    }
}