package org.teachingextensions.approvals.lite.util.velocity;

import junit.framework.TestCase;
import org.apache.velocity.context.Context;

public class VelocitySilentTest
        extends TestCase implements ContextAware {
    /**
     * *******************************************************************
     */
    public void testMethod() throws Exception {
        assertEquals("", VelocityParser.parseString("$!main.toString()", this));
    }

    /**
     * *******************************************************************
     */

    /**
     * *******************************************************************
     */
    public String toString() {
        return null;
    }

    /**
     * *******************************************************************
     */
    public void setupContext(Context context) {
        context.put("main", this);
        context.put("nullValue", null);
    }

}
/***********************************************************************/
/***********************************************************************/
