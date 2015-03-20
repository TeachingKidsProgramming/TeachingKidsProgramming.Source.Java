package org.teachingextensions.logo.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;
import org.teachingkidsprogramming.section08tdd.PuzzleBoard;
import org.teachingkidsprogramming.section08tdd.Tile;
import org.teachingkidsprogramming.section08tdd.TileMove;

public class PuzzleBoardTest {

  @Test
  public void defaultNotSortedTest() {
    PuzzleBoard b = new PuzzleBoard();
    assertTrue(!b.isSorted());
  }

  @Test
  public void notSortedTest() {
    Point[] positions = PuzzleBoard.createPositions();
    List<Tile> tiles = PuzzleBoard.createTiles(positions);

    Tile t = tiles.get(7);
    t.moveTo(positions[8]);
    t.teleport();

    PuzzleBoard b = new PuzzleBoard(positions, tiles);
    assertTrue(!b.isSorted());
  }

  @Test
  public void sortedTest() {
    PuzzleBoard b = getSolvedBoard();
    assertTrue(b.isSorted());
  }

  private PuzzleBoard getSolvedBoard() {
    Point[] positions = PuzzleBoard.createPositions();
    List<Tile> tiles = PuzzleBoard.createTiles(positions);

    return new PuzzleBoard(positions, tiles);
  }

  @Test
  public void validMoveTest() {
    PuzzleBoard b = getSolvedBoard();
    TileMove move = new TileMove(7, 8);
    assertTrue(b.isValidMove(move));
  }

  @Test
  public void invalidMoveTest() {
    PuzzleBoard b = getSolvedBoard();
    TileMove move = new TileMove(0, 1);
    assertFalse(b.isValidMove(move));
  }

}
