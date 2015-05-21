package org.teachingextensions.setup;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;

public class SetupConfigTest {

  @Test
  public void testGetBrewEclipsePath() throws Exception {
    String brewEclipsePath = new SetupConfig().getBrewEclipsePath().replace(System.getProperty("user.home"), "~");
    Approvals.verify(brewEclipsePath);
  }
}
