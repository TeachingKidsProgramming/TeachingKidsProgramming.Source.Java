package org.teachingextensions.logo.utils;

import java.awt.Toolkit;

/**
 * <img src="http://www.spellzone.com/images/sound-icon.gif" align="left" >
 * Sounds allows you to play sounds, like a 'beep'
 */
public class Sounds
{
  /**
   * Plays a beep through your speakers. BEEP!<br />
   * <b>Example:</b> {@code  Sounds.playBeep()}
   */
  public static void playBeep()
  {
    Toolkit.getDefaultToolkit().beep();
  }
}
