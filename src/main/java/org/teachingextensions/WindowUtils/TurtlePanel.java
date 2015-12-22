package org.teachingextensions.WindowUtils;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
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
import java.util.ArrayList;

public class TurtlePanel {
  protected Animals animal = Animals.Turtle;
  protected Image        image;
  private   Turtle       turtle;
  private   TurtleWindow window;
  private   Paintable    trailPainter;
  private   Paintable    turtlePainter;

  public TurtlePanel() {
    this(null, null);
  }

  public TurtlePanel(String title) {
    this(title, null);
  }

  public TurtlePanel(String title, Turtle turtle) {
    this.window = new TurtleWindow(title);
    this.turtle = turtle;
    this.image = loadAnimal();
    configurePainters();
  }

  public void setTurtle(Turtle turtle) {
    this.turtle = turtle;
    clearPainters();
    configurePainters();
  }

  public synchronized Image getImage() {
    if (image == null) {
      setAnimal(Animals.Turtle);
    }
    return image;
  }

  public synchronized void setAnimal(Animals animal) {
    this.animal = animal;
    this.image = loadAnimal();
    clearPainters();
    configurePainters();
  }

  public void setCursor(int cursor) {
    this.window.setCursor(Cursor.getPredefinedCursor(cursor));
  }

  public void ___() {
    // blank for the DeepDive
  }

  protected void clearPainters() {
    this.window.remove(this.trailPainter)
        .remove(this.turtlePainter);
  }

  protected void configurePainters() {
    this.window.add(createTurtleTrailPainter())
        .add(createTurtlePainter());
  }

  protected Paintable createTurtleTrailPainter() {
    return this.turtlePainter = new TurtlePainter(this.turtle, this.getImage());
  }

  protected Paintable createTurtlePainter() {
    return this.trailPainter = new TurtleTrailPainter(this.turtle);
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

  protected Image loadAnimal() {
    return ObjectUtils.loadImage(MultiTurtleWindow.class, this.animal + ".png");
  }

  protected Paintable getTrailPainter() {
    return trailPainter;
  }

  protected void setTrailPainter(Paintable trailPainter) {
    this.trailPainter = trailPainter;
  }

  protected Paintable getTurtlePainter() {
    return turtlePainter;
  }

  protected void setTurtlePainter(Paintable turtlePainter) {
    this.turtlePainter = turtlePainter;
  }
}

