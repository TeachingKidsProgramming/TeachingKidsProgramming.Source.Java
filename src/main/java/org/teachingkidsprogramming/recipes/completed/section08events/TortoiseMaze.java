package org.teachingkidsprogramming.recipes.completed.section08events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//***********************ANSWER: In Progress***************************//
//      Need to write English comments and copy to STUDENT section     //
//
public class TortoiseMaze
{
  public static void main(String[] args)
  {
    new TortoiseMaze();
  }
  public TortoiseMaze()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.setPenColor(PenColors.Greens.Green);
    Tortoise.setPenWidth(4);
    // add image icons
    ImageIcon leftArrow = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-left.png");
    ImageIcon upArrow = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-up.png");
    ImageIcon downArrow = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-down.png");
    ImageIcon rightArrow = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-right.png");
    // add buttons using icons
    JButton leftButton = new JButton(leftArrow);
    JButton upButton = new JButton(upArrow);
    JButton downButton = new JButton(downArrow);
    JButton rightButton = new JButton(rightArrow);
    // add buttons to your window
    Tortoise.getBackgroundWindow().addButton(leftButton);
    Tortoise.getBackgroundWindow().addButton(upButton);
    Tortoise.getBackgroundWindow().addButton(downButton);
    Tortoise.getBackgroundWindow().addButton(rightButton);
    // add actions to your buttons
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
        Tortoise.move(35);
      }
    });
    downButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        Tortoise.move(-35);
      }
    });
    Tortoise.setVisible(true);
  }
}
