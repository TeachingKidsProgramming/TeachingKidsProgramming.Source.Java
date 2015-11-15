package org.teachingextensions.logo;

import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

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
   * Current types are: CatMeow, Crickets
   */
  public enum TKPSound {
    CatMeow, Crickets
  }
  private String soundFilename = null;
  public synchronized void setSound(TKPSound mySound)
  {
    //String sound = "soundFiles/" + mySound + ".wav";
    String sound = mySound + ".wav";
    URL resource = this.getClass().getResource(sound);
    if (resource == null)
    {
      resource = this.getClass().getClassLoader().getResource(sound);
    }
    if (resource == null) { throw new IllegalStateException("Could not get TKPSound: " + sound); }
    this.soundFilename = resource.toString();
    this.soundFilename = this.soundFilename.replace("file:", "");
  }
  /**
   * Plays a sound through your speakers. Use a '.wav' file<br>
   * <b>Example:</b> {@code  Sound.playSound("mySound.wav")}
   */
  public synchronized void playSound()
  {
    final String sound = this.soundFilename;
    new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          Clip clip = AudioSystem.getClip();
          AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(sound));
          clip.open(inputStream);
          clip.start();
        }
        catch (Exception e)
        {
          System.out.println("play sound error: " + e.getMessage() + " for " + sound);
        }
      }
    }).start();
  }
}
