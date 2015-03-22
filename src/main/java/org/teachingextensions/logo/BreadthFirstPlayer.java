package org.teachingextensions.logo;

import java.util.ArrayDeque;

/**
 * A player who solves puzzles using breadth-first search.
 */
public class BreadthFirstPlayer extends PuzzlePlayer {

  public BreadthFirstPlayer(Puzzle puzzle) {
    super(puzzle, new ArrayDeque<PuzzleState>());
  }

}
