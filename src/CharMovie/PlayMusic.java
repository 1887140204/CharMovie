package CharMovie;

import java.applet.Applet;
import java.io.FileInputStream;
import java.io.IOException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PlayMusic extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2508683859616481094L;
	AudioStream as;

	PlayMusic() {
		System.out.println("“Ù∆µ≥ı ºªØ÷–°≠°≠");
		as = null;
		try {
			FileInputStream fileau = new FileInputStream(Main.MvName + "\\music.wav");
			as = new AudioStream(fileau);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		AudioPlayer.player.start(as);
	}
}