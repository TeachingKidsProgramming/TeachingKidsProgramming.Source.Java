package org.teachingextensions.approvals.lite.util.velocity;

import junit.framework.TestCase;
import org.apache.velocity.context.Context;

public class VelocityTest extends TestCase implements ContextAware {
    /**
     * *******************77************************************************
     */
    public void testCodeWorks() throws Exception {
        assertEquals(getClass().getName(), VelocityParser.parseString("$main.getClass().getName()", this));
    }

    public void testUnknownField() {
        assertErrorThrown("$main.unknownField");
    }

    /**
     * *******************************************************************
     */
    public void testUnknownFieldThenMethod() {
        assertErrorThrown("$main.unknownField.someMethod()");
    }

    /**
     * *******************************************************************
     */
    private void assertErrorThrown(String string) {
        String result;
        try {
            result = VelocityParser.parseString(string, this);
        } catch (Throwable t) {
            return;
        }
        fail("parsing '" + string + "' did not fail but returned '" + result + "'");
    }

    /**
     * *******************************************************************
     */
    public void testUnknownMethod() {
        assertErrorThrown("$main.unknownMethod()");
    }

    /**
     * *******************************************************************
     */
    public Object getNull() {
        return null;
    }

    /**
     * *******************************************************************
     */
    public void setupContext(Context context) {
        context.put("main", this);
    }
}
/***********************************************************************/
/***********************************************************************/
