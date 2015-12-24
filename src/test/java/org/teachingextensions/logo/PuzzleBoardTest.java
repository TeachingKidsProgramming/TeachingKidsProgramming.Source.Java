package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.ClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.utils.PuzzleUtils.*;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzleState.Direction;

import java.util.Queue;
import java.util.Stack;

@UseReporter({DiffReporter.class, ClipboardReporter.class})
public class PuzzleBoardTest
{
  /**
   * A puzzle board shows the initial puzzle.
   */
  @Test
  public void show_initial_puzzle() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    PuzzleBoard board = new PuzzleBoard(new Puzzle(cells), null);
    PuzzleWindow window = new PuzzleWindow();
    window.getCanvas().add(board);
    Approvals.verify(window.getCanvas());
  }
  /**
   * A puzzle board shows the provided puzzle
   */
  @Test
  public void show_provided_puzzle() throws Exception
  {
    JUnitUtils.assumeNotHeadless();
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 8, 7};
    PuzzleBoard board = new PuzzleBoard(new Puzzle(cells), null);
    PuzzleWindow window = new PuzzleWindow(board);
    Approvals.verify(window.getCanvas());
  }
  @Test
  public void testCreateSolution() throws Exception
  {
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 8, 7};
    Puzzle puzzle = new Puzzle(cells);
    Stack<Direction> history = new Stack<>();
    history.push(Direction.Right);
    PuzzleState state = new PuzzleState(puzzle, history);
    Queue<TileMove> moves = PuzzleBoard.createSolution(state, puzzle);
    Approvals.verifyAll("Solution", moves);
  }
  @Test
  public void testCreateTwoStepSolution() throws Exception
  {
    int[] cells = {0, 1, 2, 3, 8, 5, 6, 4, 7};
    Puzzle puzzle = new Puzzle(cells);
    Stack<Direction> history = new Stack<>();
    history.push(Direction.Down);
    history.push(Direction.Right);
    PuzzleState state = new PuzzleState(puzzle, history);
    Queue<TileMove> moves = PuzzleBoard.createSolution(state, puzzle);
    Approvals.verifyAll("Solution", moves);
  }
  @Test
  public void testSwap() throws Exception
  {
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 8, 7};
    Puzzle puzzle = new Puzzle(cells);
    PuzzleBoard board = new PuzzleBoard(puzzle, null);
    board.swap(8, 7);
    Approvals.verify(board.toString());
  }
}
