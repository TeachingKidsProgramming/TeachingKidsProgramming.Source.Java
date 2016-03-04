package org.teachingkidsprogramming.recipes.completed.section00demos;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.TKPLogoUtils.TKPLogo;

public class MakeALogo

{
  public static int YValue = 300;
  public static int XValue = 100;
  public static void main(String[] args)
  {
    //  Show the Tortoise --#1
    Tortoise.show();
    //  Make the Tortoise draw a line as fast as possible --#2
    Tortoise.setSpeed(10);
    //  Setup the Color Wheel --#3 HINT: Use the TKPLogo object
    TKPLogo.setupColorWheel();
    //  Draw a TKP 'T' --#4
    TKPLogo.draw_tkp_T();
    //  Draw a left bracket --#8
    TKPLogo.drawLeftBracket();
    //  Draw a TKP 'K' --#5
    TKPLogo.draw_tkp_K();
    //  Draw a right bracket --#9
    TKPLogo.drawRightBracket();
    //  Draw an outer TKP 'P' --#6
    TKPLogo.draw_outer_tkp_P();
    //  Call the make_Inner_P() method --#7
    TKPLogo.draw_inner_tkp_P();
  }
}
