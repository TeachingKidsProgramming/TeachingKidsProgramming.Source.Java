package org.teachingextensions.logo.utils.PuzzleUtils;

import java.awt.BorderLayout;

import org.teachingextensions.WindowUtils.ProgramWindow;

/**
 * A program window for a 9-puzzle
 */
public class PuzzleWindow extends ProgramWindow
{
  private static final long serialVersionUID = 5190374287165209356L;
  public PuzzleWindow()
  {
    super("Puzzle");
    this.setLayout(new BorderLayout());
  }
  public PuzzleWindow(PuzzleBoard board)
  {
    this();
    this.add(board);
  }
}
