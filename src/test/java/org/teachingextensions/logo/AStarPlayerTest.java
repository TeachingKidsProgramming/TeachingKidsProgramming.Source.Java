package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.reporters.macosx.BeyondCompareReporter;
import org.teachingextensions.logo.utils.PuzzleUtils.AStarPlayer;
import org.teachingextensions.logo.utils.PuzzleUtils.Puzzle;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzlePlayer;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzleState;

@UseReporter(BeyondCompareReporter.class)
public class AStarPlayerTest extends PuzzlePlayerTest
{
  @Override
  protected PuzzlePlayer getPlayer(Puzzle puzzle)
  {
    return new AStarPlayer(puzzle);
  }
  /**
   * Produces a puzzle solution
   */
  @Test
  public void solve_puzzle() throws Exception
  {
    verifySolution();
  }
  /**
   * Solve longer puzzle
   */
  @Test
  public void solve_longer_puzzle() throws Exception
  {
    verifyLongSolution();
  }
  /**
   * Solve jumbo puzzle
   */
  @Test
  public void solve_jumbo_puzzle() throws Exception
  {
    int[] cells = {8, 0, 1, 2, 3, 4, 5, 6, 7};
    Puzzle p = new Puzzle(cells);
    PuzzlePlayer b = getPlayer(p);
    PuzzleState s = b.solve();
    Approvals.verifyAll("From " + p + " to " + s.getPuzzle(), s.getHistory());
  }
}
