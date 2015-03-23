package org.teachingextensions.logo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Draws and animates a 9-puzzle
 */
public class PuzzleBoard extends JPanel {
  private final static int blank = 8;
  private final Tile[]          tiles;
  private final Queue<TileMove> solution;

  public PuzzleBoard(Puzzle puzzle, PuzzleState solution) {
    super();
    this.solution = createSolution(solution, puzzle);
    this.tiles = createTiles(puzzle.getCells());
  }

  private static Queue<TileMove> createSolution(PuzzleState solution, Puzzle puzzle) {
    if (solution == null) {
      return new ArrayDeque<>();
    }

    int i = puzzle.getBlankIndex();
    Queue<TileMove> moves = new ArrayDeque<>();
    for (PuzzleState.Direction d : solution.getHistory()) {
      int m = d.getValue();
      TileMove move = new TileMove(i + m, i);
      moves.add(move);
      i = move.getStart();
    }
    return moves;
  }

  private static Tile[] createTiles(int[] cells) {
    Tile[] t = new Tile[9];
    for (int i = 0; i < 9; i++) {
      if (cells[i] == blank) {
        continue;
      }

      t[i] = new Tile(i, cells[i]);
    }
    return t;
  }

  private static void drawBorder(Graphics g) {
    g.setColor(PenColors.Blues.DarkBlue);
    g.fillRect(20, 20, 410, 410);
  }

  private static void drawField(Graphics g) {
    g.setColor(PenColors.Blues.SkyBlue);
    g.fillRect(30, 30, 386, 386);
  }

  private static void drawTiles(Graphics g, Tile[] tiles) {
    Graphics2D g2d = (Graphics2D) g.create();
    for (Tile tile : tiles) {
      if (tile == null) {
        continue;
      }
      tile.paint(g2d);
    }
    g2d.dispose();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawBorder(g);
    drawField(g);
    drawTiles(g, tiles);
  }

  public Tile[] getTiles() {
    return Arrays.copyOf(tiles, tiles.length);
  }

  public boolean hasMoves() {
    return !solution.isEmpty();
  }

  public TileMove getNextMove() {
    return solution.isEmpty() ? null : solution.remove();
  }

  public void swap(int start, int end) {
    Point p = Tile.getPosition(end);
    Tile tile = tiles[start];
    tile.moveTo(p);
    tiles[start] = null;
    tiles[end] = tile;

  }
}
