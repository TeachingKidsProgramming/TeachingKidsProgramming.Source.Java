package org.teachingkidsprogramming.section08tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

public class PuzzleBoardTest {

  @Test
  public void defaultNotSortedTest() {
    PuzzleBoard b = new PuzzleBoard();
    assertTrue(!b.isSorted());
  }

  @Test
  public void notSortedTest() {
    List<Point> positions = PuzzleBoard.createPositions();
    List<Tile> tiles = PuzzleBoard.createTiles(positions);

    Tile t = tiles.get(7);
    t.moveTo(positions.get(8));
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
    List<Point> positions = PuzzleBoard.createPositions();
    List<Tile> tiles = PuzzleBoard.createTiles(positions);

    PuzzleBoard b = new PuzzleBoard(positions, tiles);
    return b;
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
