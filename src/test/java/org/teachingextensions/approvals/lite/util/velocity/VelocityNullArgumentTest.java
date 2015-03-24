package org.teachingextensions.approvals.lite.util.velocity;

import junit.framework.TestCase;

import org.apache.velocity.context.Context;

public class VelocityNullArgumentTest extends TestCase implements ContextAware
{
  public void testOverloadedMethodFound() throws Exception
  {
  }
  @Override
  public void setupContext(Context context)
  {
    context.put("object", this);
    context.put("nullValue", null);
  }
  public static String getClass(Class<?> c)
  {
    return c == null ? "you got null" : c.getName();
  }
  public static String getClass(String c)
  {
    return c == null ? "you got null" : c.getClass().getName();
  }
}
