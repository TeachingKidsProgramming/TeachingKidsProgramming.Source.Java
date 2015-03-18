package org.teachingextensions.approvals.lite.util.velocity;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RunAllVelocityTests extends TestSuite
{
  /***********************************************************************/
  public static Test suite() throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    TestSuite suite = new TestSuite("Test for com.spun");
    suite.addTest(new TestSuite(VelocitySilentTest.class));
    suite.addTest(new TestSuite(VelocityTest.class));
    suite.addTest(new TestSuite(VelocityNullSetTest.class));
    return suite;
  }
  /***********************************************************************/
  /***********************************************************************/
}
