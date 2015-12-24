package org.teachingextensions.WindowUtils;

import org.teachingextensions.approvals.lite.util.FrameCloser;
import org.teachingextensions.approvals.lite.util.WindowUtils;
import org.teachingextensions.approvals.lite.writers.ComponentApprovalWriter;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.LeftClickMouseAdapter;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.EventUtils.MouseRightClickListener;
import org.teachingextensions.logo.utils.EventUtils.RightClickMouseAdapter;
import org.teachingextensions.logo.utils.InterfaceUtils.CanvasPanel;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtleFrame;
import org.teachingextensions.logo.utils.LineAndShapeUtils.ImageBackground;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;
import org.teachingextensions.virtualproctor.VirtualProctorWeb;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * <img src="http://ftpmirror.your.org/pub/wikimedia/images/wikibooks/de/2/2c/JPanel_Add_JButton_PAGE_END.JPG" style="text-align: left" alt="A window image" height="50" width="75" > Program Window
 * allows you to change the color of the background and more...
 */
public class ProgramWindow {
  private final CanvasPanel panel = new CanvasPanel();
  private JFrame frame;

  public ProgramWindow(String title) {
    this();
    this.frame = new JFrame(title);
    this.frame.getContentPane().add(this.panel);
    ProgramWindow.createStandardFrame(getFrame());
  }

  public ProgramWindow() {
    this.panel.setPreferredSize(new Dimension(627, 442));
    setColor(PenColors.Whites.White);
  }

  public static void createStandardFrame(JFrame frame) {
    WindowUtils.testFrame(frame, new VirtualProctorWeb(), new FrameCloser());
  }


  /**
   * Adds a button instance to a window
   * <p><b>Example:</b> {@code programWindow.addButton(myButton)}</p>
   *
   * @param button
   *     A button instance
   */
  public void addButton(JButton button) {
    this.panel.add(button);
  }


  public void setColor(Color backgroundColor) {
    this.panel.setBackground(backgroundColor);
  }

  @Deprecated
  public ProgramWindow clearWindow() {
    this.panel.clear();
    return this;
  }

  /**
   * Adds a right mouse click listener instance to a window
   * <p><b>Example:</b> {@code programWindow.addMouseRightClickListener(myRightClickListener)}</p>
   *
   * @param listener
   *     A listener instance
   */
  public void addMouseRightClickListener(MouseRightClickListener listener) {
    this.panel.addMouseListener(new RightClickMouseAdapter(listener));
  }

  /**
   * Adds a left mouse click listener instance to a window
   * <p><b>Example:</b> {@code programWindow.addMouseLeftClickListener(myLeftClickListener)}</p>
   *
   * @param listener
   *     A listener instance
   */
  public void addMouseLeftClickListener(MouseLeftClickListener listener) {
    this.panel.addMouseListener(new LeftClickMouseAdapter(listener));
  }

  /**
   * Adds a background image to a window
   * <p><b>Example:</b> {@code programWindow.setBackgroundImage("http://www.coolpicture.com/sunshine.jpg")}</p>
   *
   * @param url
   *     A URL path to an image
   */
  public void setBackgroundImage(String url) {
    add(new ImageBackground(url));
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setWindowVisible(boolean b) {
    this.frame.setVisible(b);
    this.panel.setVisible(b);
  }

  @Deprecated
  public ProgramWindow add(Paintable painter) {
    this.panel.add(painter);
    return this;
  }

  @Deprecated
  public ProgramWindow remove(Paintable painter) {
    this.panel.remove(painter);
    return this;
  }


  public final BufferedImage getWindowImage() {
    return ComponentApprovalWriter.drawComponent(this.panel);
  }

  public ProgramWindow addTo(TurtleFrame frame) {
    frame.addContent(this.panel);
    return this;
  }

  public ProgramWindow repaint() {
    this.panel.repaint();
    return this;
  }

  public ProgramWindow setVisible(boolean visible) {
    this.panel.setVisible(visible);
    return this;
  }

  public ProgramWindow setCursor(int cursor) {
    this.setCursor(Cursor.getPredefinedCursor(cursor));
    return this;
  }

  public ProgramWindow setCursor(Cursor predefinedCursor) {
    this.panel.setCursor(predefinedCursor);
    return this;
  }

  public CanvasPanel getCanvas() {
    return this.panel;
  }

  public ProgramWindow setBackground(Color color) {
    this.panel.setBackground(color);
    return this;
  }
}

