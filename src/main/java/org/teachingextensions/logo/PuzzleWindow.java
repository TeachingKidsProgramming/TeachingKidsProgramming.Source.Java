package org.teachingextensions.logo;

import org.teachingextensions.windows.ProgramWindow;

import java.awt.*;

/**
 * A program window for a 9-puzzle
 */
public class PuzzleWindow extends ProgramWindow {
  public PuzzleWindow() {
    super("Puzzle");
    this.setLayout(new BorderLayout());
  }

  public PuzzleWindow(PuzzleBoard board) {
    this();
    this.add(board);
  }
}
