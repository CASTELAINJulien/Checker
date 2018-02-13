package checker.data;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ClipPlayer
{
	public static Mixer mixer;
	public static Clip clip;
	
	public ClipPlayer() throws IOException
	{
		Mixer.Info[] mixInfo = AudioSystem.getMixerInfo();
		mixer = AudioSystem.getMixer(mixInfo[0]);
		
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try {
			clip = (Clip)mixer.getLine(dataInfo);
		} catch ( LineUnavailableException lue ) {
			lue.printStackTrace();		
		}
		
		try {	
			System.out.println(new File("test.txt").getCanonicalPath().toString());
			URL soundURL = ClipPlayer.class.getResource("/soundDemotest/metro.wav");
			// AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("metro.wav"));	
			clip.open(audioStream);
			
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-40.0f); // Reduce volume by 10 decibels.
		} 
		catch (LineUnavailableException lue) { lue.printStackTrace(); }
		catch (UnsupportedAudioFileException uafe) { uafe.printStackTrace(); }
		catch (IOException ioe) { ioe.printStackTrace(); }
		
		do {
			try { 
				Thread.sleep(50);
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} while (clip.isActive());
	}
	
	public void playClip () {
		clip.start();
	}
	
	public void closeClip () {
		clip.close();
	}
}
