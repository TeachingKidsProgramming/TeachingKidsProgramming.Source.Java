package org.teachingkidsprogramming.recipes.completed.section00demos;

import org.teachingextensions.WindowUtils.ProgramWindow;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Diamond;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Text;

public class GermanyDemo implements MouseLeftClickListener
{
  private ProgramWindow programWindow;
  public GermanyDemo()
  {
    programWindow = new ProgramWindow("Guten Tag Berlin!");
    programWindow.setWindowVisible(true);
    programWindow.addMouseLeftClickListener(this);
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    programWindow.setBackground(PenColors.Grays.Silver);
    createFlag(x, y);
  }
  private void createFlag(int x, int y)
  {
    programWindow.clearWindow();
    Diamond diamond2 = new Diamond(200, PenColors.Reds.Crimson);
    diamond2.setCorners(x, y);
    Diamond diamond3 = new Diamond(200, PenColors.Yellows.Gold);
    diamond3.setCorners(x, y);
    diamond2.addTo(programWindow);
    diamond3.addTo(programWindow);
    Diamond diamond = new Diamond(200, PenColors.Grays.Black);
    diamond.setCorners(x, y);
    diamond.addTo(programWindow);
    new Text("Herzliche Grüße").setTopLeft(x, y).addTo(programWindow);
  }
  public static void main(String[] args)
  {
    new GermanyDemo();
  }
}