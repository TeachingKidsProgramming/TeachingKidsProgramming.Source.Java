package org.teachingextensions.approvals.lite.util.parser;

import org.teachingextensions.approvals.lite.util.velocity.ContextAware;
import org.apache.velocity.context.Context;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class TemplateError implements ContextAware {
    private String stackTrace = null;
    private String className = null;
    private String message = null;

    /**
     * *******************************************************************
     */
    public TemplateError(Throwable t, java.lang.Object o) {
        if (o != null) {
            className = o.getClass().getName();
        }
        String cause = getCause(t);
        message = t.getMessage();
        if (message != null && message.startsWith(cause)) {
            message = message.substring(cause.length() + 1);
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintWriter pw = new PrintWriter(output);
        t.printStackTrace(pw);
        pw.flush();

        stackTrace = output.toString();
    }

    /**
     * *******************************************************************
     */
    private String getCause(Throwable t) {
        if (t.getCause() == null) {
            return t.getClass().getName();
        } else {
            return getCause(t.getCause());
        }
    }

    /**
     * *******************************************************************
     */
    public String getMessage() {
        return message;
    }

    /**
     * *******************************************************************
     */
    public String getClassName() {
        return className;
    }

    /**
     * *******************************************************************
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * *******************************************************************
     */
    public void setupContext(Context context) {
        context.put("error", this);
    }
    /***********************************************************************/
    /***********************************************************************/

}