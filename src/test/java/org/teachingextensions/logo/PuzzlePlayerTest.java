package org.teachingextensions.logo;

import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.logo.utils.PuzzleUtils.Puzzle;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzlePlayer;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzleState;

/**
 * Test a puzzle player
 */
public abstract class PuzzlePlayerTest
{
  protected void verifySolution()
  {
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 8, 7};
    Puzzle p = new Puzzle(cells);
    PuzzlePlayer b = getPlayer(p);
    PuzzleState s = b.solve();
    Approvals.verifyAll("Solve " + p, s.getHistory());
  }
  protected abstract PuzzlePlayer getPlayer(Puzzle puzzle);
  protected void verifyLongSolution()
  {
    int[] cells = {0, 1, 2, 3, 4, 8, 5, 6, 7};
    Puzzle p = new Puzzle(cells);
    PuzzlePlayer b = getPlayer(p);
    PuzzleState s = b.solve();
    Approvals.verifyAll("From " + p + " to " + s.getPuzzle(), s.getHistory());
  }
}
