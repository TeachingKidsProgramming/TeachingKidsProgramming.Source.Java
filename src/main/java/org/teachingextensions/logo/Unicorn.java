package org.teachingextensions.logo;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.windows.ProgramWindow;

public class Unicorn implements Paintable
{
  private int       x;
  private int       y;
  private Image     image;
  private int       scale;
  private Dimension dimension = new Dimension(10, 10);
  public Unicorn(int x, int y, int scale)
  {
    this.x = x;
    this.y = y;
    this.scale = scale / 10;
    this.image = getImage();
  }
  private static Image getImage()
  {
    return ObjectUtils.loadImage(Tile.class, Animals.Unicorn + ".png");
  }
  public void addTo(ProgramWindow programWindow)
  {
    programWindow.addPaintable(this);
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    g.drawImage(this.image, this.x, this.y, this.dimension.width * scale, this.dimension.height * scale, null);
  }
}
