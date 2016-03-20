package org.teachingextensions.logo.utils.MazeUtils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.teachingextensions.approvals.lite.util.MySystem;
import org.teachingextensions.approvals.lite.util.TestUtils;
import org.teachingextensions.approvals.lite.writers.ComponentApprovalWriter;
import org.teachingextensions.virtualproctor.ScreenCapture;

/*****in progress****/
public class CreateMazeBackgroundFile extends WindowAdapter
{
  public static void main(String[] args)
  {
    CoolMaze maze1 = new CoolMaze(8);
    maze1.drawWallsAndEndPoint();
    closeTheWindow();
  }
  private static void closeTheWindow()
  {
    // TODO Remove this print line
    System.out.println(StdDraw.frame.getWindowListeners().toString());
    System.out.println(StdDraw.frame.getWindowStateListeners().toString());
    StdDraw.frame.dispatchEvent(new WindowEvent(StdDraw.frame, WindowEvent.WINDOW_CLOSING));
    return;
  }
  WindowStateListener adapter = new WindowStateListener()
  {
    @Override
    public void windowStateChanged(WindowEvent e)
    {
      StdDraw.frame.addWindowStateListener(adapter);
    }
  };
  @Override
  // TODO Verify the event firing and image creation
  public void windowClosing(WindowEvent event)
  {
    BufferedImage scaledMazeBackground = ScreenCapture.getScaledImageOf(event.getComponent(), 350, 350);
    System.out.println("did it?");
    sendImageToDisk(scaledMazeBackground);
  }
  public static BufferedImage getImageOf(Component component, int width, int height)
  {
    BufferedImage image = ComponentApprovalWriter.drawComponent(component);
    return image;
  }
  @SuppressWarnings("null")
  public void sendImageToDisk(BufferedImage scaledMazeBackground)
  {
    try
    {
      Component c = null;
      Graphics g = scaledMazeBackground.createGraphics();
      c.paint(g);
      g.dispose();
      //String filename = "C:\\temp\\CoolMazeBackground.png";
      String filename = "./CoolMazeBackground.png";
      ImageIO.write(scaledMazeBackground, "png", new File(filename));
      TestUtils.displayFile(filename);
    }
    catch (Exception e)
    {
      MySystem.warning(e);
    }
  }
  // TODO: set this image as a background image for the TortoiseMaze recipe
}
