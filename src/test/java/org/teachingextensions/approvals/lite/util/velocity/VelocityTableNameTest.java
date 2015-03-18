package org.teachingextensions.approvals.lite.util.velocity;

import junit.framework.TestCase;
import org.apache.velocity.context.Context;

public class VelocityTableNameTest extends TestCase implements ContextAware
{
  /**********************77*************************************************/
  public void testWTF() throws Exception
  {
    String template = "${main.getObjectName()}Metadata.TABLE_NAME, ";
    assertEquals("CompanyMetadata.TABLE_NAME, ", VelocityParser.parseString(template, this));
  }
  /***********************************************************************/
  public String getObjectName()
  {
    return "Company";
  }
  /***********************************************************************/
  public void setupContext(Context context)
  {
    context.put("main", this);
  }
  /***********************************************************************/
  /***********************************************************************/
}
