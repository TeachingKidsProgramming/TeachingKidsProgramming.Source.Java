package org.teachingkidsprogramming.section08tdd;

public class TileMove {

  private final int source;
  private final int target;

  public TileMove(int source, int target) {
    this.source = source;
    this.target = target;
  }

  public int getSource() {
    return this.source;
  }

  public int getTarget() {
    return this.target;
  }

}
