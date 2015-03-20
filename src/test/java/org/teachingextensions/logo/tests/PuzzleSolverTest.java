package org.teachingextensions.logo.tests;

import org.junit.Test;
import org.teachingkidsprogramming.section08tdd.PuzzleBoard;
import org.teachingkidsprogramming.section08tdd.PuzzleSolver;
import org.teachingkidsprogramming.section08tdd.Tile;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by james on 3/20/15.
 */
public class PuzzleSolverTest {
  @Test
  public void manhattanDistanceFromOneToZeroTest() {
    Point start = new Point(1, 0);
    Point end = new Point(0, 0);
    int distance = PuzzleSolver.distance(start, end);
    assertEquals(1, distance);
  }

  @Test
  public void manhattanDistanceFromTwoToZeroTest() {
    Point start = new Point(2, 0);
    Point end = new Point(0, 0);
    int distance = PuzzleSolver.distance(start, end);
    assertEquals(2, distance);
  }

  @Test
  public void manhattanDistanceFromFourToZeroTest() {
    Point start = new Point(1, 1);
    Point end = new Point(0, 0);
    int distance = PuzzleSolver.distance(start, end);
    assertEquals(2, distance);
  }

  @Test
  public void manhattanDistanceFromSixToTwoTest() {
    Point start = new Point(0, 2);
    Point end = new Point(2, 0);
    int distance = PuzzleSolver.distance(start, end);
    assertEquals(4, distance);
  }

  @Test
  public void manhattanDistanceFromEightToZeroTest() {
    Point start = new Point(2, 2);
    Point end = new Point(0, 0);
    int distance = PuzzleSolver.distance(start, end);
    assertEquals(4, distance);
  }

  @Test
  public void distanceFromSolvedToSolved() {
    PuzzleBoard solved = getSolvedPuzzle();
    assertEquals(0, PuzzleSolver.distance(solved, solved));
  }

  private PuzzleBoard getSolvedPuzzle() {
    Point[] positions = PuzzleBoard.createPositions();
    List<Tile> tiles = PuzzleBoard.createTiles(positions);
    return new PuzzleBoard(positions, tiles);
  }

  @Test
  public void distanceForPuzzleWithOneMisplacedTile() {
    Point[] positions = PuzzleBoard.createPositions();

    // swap 7 and 8
    Point p = positions[8];
    positions[8] = positions[7];
    positions[7] = p;

    List<Tile> tiles = PuzzleBoard.createTiles(positions);
    PuzzleBoard b = new PuzzleBoard(PuzzleBoard.createPositions(), tiles);
    int expected = PuzzleSolver.distance(positions[8], positions[7]);
    assertEquals(expected, PuzzleSolver.distance(b, getSolvedPuzzle()));
  }
}
