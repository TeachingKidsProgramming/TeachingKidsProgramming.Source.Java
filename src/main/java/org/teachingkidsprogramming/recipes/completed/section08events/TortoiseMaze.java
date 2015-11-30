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
    Tortoise.setSpeed(10);
    Tortoise.setPenColor(PenColors.Greens.Green);
    Tortoise.setPenWidth(4);
    ImageIcon leftArrow = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-left.png");
    JButton leftButton = new JButton(leftArrow);
    Tortoise.getBackgroundWindow().addButton(leftButton);
    ImageIcon upArrow = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-up.png");
    JButton upButton = new JButton(upArrow);
    Tortoise.getBackgroundWindow().addButton(upButton);
    ImageIcon rightArrow = new ImageIcon(
        "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/arrow-right.png");
    JButton rightButton = new JButton(rightArrow);
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
}
