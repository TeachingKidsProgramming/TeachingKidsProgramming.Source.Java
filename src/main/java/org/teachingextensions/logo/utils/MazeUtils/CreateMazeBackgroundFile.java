package org.teachingextensions.logo.utils.MazeUtils;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    StdDraw.frame.dispatchEvent(new WindowEvent(StdDraw.frame, WindowEvent.WINDOW_CLOSING));
  }
  @Override
  // TODO Verify the event firing and image creation
  public void windowClosing(WindowEvent event)
  {
    BufferedImage scaled = ScreenCapture.getScaledImageOf(event.getComponent(), 350, 350);
    System.out.println("did it?");
    sendImageToDisk(scaled);
  }
  public static BufferedImage getImageOf(Component component, int width, int height)
  {
    BufferedImage image = ComponentApprovalWriter.drawComponent(component);
    return image;
  }
  public void sendImageToDisk(BufferedImage image)
  {
    try
    {
      //String filename = "C:\\temp\\CoolMazeBackground.png";
      String filename = "./CoolMazeBackground.png";
      ImageIO.write(image, "png", new File(filename));
      TestUtils.displayFile(filename);
    }
    catch (Exception e)
    {
      MySystem.warning(e);
    }
  }
  // TODO: set this image as a background image for the TortoiseMaze recipe
}
