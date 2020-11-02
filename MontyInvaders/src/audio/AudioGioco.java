package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class AudioGioco {

	AudioInputStream audioInputStream = null;
	Clip clip = null;
	
	
	public void playSuonoSparo()
	{
	    try
	    {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("suoni/shoot.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error with playing shoot sound.");
	    }
	}
	
	public void playSuonoNemicoUcciso()
	{
	    try
	    {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("suoni/enemyKilled.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error with playing enemyKilled sound.");
	    }
	}
	
	public void playSoundtrackSound()
	{
	    try
	    {
	        audioInputStream = AudioSystem.getAudioInputStream(new File("suoni/soundtrack.wav").getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        clip.loop(clip.LOOP_CONTINUOUSLY);
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error with soundtrack sound.");
	    }
	}
	
	public void stopSoundtrackSound()
	{
		try
		{
			clip.stop();
		}
		catch(Exception e)
		{
			System.out.println("Error with soundtrack STOP");
		}
	}
}
