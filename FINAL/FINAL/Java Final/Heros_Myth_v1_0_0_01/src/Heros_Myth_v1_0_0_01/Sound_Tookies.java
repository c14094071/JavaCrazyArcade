package Heros_Myth_v1_0_0_01;



import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound_Tookies {
	static Clip clip;
	
	public Sound_Tookies(String addr) {
		
		try {
			play_music(addr);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void play_music(String addr) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		String soundName = addr;
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
		
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}
	
	public static void stop_music() {
		clip.stop();
	}
}