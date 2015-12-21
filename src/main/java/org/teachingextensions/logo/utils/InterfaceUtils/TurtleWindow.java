package org.teachingextensions.logo.utils.InterfaceUtils;

import org.teachingextensions.WindowUtils.ProgramWindow;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;

import java.awt.*;
import java.util.ArrayList;

public class TurtleWindow extends ProgramWindow {
  private final ArrayList<Paintable> paintables = new ArrayList<Paintable>();

  public TurtleWindow(String string) {
    super(string);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    for (Paintable p : paintables) {
      p.paint(g2d, this);
    }
  }

  public TurtleWindow add(Paintable painter) {
    if (!this.paintables.contains(painter)) {
      this.paintables.add(painter);
    }

    return this;
  }

  public TurtleWindow remove(Paintable painter) {
    if (this.paintables.contains(painter)) {
      this.paintables.remove(painter);
    }

    return this;
  }
}
