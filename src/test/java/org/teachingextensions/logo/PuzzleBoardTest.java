package org.teachingextensions.logo;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.FileLauncherReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;

@UseReporter(FileLauncherReporter.class)
public class PuzzleBoardTest {
  /**
   * A puzzle board shows the initial puzzle.
   */
  @Test
  public void show_initial_puzzle() throws Exception {
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    PuzzleBoard board = new PuzzleBoard(new Puzzle(cells), null);
    PuzzleWindow window = new PuzzleWindow();
    window.add(board);
    Approvals.verify(window);
  }

  /**
   * A puzzle board shows the provided puzzle
   */
  @Test
  public void show_provided_puzzle() throws Exception {
    int[] cells = {0, 1, 2, 3, 4, 5, 6, 8, 7};
    PuzzleBoard board = new PuzzleBoard(new Puzzle(cells), null);
    PuzzleWindow window = new PuzzleWindow(board);
    Approvals.verify(window);
  }
}
