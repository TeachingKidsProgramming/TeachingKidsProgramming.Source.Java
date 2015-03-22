package org.teachingextensions.logo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PuzzleTest {
  private static int[] getSolution() {
    return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
  }

  private static int[] swap(int[] cells, int i, int j) {
    int[] copy = Arrays.copyOf(cells, cells.length);
    int x = copy[i];
    copy[i] = copy[j];
    copy[j] = x;
    return copy;
  }

  /**
   * A puzzle has a solution
   */
  @Test
  public void puzzle_has_solution() {
    int[] solved = getSolution();
    Puzzle p = new Puzzle(solved);
    assertTrue(p.isSolved());
  }

  /**
   * A puzzle might not be solved
   */
  @Test
  public void puzzle_not_solved() {
    int[] cells = getSolution();
    cells = swap(cells, 3, 4);
    Puzzle p = new Puzzle(cells);
    assertFalse(p.isSolved());
  }

  /**
   * A puzzle has a blank
   */
  @Test
  public void puzzle_has_blank() {
    Puzzle p = new Puzzle(getSolution());
    assertEquals(8, p.getBlankIndex());
  }

  /**
   * Blank can be anywhere
   */
  @Test
  public void blank_can_be_anywhere() {
    int[] cells = swap(getSolution(), 8, 2);
    Puzzle p = new Puzzle(cells);
    assertEquals(2, p.getBlankIndex());
  }

  /**
   * Puzzle can swap blank for you
   */
  @Test
  public void puzzle_can_swap_blank() {
    Puzzle p = new Puzzle(getSolution());
    Puzzle c = p.swapBlank(4);
    assertEquals(4, c.getBlankIndex());
  }

  /**
   * Puzzle can swap blank for you
   */
  @Test
  public void blank_swap_leaves_original_as_is() {
    Puzzle p = new Puzzle(getSolution());
    p.swapBlank(4);
    assertEquals(8, p.getBlankIndex());
  }

  /**
   * Puzzle is not equal to a puzzle with different cells.
   */
  @Test
  public void different_cells_means_different_puzzle() {
    Puzzle a = new Puzzle(getSolution());
    Puzzle b = new Puzzle(swap(getSolution(), 8, 2));
    assertNotEquals(a, b);
  }

  /**
   * Puzzle is equal to a puzzle with the same cells.
   */
  @Test
  public void same_cells_means_same_puzzle() {
    Puzzle a = new Puzzle(swap(getSolution(), 8, 3));
    Puzzle b = new Puzzle(swap(getSolution(), 8, 3));
    assertEquals(a, b);
  }

}
