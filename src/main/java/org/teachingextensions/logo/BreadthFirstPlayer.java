package org.teachingextensions.logo;

import java.util.*;

/**
 * A player who solves puzzles using breadth-first search.
 */
public class BreadthFirstPlayer {
  private final Puzzle puzzle;
  private final Set<PuzzleState>  visited  = new HashSet<>();
  private final Queue<PuzzleState> frontier = new ArrayDeque<>();

  public BreadthFirstPlayer(Puzzle puzzle) {

    this.puzzle = puzzle;
  }

  public PuzzleState solve() {
    PuzzleState state = new PuzzleState(this.puzzle);
    do {
      visited.add(state);
      if (!state.isSolution()){
        this.search(state);
      }
      state = frontier.remove();
    } while (!state.isSolution());

    return state;
  }

  private void search(PuzzleState state) {
    List<PuzzleState> branches = state.getBranches();
    for(PuzzleState b : branches){
      if (!visited.contains(b)){
        frontier.add(b);
      }
    }
  }
}
