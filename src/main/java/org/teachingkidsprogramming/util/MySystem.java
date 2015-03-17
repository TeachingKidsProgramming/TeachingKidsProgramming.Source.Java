package org.teachingkidsprogramming.util;

import java.io.PrintWriter;
import java.util.Vector;

/**
 * A class for printing comments in a standardized format.
 *
 * @author Llewellyn
 * @version 2.0
 */
public class MySystem {
    public static final int IN = 1;
    private static boolean useStackTraceInspection = true;
    public static boolean marker = true;
    public static boolean event = true;
    public static boolean variable = true;
    public static boolean query = true;
    public static int hourGlass = 0;
    private static int m_indent = 0;
    private static long lastTime = System.currentTimeMillis();
    private static PrintWriter SYSTEM_OUT_WRITER = new PrintWriter(System.out, true);

    /**
     * *******************************************************************
     */
    private static void clearHourGlass() {
        if (hourGlass > 0) {
            System.out.println("");
            hourGlass = 0;
        }
    }

    /**
     * Prints to screen the marker specifying function entered.
     */
    public synchronized static void markerOut() {
        markerOut(null);
    }
    /***********************************************************************/
    /**
     * Prints to screen the marker specifying function entered.
     */
    public synchronized static void markerIn() {
        markerIn(null);
    }
    /***********************************************************************/
    /**
     * Prints to screen the marker specifying function entered.
     *
     * @param statement The statement to print
     */
    public synchronized static void markerIn(String statement) {
        if (!marker) {
            return;
        }
        if (useStackTraceInspection) {
            System.out.println(timeStamp() + "**** " + extractMarkerText() + " - IN");
        } else {
            System.out.println(timeStamp() + "**** " + statement + " - IN");
        }
        m_indent++;
    }

    /**
     * *******************************************************************
     */
    private static String extractMarkerText() {
        try {
            StackTraceElement trace[] = new Error().getStackTrace();
            StackTraceElement element = trace[3];
            String text = element.getMethodName();
            String className = element.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            text += "(" + className + ":" + element.getLineNumber() + ")";
            return text;
        } catch (Throwable t) {
            useStackTraceInspection = false;
            return "Can't Inspect Stack Trace";
        }
    }

    /**
     * *******************************************************************
     */
    private static String getIndent() {
        String theIndention = "";
        for (int i = 0; i < m_indent; i++) {
            theIndention += " ";
        }
        return theIndention;
    }

    /**
     * *******************************************************************
     */
    private static String timeStamp() {
        clearHourGlass();
        String text;
        long current = System.currentTimeMillis();
        java.text.DateFormat df = java.text.DateFormat.getDateTimeInstance();
        text = "[" + df.format(new java.util.Date(current)) + " ~" + padNumber(current - lastTime) + "ms]"
                + getIndent();
        lastTime = current;
        return text;
    }

    /**
     * *******************************************************************
     */
    private static String padNumber(long number) {
        String text = "" + number;
        while (text.length() < 6) {
            text = "0" + text;
        }
        return text;
    }

    /**
     * *******************************************************************
     */
    private static String indentMessage(String message) {
        Vector<Integer> v = new Vector<>();
        int place = 0;
        while ((place = message.indexOf('\n', place + 1)) != -1) {
            v.addElement(place);
        }
        if (v.size() == 0) {
            // no '\n'
            return message;
        }
        String theIndention = getIndent();
        StringBuilder buffer = new StringBuilder(message);
        for (int i = (v.size() - 1); i >= 0; i--) {
            int tempplace = v.elementAt(i);
            buffer.insert(tempplace + 1, theIndention);
        }
        return buffer.toString();
    }
    /***********************************************************************/
    /**
     * Prints to screen the marker specifying function exited.
     *
     * @param Statement The statement to print
     */
    public synchronized static void markerOut(String Statement) {
        if (!marker) {
            return;
        }
        m_indent--;
        System.out.println(timeStamp() + "**** " + extractMarkerText() + " - OUT");
    }
    /***********************************************************************/
    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param sqlQuery The SQL query to print
     */
    public synchronized static void query(String sqlQuery) {
        if (!query) {
            return;
        }
        System.out.println(timeStamp() + "~~> SQL - " + sqlQuery);
    }
    /***********************************************************************/
    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param queryName The name of the query
     * @param sqlQuery  The query to print
     */
    public synchronized static void query(String queryName, Object sqlQuery) {
        if (!query) {
            return;
        }
        System.out.println(timeStamp() + "~~> SQL [" + queryName + "] - " + sqlQuery);
    }
    /***********************************************************************/
    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param statement The statement to print
     */
    public synchronized static void variable(String statement) {
        variable(statement, SYSTEM_OUT_WRITER);
    }

