package org.teachingkidsprogramming.util;

import org.lambda.actions.Action0;
import org.teachingkidsprogramming.util.LambdaThreadLauncher;
import org.teachingkidsprogramming.util.MySystem;

import java.lang.reflect.Method;

public class ThreadLauncher implements Runnable {
    private Object object = null;
    private Object[] objectParams = null;
    private Method method = null;
    private long delay;

    /**
     * *******************************************************************
     */
    public ThreadLauncher(Object object, Method method, Object[] objectParams, long delay) {
        this.delay = delay;
        this.object = object;
        this.method = method;
        this.objectParams = objectParams;
        new Thread(this).start();
    }

    /**
     * *******************************************************************
     */
    public ThreadLauncher(Object object, String methodName) throws SecurityException, NoSuchMethodException {
        this(object, object.getClass().getMethod(methodName, (Class[]) null), null, 0);
    }

    /**
     * *******************************************************************
     */
    public void run() {
        try {
            Thread.sleep(delay);
            //My_System.event("Running " + method.getName());
            method.invoke(object, objectParams);
        } catch (Throwable t) {
            MySystem.warning("Caught throwable exception ", t);
        }
    }
    /***********************************************************************/
    /**
     * *******************************************************************
     */
    public static void launch(Action0 action) {
        new LambdaThreadLauncher(action);
    }
}
