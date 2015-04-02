package org.teachingextensions.logo;

import java.awt.BorderLayout;

import org.teachingextensions.windows.ProgramWindow;

/**
 * A program window for a 9-puzzle
 */
public class PuzzleWindow extends ProgramWindow {
  private static final long serialVersionUID = 5190374287165209356L;

  public PuzzleWindow() {
    super("Puzzle");
    this.setLayout(new BorderLayout());
  }

  public PuzzleWindow(PuzzleBoard board) {
    this();
    this.add(board);
  }
}
