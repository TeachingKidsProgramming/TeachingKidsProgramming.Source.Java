package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.reporters.macosx.BeyondCompareReporter;

@UseReporter(BeyondCompareReporter.class)
public class BreadthFirstPlayerTest {
  /**
   * Produces a puzzle solution
   */
  @Test
  public void solve_puzzle() throws Exception {
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 8, 7};
    Puzzle p = new Puzzle(cells);
    BreadthFirstPlayer b = new BreadthFirstPlayer(p);
    PuzzleState s = b.solve();
    Approvals.verifyAll("Solve " + p, s.getHistory());
  }

  /**
   * Solve longer puzzle
   */
  @Test
  public void solve_longer_puzzle() throws Exception {
    int[] cells = {0, 1, 2, 3, 4, 8, 5, 6, 7};
    Puzzle p = new Puzzle(cells);
    BreadthFirstPlayer b = new BreadthFirstPlayer(p);

    PuzzleState s = b.solve();
    Approvals.verifyAll("From " + p + " to " + s.getPuzzle(), s.getHistory());
  }
}
