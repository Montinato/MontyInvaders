package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MenuSuono {
	AudioInputStream audioInputStream = null;
	Clip clip = null;
	        
	public void playSound()
	{
	    try
	    {
	    	audioInputStream = AudioSystem.getAudioInputStream(new File("suoni/moon.wav").getAbsoluteFile());
	    	clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        clip.loop(clip.LOOP_CONTINUOUSLY);
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error with playing menu sound.");
	    }
	}
	
	public void stopSound()
	{
	    try
	    {
	        clip.stop();
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error with stopping menu sound.");
	    }
	}
}
