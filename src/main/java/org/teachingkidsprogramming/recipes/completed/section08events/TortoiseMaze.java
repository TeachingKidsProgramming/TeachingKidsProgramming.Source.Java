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
    setUpTortoise();
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
    JButton leftButton = new JButton("left", leftArrow);
    JButton upButton = new JButton("forward", upArrow);
    JButton downButton = new JButton("back", downArrow);
    JButton rightButton = new JButton("right", rightArrow);
    // add button(s) to your window
    addButtonToWindow(leftButton);
    addButtonToWindow(upButton);
    addButtonToWindow(downButton);
    addButtonToWindow(rightButton);
    // add action(s) to your buttons
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
  /*  setup code */
  private void setUpTortoise()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.setPenColor(PenColors.Greens.Green);
    Tortoise.setPenWidth(4);
  }
  private void addButtonToWindow(JButton button)
  {
    Tortoise.getBackgroundWindow().addButton(button);
  }
}
