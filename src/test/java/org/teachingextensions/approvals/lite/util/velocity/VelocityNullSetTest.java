package org.teachingextensions.approvals.lite.util.velocity;

import junit.framework.TestCase;

import org.apache.velocity.context.Context;


public class VelocityNullSetTest extends TestCase implements ContextAware
{
    /***********************************************************************/
  public void testField() throws Exception
  {
    //assertEquals("not null, null", VelocityParser.parseString("#set($s = $value)$s,#set($s = $nullValue)$s", this));
  }
  /***********************************************************************/
  public void setupContext(Context context)
  {
    context.put("value", "not null");
    context.put("nullValue", null);
    context.put("array", new String[]{"1", "2", null, null, "5"});
  }
}
/***********************************************************************/
/***********************************************************************/
