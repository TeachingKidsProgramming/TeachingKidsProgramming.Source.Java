package org.teachingkidsprogramming.recipes.completed.section00demos;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.EventUtils.MessageBox;

public class QuickTortoise
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    //  Use the Tortoise object to draw a Tortoise!
    Tortoise.drawTortoise();
    Tortoise.setName("Sam");
    String t = (Tortoise.getName());
    MessageBox.showMessage(t);
  }
}
