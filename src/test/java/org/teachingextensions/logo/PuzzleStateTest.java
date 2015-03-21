package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.FileLauncherReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;

@UseReporter(FileLauncherReporter.class)
public class PuzzleStateTest {

  /**
   * The state can tell you what moves are allowed from cell to cell
   */
  @Test
  public void state_has_move_directions(){
  StringBuilder b = new StringBuilder();
    Approvals.verifyAll("Directions", PuzzleState.Directions.values());
  }
}
