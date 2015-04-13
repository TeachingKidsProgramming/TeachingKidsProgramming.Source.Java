package org.teachingextensions.setup;

import org.teachingextensions.approvals.lite.util.SystemUtils;
import org.teachingextensions.approvals.lite.util.servlets.ValidationError;
import org.teachingextensions.setup.SetupValidator.SetupCheckPoints;

public class SetupConfig
{
  public ValidationError setup              = new ValidationError(SetupCheckPoints.values());
  public String          workspacePath      = ".";
  //"C:\\Users\\Llewellyn\\workspace\\ApprovalTestsKoans\\TeachingKidsProgramming.Java";
  public String          eclipsePath        = SystemUtils.isWindowsEnvironment()
                                                ? eclipsePathWindows
                                                : eclipsePathMac;
  public static String   eclipsePathWindows = "c:\\eclipse\\eclipse.exe";
  public static String   eclipsePathMac     = "/Applications/eclipse/Eclipse.app/Contents/MacOS/eclipse";
  public void assertSetupIsCorrect()
  {
    if (!setup.isOk()) { throw setup; }
  }
}
