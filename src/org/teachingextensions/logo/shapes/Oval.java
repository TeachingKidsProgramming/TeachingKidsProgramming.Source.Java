package org.teachingextensions.logo.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.windows.ProgramWindow;

public class Oval implements Paintable
{
  private final int   radius;
  private final Color mainColor;
  private int         x;
  private int         y;
  private int         percentTransparent;
  public Oval(int radius, Color color)
  {
    this.radius = radius;
    this.mainColor = color;
  }
  public void setCenter(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public void addTo(ProgramWindow panel)
  {
    panel.addPaintable(this);
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    Color color2 = PenColors.getTransparentVersion(mainColor, percentTransparent);
    g.setColor(color2);
    //need to incorporate radius, x, y
    g.drawOval(x + 320, y - 20, radius + 250, radius + 140);
    g.fillOval(75, 140, 250, 400);
  }
  public void setTransparency(int percentTransparent)
  {
    this.percentTransparent = percentTransparent;
  }
}
