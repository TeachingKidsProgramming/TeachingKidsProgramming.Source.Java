package org.teachingextensions.logo;

/**
 * Represents a node in the puzzle-solving graph.  Keeps track of the current puzzle arrangement and the actions
 * required to arrive at the current arrangement from the starting arrangement.
 */
public class PuzzleState {
  public enum Directions {
    Left(-1), Right(1), Up(-3), Down(3);

    private final int value;

    private Directions(int i) {
      this.value = i;
    }

    public int getValue() {
      return value;
    }

    @Override
    public String toString() {
      return "{" + super.toString() + " = " + value + '}';
    }
  }
}
