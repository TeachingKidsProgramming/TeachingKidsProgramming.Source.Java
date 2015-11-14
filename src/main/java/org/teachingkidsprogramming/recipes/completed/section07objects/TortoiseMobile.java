package org.teachingkidsprogramming.recipes.completed.section07objects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.MouseRightClickListener;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Circle;

//***********************In Progress***************************//
public class TortoiseMobile implements MouseRightClickListener
{
  public static void main(String[] args)
  {
    new TortoiseMobile();
  }
  public TortoiseMobile()
  {
    Tortoise.getBackgroundWindow().addMouseRightClickListener(this);
    Tortoise.setSpeed(10);
    Tortoise.setPenColor(PenColors.Greens.Green);
    Tortoise.setPenWidth(4);
    clearTheScreen();
    prepareColorPalette();
    ImageIcon arrowIconL = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-left.png");
    JButton leftButton = new JButton(arrowIconL);
    Tortoise.getBackgroundWindow().addButton(leftButton);
    ImageIcon arrowIconU = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-up.png");
    JButton upButton = new JButton(arrowIconU);
    Tortoise.getBackgroundWindow().addButton(upButton);
    ImageIcon arrowIconR = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-right.png");
    JButton rightButton = new JButton(arrowIconR);
    Tortoise.getBackgroundWindow().addButton(rightButton);
    rightButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        Tortoise.turn(90);
      }
    });
    leftButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        Tortoise.turn(-90);
      }
    });
    upButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        Tortoise.move(25);
      }
    });
    Tortoise.setVisible(true);
  }
  private static void prepareColorPalette()
  {
    ColorWheel.addColor(PenColors.Reds.Red);
    ColorWheel.addColor(PenColors.Greens.Green);
    ColorWheel.addColor(PenColors.Blues.Blue);
    ColorWheel.addColor(PenColors.Purples.Purple);
    ColorWheel.addColor(PenColors.Pinks.Pink);
    ColorWheel.addColor(PenColors.Greens.Teal);
  }
  private void addDot(int x, int y)
  {
    addCircle(x, y);
    Tortoise.moveTo(x, y);
  }
  private void addCircle(int x, int y)
  {
    int radius = 7;
    Color color = ColorWheel.getNextColor();
    Circle circle = new Circle(radius, color);
    circle.setTransparency(60);
    circle.setCenter(x, y);
    circle.addTo(Tortoise.getBackgroundWindow());
  }
  private static void clearTheScreen()
  {
    Tortoise.clear();
  }
  @Override
  public void onRightMouseClick(int x, int y)
  {
    clearTheScreen();
  }
}
