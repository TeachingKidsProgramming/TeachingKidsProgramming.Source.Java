package org.teachingextensions.approvals.lite.util.io.tests;

import java.io.File;

import org.teachingextensions.approvals.lite.util.io.FileMonitor;
import junit.framework.TestCase;
import org.teachingextensions.approvals.lite.util.io.FileMonitor.FileListener;

public class FileMonitorTest extends TestCase
{
  FileMonitor monitor;
  File        root;
  boolean     done;
  protected void setUp() throws Exception
  {
    File filea = File.createTempFile("tmp", "tmp");
    root = new File(filea.getParent() + File.separator + "fileMonitorRoot");
    root.mkdir();
    filea.delete();
    monitor = new FileMonitor(100);
    monitor.addFile(root);
    monitor.addListener(this.new TestListener());
    Thread.sleep(1000);
  }
  protected void tearDown() throws Exception
  {
    monitor.stop();
    root.delete();
  }
  public void testNewFileDetected() throws Exception
  {
    done = false;
    File targetFile = File.createTempFile("tmp", ".dbf", root);
    for (int i = 0; i < 100 && !done; i++)
    {
      Thread.sleep(1000);
    }
    try
    {
      assertEquals("File processed", true, done);
    }
    finally
    {
      targetFile.delete();
    }
  }
  private class TestListener implements FileListener
  {
    public void fileChanged(File file)
    {
      done = true;
    }
  }
}
