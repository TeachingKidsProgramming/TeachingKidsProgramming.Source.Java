package org.teachingextensions.utils;

import java.io.File;

import com.spun.util.StringUtils;
import com.spun.util.io.FileUtils;

/**
 * <img src="http://indiajkd.com/wp-content/uploads/2013/08/JKD-India-6.gif" align="left" height="50" width="50">
 * Virtual Proctor allows you to see what all the TKPJava coders are making
 */
public class VirtualProctor
{
  public static class internals
  {
    private static final String FILE_NAME = ".virtual_proctor.txt";
    public static String getName()
    {
      String name = getCustomName();
      if (name == null)
      {
        name = getComputerName();
      }
      if (name == null)
      {
        name = getUserName();
      }
      return name;
    }
    private static String getCustomName()
    {
      File file = new File(FILE_NAME);
      if (file.exists()) { return FileUtils.readFileWithSuppressedExceptions(file).trim(); }
      return null;
    }
    public static String getComputerName()
    {
      return System.getenv("COMPUTERNAME");
    }
    public static String getUserName()
    {
      return System.getenv("USER");
    }
    public static void resetName()
    {
      File file = new File(FILE_NAME);
      if (file.exists())
      {
        file.delete();
      }
    }
    /**
     * Allows you to set the displayed username in Virtual Proctor
     * <div><b>Example:</b> {@code  virtualProctor.setName(name)} </div>
     * 
     * @param name
     *            A name that is displayed for the user in the Virtual Proctor client 
     */
    public static void setName(String name)
    {
      if (StringUtils.isEmpty(name)) { return; }
      FileUtils.writeFileQuietly(new File(FILE_NAME), name);
    }
  }
  public static void setName(String name)
  {
    internals.setName(name);
  }
}
