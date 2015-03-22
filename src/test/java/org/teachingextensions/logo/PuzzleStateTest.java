package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.reporters.macosx.BeyondCompareReporter;

import static org.junit.Assert.assertTrue;

@UseReporter(BeyondCompareReporter.class)
public class PuzzleStateTest {

  private static Puzzle getSolvedPuzzle() {
    int[] solved = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    return new Puzzle(solved);
  }

  private static Puzzle getPuzzle(int blank) {
    return getSolvedPuzzle().swapBlank(blank);
  }

  /**
   * The state can tell you what moves are allowed from cell to cell
   */
  @Test
  public void state_has_move_directions() {
    Approvals.verifyAll("Directions", PuzzleState.Direction.values());
  }

  /**
   * The state can tell you if it is a solution to the puzzle
   */
  @Test
  public void state_can_be_solution() {
    Puzzle p = getSolvedPuzzle();
    PuzzleState s = new PuzzleState(p);
    assertTrue(s.isSolution());
  }

  /**
   * The state can tell you all possible next moves for its puzzle.
   */
  @Test
  public void tells_you_next_moves() {
    PuzzleState s = new PuzzleState(getSolvedPuzzle());
    Approvals.verifyAll("Branches for " + s, s.getBranches());
  }

  /**
   * Or we can see the next moves from the top right corner
   */
  @Test
  public void moves_from_top_right() {
    Puzzle p = getPuzzle(2);
    PuzzleState s = new PuzzleState(p);
    Approvals.verifyAll("Branches for " + s, s.getBranches());
  }

  /**
   * Or we can see the next moves from the center
   */
  @Test
  public void moves_from_center(){
    Puzzle p = getPuzzle(4);
    PuzzleState s = new PuzzleState(p);
    Approvals.verifyAll("Branches for " + s, s.getBranches());
  }

  /**
   * Finally, lets see what moves we can do from top center.
   */
  @Test
  public void moves_from_top_center(){
    PuzzleState s = new PuzzleState(getPuzzle(1));
    Approvals.verifyAll("Branches for " + s, s.getBranches());
  }
}
