package org.teachingextensions.approvals.lite;

import junit.framework.TestCase;
import org.teachingextensions.approvals.lite.util.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class FileApproverTest extends TestCase
{
  public void testApproveTextFile() throws Exception
  {
    File f1 = createFile("1");
    File f2 = createFile("2");
    assertFalse("files are different", FileApprover.approveTextFile(f1, f2));
    f2 = createFile("1");
    assertTrue("files are the same", FileApprover.approveTextFile(f1, f2));
  }
  public void testApproveTextFileWithNonExsitantFile() throws Exception
  {
    File f1 = createFile("1");
    File f2 = new File("no exist");
    assertTrue(f1.exists());
    assertFalse(f2.exists());
    assertFalse(FileApprover.approveTextFile(f1, f2));
  }

  private File createFile(String string) throws IOException
  {
    File f = File.createTempFile("avc", "t");
    FileUtils.writeFile(f, string);
    return f;
  }
}
