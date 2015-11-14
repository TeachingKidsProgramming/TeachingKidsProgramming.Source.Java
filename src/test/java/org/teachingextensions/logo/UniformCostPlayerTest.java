package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.reporters.macosx.BeyondCompareReporter;
import org.teachingextensions.logo.utils.PuzzleUtils.Puzzle;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzlePlayer;
import org.teachingextensions.logo.utils.PuzzleUtils.UniformCostPlayer;

@UseReporter(BeyondCompareReporter.class)
public class UniformCostPlayerTest extends PuzzlePlayerTest
{
  @Override
  protected PuzzlePlayer getPlayer(Puzzle puzzle)
  {
    return new UniformCostPlayer(puzzle);
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
}
