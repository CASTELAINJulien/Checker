package checker.data;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ClipPlayer
{
	private static Mixer mixer;
	private static Clip clip;
	private static FloatControl gainControl;
	
	public ClipPlayer() throws IOException, UnsupportedAudioFileException, LineUnavailableException
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
			URL soundURL = ClipPlayer.class.getResource("metro.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("metro.wav"));	
			clip.open(audioStream);
			
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			}  catch (IOException ioe) { 
			ioe.printStackTrace(); 
		}
		
		do {
			try { 
				Thread.sleep(50);
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} while (clip.isActive());
	}
	
	public static void changeVolumeClip (float wantedVolume) {
		// The wanted volume parameter should varies between 0 and 100
		// Since the value of he gainControl varies between 6.0206 and -80.0, we need to convert that value.
		
		float soundVolumeValue = ( wantedVolume * (-gainControl.getMinimum() + gainControl.getMaximum()) ) / 100;
		gainControl.setValue(soundVolumeValue);
	}
	
	public void playClip () {
		clip.start();
	}
	
	public void closeClip () {
		clip.close();
	}
}