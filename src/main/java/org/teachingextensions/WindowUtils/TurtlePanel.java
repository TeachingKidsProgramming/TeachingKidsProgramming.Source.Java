package org.teachingextensions.WindowUtils;

import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.EventUtils.MouseRightClickListener;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtlePainter;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtleTrailPainter;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtleWindow;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class TurtlePanel {
  private   Turtle             turtle;
  protected Image              image;
  private   TurtleWindow       window;
  private   TurtleTrailPainter trailPainter;
  private   TurtlePainter      turtlePainter;

  public TurtlePanel() {
    this(null, null);
  }

  public TurtlePanel(String title) {
    this(title, null);
  }

  public TurtlePanel(String title, Turtle turtle) {
    this.window = new TurtleWindow(title);
    configureWindow(turtle);
    this.turtle = turtle;
  }

  public void setTurtle(Turtle turtle) {
    clearWindow();
    configureWindow(turtle);
    this.turtle = turtle;
  }

  public synchronized Image getImage() {
    if (image == null) {
      setAnimal(Animals.Turtle);
    }
    return image;
  }

  public synchronized void setAnimal(Animals animal) {
    String name = animal + ".png";
    URL resource = this.getClass().getResource(name);
    if (resource == null) {
      resource = this.getClass().getClassLoader().getResource(name);
    }
    if (resource == null) {
      throw new IllegalStateException("Could not find animal: " + name);
    }
    this.image = new ImageIcon(resource).getImage();
    clearWindow();
    configureWindow(this.turtle);
  }

  public void setCursor(int cursor) {
    this.window.setCursor(Cursor.getPredefinedCursor(cursor));
  }

  public void ___() {
    // blank for the DeepDive
  }

  protected void clearWindow() {
    this.window.remove(this.trailPainter)
        .remove(this.turtlePainter);
  }

  protected void configureWindow(Turtle turtle) {
    this.trailPainter = new TurtleTrailPainter(turtle);
    this.turtlePainter = new TurtlePainter(turtle, this.getImage());
    this.window.add(this.trailPainter)
        .add(this.turtlePainter);
  }

  public TurtleWindow getWindow() {
    return window;
  }

  public void setColor(Color color) {
    this.getWindow().setColor(color);
  }

  public void addButton(JButton leftButton) {
    this.getWindow().addButton(leftButton);
  }

  public void setBackground(Color color) {
    this.getWindow().setBackground(color);
  }

  public void addMouseLeftClickListener(MouseLeftClickListener listener) {
    this.getWindow().addMouseLeftClickListener(listener);
  }

  public void addMouseRightClickListener(MouseRightClickListener listener) {
    this.getWindow().addMouseRightClickListener(listener);
  }

  public void setBackgroundImage(String picture) {
    this.getWindow().setBackgroundImage(picture);
  }

  public ArrayList<Paintable> getAdditional() {
    return this.window.additional;
  }
}

