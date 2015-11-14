package org.teachingextensions.logo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.reporters.macosx.BeyondCompareReporter;
import org.teachingextensions.logo.utils.PuzzleUtils.Puzzle;

@UseReporter(BeyondCompareReporter.class)
public class PuzzleTest
{
  private static int[] getSolution()
  {
    return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
  }
  private static int[] swap(int[] cells, int i, int j)
  {
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
  public void puzzle_has_solution()
  {
    int[] solved = getSolution();
    Puzzle p = new Puzzle(solved);
    assertTrue(p.isSolved());
  }
  /**
   * A puzzle might not be solved
   */
  @Test
  public void puzzle_not_solved()
  {
    int[] cells = getSolution();
    cells = swap(cells, 3, 4);
    Puzzle p = new Puzzle(cells);
    assertFalse(p.isSolved());
  }
  /**
   * A puzzle has a blank
   */
  @Test
  public void puzzle_has_blank()
  {
    Puzzle p = new Puzzle(getSolution());
    assertEquals(8, p.getBlankIndex());
  }
  /**
   * Blank can be anywhere
   */
  @Test
  public void blank_can_be_anywhere()
  {
    int[] cells = swap(getSolution(), 8, 2);
    Puzzle p = new Puzzle(cells);
    assertEquals(2, p.getBlankIndex());
  }
  /**
   * Puzzle can swap blank for you
   */
  @Test
  public void puzzle_can_swap_blank()
  {
    Puzzle p = new Puzzle(getSolution());
    Puzzle c = p.swapBlank(4);
    assertEquals(4, c.getBlankIndex());
  }
  /**
   * Puzzle can swap blank for you
   */
  @Test
  public void blank_swap_leaves_original_as_is()
  {
    Puzzle p = new Puzzle(getSolution());
    p.swapBlank(4);
    assertEquals(8, p.getBlankIndex());
  }
  /**
   * Puzzle is not equal to a puzzle with different cells.
   */
  @Test
  public void different_cells_means_different_puzzle()
  {
    Puzzle a = new Puzzle(getSolution());
    Puzzle b = new Puzzle(swap(getSolution(), 8, 2));
    assertNotEquals(a, b);
  }
  /**
   * Puzzle is equal to a puzzle with the same cells.
   */
  @Test
  public void same_cells_means_same_puzzle()
  {
    Puzzle a = new Puzzle(swap(getSolution(), 8, 3));
    Puzzle b = new Puzzle(swap(getSolution(), 8, 3));
    assertEquals(a, b);
  }
  /**
   * Puzzle can tell you the game coordinates of a cell
   */
  @Test
  public void get_coordinates_for_cell() throws Exception
  {
    ArrayList<Point> positions = new ArrayList<>();
    positions.add(Puzzle.getPosition(0));
    positions.add(Puzzle.getPosition(4));
    positions.add(Puzzle.getPosition(8));
    positions.add(Puzzle.getPosition(1));
    Approvals.verifyAll("Positions", positions);
  }
  /**
   * Puzzle can tell you the distance between two coordinates
   */
  @Test
  public void get_distances_between_positions()
  {
    Point[] positions = new Point[4];
    positions[0] = Puzzle.getPosition(0);
    positions[1] = Puzzle.getPosition(4);
    positions[2] = Puzzle.getPosition(8);
    positions[3] = Puzzle.getPosition(1);
    ArrayList<Integer> distances = new ArrayList<>();
    distances.add(Puzzle.getDistance(positions[0], positions[1]));
    distances.add(Puzzle.getDistance(positions[0], positions[2]));
    distances.add(Puzzle.getDistance(positions[1], positions[3]));
    distances.add(Puzzle.getDistance(positions[3], positions[2]));
    Approvals.verifyAll("Distances", distances);
  }
  /**
   * Puzzle can automatically convert cells to positions for you
   */
  @Test
  public void get_distances_between_cells()
  {
    ArrayList<Integer> distances = new ArrayList<>();
    distances.add(Puzzle.getDistance(0, 4));
    distances.add(Puzzle.getDistance(0, 8));
    distances.add(Puzzle.getDistance(4, 1));
    distances.add(Puzzle.getDistance(1, 8));
    Approvals.verifyAll("Distances", distances);
  }
  /**
   * Solved puzzle is at the goal.
   */
  @Test
  public void distance_to_solution_is_zero_when_solved()
  {
    Puzzle p = new Puzzle(getSolution());
    assertEquals(0, p.getDistanceToGoal());
  }
  /**
   * Unsolved puzzle is the sum of the distances for each cell
   */
  @Test
  public void sum_of_cell_distances_is_distance_to_goal()
  {
    int[] cells = swap(getSolution(), 7, 8);
    cells = swap(cells, 8, 5);
    Puzzle p = new Puzzle(cells);
    assertEquals(4, p.getDistanceToGoal());
  }
}
