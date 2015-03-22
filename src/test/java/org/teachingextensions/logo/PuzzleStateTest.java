package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.reporters.macosx.BeyondCompareReporter;

import java.util.Stack;

import static org.junit.Assert.*;

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
  public void moves_from_center() {
    Puzzle p = getPuzzle(4);
    PuzzleState s = new PuzzleState(p);
    Approvals.verifyAll("Branches for " + s, s.getBranches());
  }

  /**
   * Finally, lets see what moves we can do from top center.
   */
  @Test
  public void moves_from_top_center() {
    PuzzleState s = new PuzzleState(getPuzzle(1));
    Approvals.verifyAll("Branches for " + s, s.getBranches());
  }

  /**
   * The actual cost is zero when there is no history
   */
  @Test
  public void actual_cost() {
    PuzzleState s = new PuzzleState(getSolvedPuzzle());
    assertEquals(0, s.getActualCost());
  }

  /**
   * The actual cost is the number of steps in the the history
   */
  @Test
  public void actual_cost_is_actual_steps() {
    Stack<PuzzleState.Direction> history = new Stack<>();
    history.add(PuzzleState.Direction.Right);
    history.add(PuzzleState.Direction.Right);
    PuzzleState s = new PuzzleState(getSolvedPuzzle(), history);
    assertEquals(2, s.getActualCost());
  }

  /**
   * Is not equal to another state when the puzzles are different
   */
  @Test
  public void not_equal_to_state_with_different_puzzle() {
    PuzzleState a = new PuzzleState(getSolvedPuzzle());
    PuzzleState b = new PuzzleState(getPuzzle(2));
    assertNotEquals(a, b);
  }

  /**
   * Is equal to another state when the puzzles are the same
   */
  @Test
  public void equal_to_state_with_same_puzzle() {
    PuzzleState a = new PuzzleState(getPuzzle(1));
    PuzzleState b = new PuzzleState(getPuzzle(1));
    assertTrue(a.equals(b));
  }

  /**
   * Is equal to state with same puzzle even when history differs
   */
  @Test
  public void equal_even_with_different_history() {
    Stack<PuzzleState.Direction> history = new Stack<>();
    history.add(PuzzleState.Direction.Right);
    PuzzleState a = new PuzzleState(getPuzzle(3), history);
    PuzzleState b = new PuzzleState(getPuzzle(3));
    assertEquals(a, b);
  }
}
