package org.teachingkidsprogramming.util;

import java.io.File;

public class SystemUtils
{
  public static boolean isWindowsEnvironment()
  {
    return "\\".equals(File.separator);
  }

}
