package org.teachingextensions.logo;

import java.util.Arrays;

/**
 * A nine-puzzle
 *
 * @see <a href="http://en.wikipedia.org/wiki/15_puzzle">Wikipedia</a>
 */
public class Puzzle {
  private static final int[] solution = {0, 1, 2, 3, 4, 5, 6, 7, 8};
  private static final int   blank    = 8;
  private final int[] cells;

  public Puzzle(int[] cells) {
    this.cells = cells;
  }

  public boolean isSolved() {
    for (int i = 0; i < solution.length; i++) {
      if (solution[i] != cells[i]) {
        return false;
      }
    }
    return true;
  }

  public int getBlankIndex() {
    for (int i = 0; i < cells.length; i++) {
      if (cells[i] == blank) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Create a copy of the puzzle where the blank swapped with the value in the target position
   * @param target move the blank to this location, and move the value from this location to the current blank location
   * @return A copy of the puzzle with the blank and target swapped.
   */
  public Puzzle swapBlank(int target) {
    int[] copy = Arrays.copyOf(cells, cells.length);
    int x = copy[target];
    copy[getBlankIndex()] = x;
    copy[target] = 8;
    return new Puzzle(copy);
  }
}