    /**
     * *******************************************************************
     */
    public synchronized static void variable(String statement, PrintWriter out) {
        if (!variable) {
            return;
        }
        out.println(timeStamp() + "*=>" + statement);
    }
    /***********************************************************************/
    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param name  The value's name
     * @param value The value to print
     */
    public synchronized static void variable(String name, Object value) {
        if (!variable) {
            return;
        }
        System.out.println(timeStamp() + "*=> " + name + " = '" + (value == null ? null : value.toString()) + "'");
    }
    /***********************************************************************/
    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param name  The name of the array
     * @param array The collection of objects to print
     */
    public synchronized static void variable(String name, Object array[]) {
        if (!variable) {
            return;
        }
        name = (name == null ? "array" : name);
        if (array == null || array.length == 0) {
            System.out.println(timeStamp() + "*=> " + name + ".length = 0");
        } else {
            for (int i = 0; i < array.length; i++) {
                System.out.println(timeStamp() + "*=> " + name + "[" + i + "] = "
                        + ((array[i] == null) ? "null" : array[i].toString()));
            }
        }
    }
    /***********************************************************************/
    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param array A collection of objects to print
     */
    public synchronized static void variable(Object array[]) {
        variable(null, array);
    }
    /***********************************************************************/
    /**
     * Prints to screen any messages to be viewed.
     *
     * @param Statement The statement to print
     */
    public synchronized static void message(String Statement) {
        System.out.println(timeStamp() + indentMessage(Statement));
    }
    /***********************************************************************/
    /**
     * Prints to screen any events to be viewed.
     *
     * @param Statement The statement to print
     */
    public static void event(String Statement) {
        if (!event) {
            return;
        }
        System.out.println(timeStamp() + "*--" + Statement);
    }
    /***********************************************************************/
    /**
     * Prints to screen any warnings to be viewed.
     *
     * @param statement The statement to print
     */
    public synchronized static void warning(String statement) {
        warning(statement, null);
    }
    /***********************************************************************/
    /**
     * Prints to screen any warnings to be viewed.
     *
     * @param throwable The throwable to print
     */
    public synchronized static void warning(Throwable throwable) {
        warning(null, throwable);
    }
    /***********************************************************************/
    /**
     * Prints to screen any warnings to be viewed.
     *
     * @param statement The statement to print
     * @param throwable A throwable instance with error information
     */
    public synchronized static void warning(String statement, Throwable throwable) {
        warning(statement, throwable, null);
    }

    public synchronized static void warning(String statement, Throwable throwable, PrintWriter out) {
        clearHourGlass();
        dualPrintln("******************************************************************************************", out);
        dualPrintln(timeStamp(), out);
        if (statement != null) {
            dualPrintln(statement, out);
        }
        printFullTrace(throwable, false, out);
        if (throwable instanceof OutOfMemoryError) {
            dumpMemory(out);
        }
        dualPrintln("******************************************************************************************", out);
    }

    /**
     * *******************************************************************
     */
    private static void dualPrintln(String string, PrintWriter out) {
        System.out.println(string);
        if (out != null) {
            out.println(string);
        }
    }

    /**
     * *******************************************************************
     */
    private static void printFullTrace(Throwable throwable, boolean causedBy, PrintWriter out) {
        if (throwable != null) {
            dualPrintln((causedBy ? "Caused by : " : "") + throwable.getMessage(), out);
            throwable.printStackTrace();
            if (out != null) {
                throwable.printStackTrace(out);
            }
            if (throwable.getCause() != null) {
                printFullTrace(throwable.getCause(), true, out);
            }
        }
    }
    /***********************************************************************/
    /************************************************************************/
    /************************************************************************/
    /**
     * ********************************************************************
     */
    public static void dumpMemory(PrintWriter out) {
        System.gc();
        java.text.NumberFormat format = java.text.NumberFormat.getNumberInstance();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long usedMemory = totalMemory - freeMemory;
        String statement = "Memory [total, used, free] = [" + format.format(totalMemory) + " , "
                + format.format(usedMemory) + " , " + format.format(freeMemory) + "]";
        variable(statement, out);
    }
    /************************************************************************/
    /***********************************************************************/
    /***********************************************************************/
}
