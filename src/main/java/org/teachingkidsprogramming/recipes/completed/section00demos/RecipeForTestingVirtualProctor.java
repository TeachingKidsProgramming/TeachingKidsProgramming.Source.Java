package org.teachingkidsprogramming.recipes.completed.section00demos;

import org.teachingextensions.logo.Sound;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Text;
import org.teachingextensions.virtualproctor.VirtualProctor;

public class RecipeForTestingVirtualProctor
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Yellows.Goldenrod);
    int sides = 5;
    new Text("Hi from California!").setTopLeft(100, 100).addTo(Tortoise.getBackgroundWindow());
    for (int i = 0; i < sides; i++)
    {
      Tortoise.setPenColor(PenColors.Greens.DarkCyan);
      Tortoise.setPenWidth(150);
      Tortoise.move(75);
      Tortoise.turn(360 / sides);
      Sound s = new Sound();
      s.setSound(Sound.TKPSound.SoBeIt);
      s.playSound();
    }
    VirtualProctor.setClassName("TKPHouseAtHome");
    VirtualProctor.setName("LynnLangit");
  }
}
