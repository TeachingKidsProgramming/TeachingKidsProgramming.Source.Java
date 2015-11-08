package org.teachingkidsprogramming.recipes.completed.section07events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.teachingextensions.logo.ColorWheel;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.shapes.Circle;
import org.teachingextensions.windows.MouseRightClickListener;
import org.teachingextensions.windows.ProgramWindow;

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
    clearTheScreen();
    prepareColorPalette();
    ImageIcon arrowIconL = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-left.png");
    JButton leftButton = new JButton(arrowIconL);
    //    leftButton.setLocation(300, 100);
    ProgramWindow.addButton(Tortoise.getBackgroundWindow(), leftButton);
    ImageIcon arrowIconU = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-up.png");
    JButton upButton = new JButton(arrowIconU);
    //    rightButton.setLocation(300, 100);
    ProgramWindow.addButton(Tortoise.getBackgroundWindow(), upButton);
    ImageIcon arrowIconR = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-right.png");
    JButton rightButton = new JButton(arrowIconR);
    //    rightButton.setLocation(300, 100);
    ProgramWindow.addButton(Tortoise.getBackgroundWindow(), rightButton);
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
    Tortoise.getBackgroundWindow().setVisible(false);
    Tortoise.getBackgroundWindow().setVisible(true);
    //    String backGround = "/TeachingKidsProgramming.Source.Java/src/main/resources/maze.png";
    //    Tortoise.getBackgroundWindow().setBackgroundImage(backGround);
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
