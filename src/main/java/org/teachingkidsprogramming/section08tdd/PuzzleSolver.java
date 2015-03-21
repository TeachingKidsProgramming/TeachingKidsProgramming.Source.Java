package org.teachingkidsprogramming.section08tdd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver implements Runnable {
  private final PuzzleBoard board;

  public PuzzleSolver(PuzzleBoard board) {
    this.board = board;
  }

  @Override
  public void run() {
    final PuzzleBoard b = this.board;

    while (b.isVisible()) {
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          b.repaint();
        }
      });

      update(b);

      try {
        Thread.sleep(10);
      } catch (InterruptedException ignored) {
      }
    }
  }

  private void update(final PuzzleBoard puzzle) {

    boolean done = animate(puzzle);
    if (!done) {
      return;
    }

    if (puzzle.isSorted()) {
      puzzle.finish();
      return;
    }

    solve(puzzle);
  }

  private void solve(PuzzleBoard puzzle) {

    int minimumCost = Integer.MAX_VALUE;
    TileMove min = null;
    // create a list of all moves that are possible
    List<TileMove> moves = createMoves();
    for (TileMove tileMove : moves) {
      // discard if the move is invalid from this state
      if (!puzzle.isValidMove(tileMove)) {
        continue;
      }

      // otherwise apply the move to generate a new board
      PuzzleBoard next = puzzle.useMove(tileMove);

      // see if we have visited this board before:
      if (next.isVisited()){
        continue;
      }

      // estimate the cost to reach the goal by going through the new board
      int estimate = estimateCost(next);

      // if the cost is the smallest we've seen so far
      if (estimate < minimumCost) {
        // remember the move and the cost
        minimumCost = estimate;
        min = tileMove;
      }

    }

    // execute the remembered move:
    // tell the piece to move to the target
    if (min != null) {
      Point target = puzzle.getPositions().get(min.getTarget());
      Tile piece = puzzle.getPieceFromPosition(min.getSource());
      if (!piece.isMovingTo(target)) {
        piece.moveTo(target);
      }
    }
  }

  // 0: can move down (to #3) or right (to #1)
  // 1: can move left (to #0), down (to #4), or right (to #2)
  // 2: can move left (to #1) or down (to #5)
  // 3: can move up (to #0), right (to #4), or down (to #6)
  // 4: can move up (to #1), right (to #5), down (to #7) or left (to #3)
  // 5: can move up (to #2), down (to #8), or left (to #4)
  // 6: can move up (to #3) or right (to #7)
  // 7: can move up (to #4), right (to #8) or left (to #6)
  // 8: can move up (to #5) or left (to #7)
  private List<TileMove> createMoves() {
    List<TileMove> moves = new ArrayList<>();
    moves.add(new TileMove(0, 3));
    moves.add(new TileMove(0, 1));
    moves.add(new TileMove(1, 0));
    moves.add(new TileMove(1, 4));
    moves.add(new TileMove(1, 2));
    moves.add(new TileMove(2, 1));
    moves.add(new TileMove(2, 5));
    moves.add(new TileMove(3, 0));
    moves.add(new TileMove(3, 4));
    moves.add(new TileMove(3, 6));
    moves.add(new TileMove(4, 1));
    moves.add(new TileMove(4, 5));
    moves.add(new TileMove(4, 7));
    moves.add(new TileMove(4, 3));
    moves.add(new TileMove(5, 2));
    moves.add(new TileMove(5, 8));
    moves.add(new TileMove(5, 4));
    moves.add(new TileMove(6, 3));
    moves.add(new TileMove(6, 7));
    moves.add(new TileMove(7, 4));
    moves.add(new TileMove(7, 8));
    moves.add(new TileMove(7, 6));
    moves.add(new TileMove(8, 5));
    moves.add(new TileMove(8, 7));
    return moves;
  }

  private boolean animate(PuzzleBoard puzzle) {
    List<Tile> tiles = puzzle.getTiles();
    for (Tile tile : tiles) {
      if (!tile.isAtTarget()) {
        tile.step();
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings("UnusedDeclaration")
  private static void animationDemo(final PuzzleBoard puzzle) {
    Point target = puzzle.getPositions().get(8);
    Tile piece = puzzle.getPiece(7);
    if (!piece.isMovingTo(target)) {
      piece.moveTo(target);
    }
    if (!piece.isAt(target)) {
      piece.step();
    }
  }

  public static int distance(Point start, Point end) {
    return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
  }

  public static int estimateRemainingMoves(PuzzleBoard start) {
    int result = 0;
    for (Tile tile : start.getTiles()) {
      int goalIndex = tile.getCorrectPositionIndex();
      Point goal = start.getPositions().get(goalIndex);
      Point position = tile.getPosition();
      result += distance(position, goal);
    }
    return result;
  }

  public static int estimateCost(PuzzleBoard board) {
    // The cost of this solving the puzzle using this is at least the number of moves it took to get to this
    // board
    int cost = board.getHistory().size();

    // We estimate that the cost of solving the puzzle from here will be related to the number of moves needed
    // to get the tiles into the right positions, so we add the estimate to the actual cost
    cost += estimateRemainingMoves(board);

    return cost;
  }
}