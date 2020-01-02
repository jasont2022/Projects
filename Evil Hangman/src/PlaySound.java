import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class is responsible for reading and playing a sound file
 * 
 * @author jasontran
 */
public class PlaySound {

	/**
	 * This method helps with reading the file and playing the sound
	 * 
	 * @param filePath the location of the sound file
	 * @throw IllegalArgumentException if musicLocation is null or the file doesn't
	 *        exist
	 */
	public static void playSound(String filePath) {
		if (filePath == null) {
			throw new IllegalArgumentException("File Path is null!");
		}
		File file = new File(filePath);
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(sound);
			clip.setFramePosition(0);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			System.out.println("File format is unsupported: " + e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println("Line Unavaible: " + e.getMessage());
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File is not found!");
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}