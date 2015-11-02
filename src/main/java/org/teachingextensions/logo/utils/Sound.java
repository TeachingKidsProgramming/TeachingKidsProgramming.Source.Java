package org.teachingextensions.logo.utils;

import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * <img src="http://www.spellzone.com/images/sound-icon.gif" style="text-align: left" alt="A speaker with sound waves" >
 * Sound allows you to play a sound, like a 'beep' or the sound from a file 
 */
public class Sound
{
  /**
   * Plays a beep through your speakers. BEEP!<br>
   * <b>Example:</b> {@code  Sound.playBeep()}
   */
  public static void playBeep()
  {
    Toolkit.getDefaultToolkit().beep();
  }
  /**
   * Plays a sound through your speakers. Use a '.wav' file<br>
   * <b>Example:</b> {@code  Sound.playSound("mySound.wav")}
   */
  public static synchronized void playSound(final String fileName)
  {
    new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          Clip clip = AudioSystem.getClip();
          AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
          clip.open(inputStream);
          clip.start();
        }
        catch (Exception e)
        {
          System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
        }
      }
    }).start();
  }
}
