import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class AudioPanel extends JPanel {
	AudioClip clip;
	
	String[] songs = {"huh.wav",  "israel.wav"};
	
	int ind=1;
	SnakeGame af;
	public AudioPanel(SnakeGame audioFrame) {
		this.af =audioFrame;

		check(ind);
	}
	public AudioPanel(int i){
		check(i);
	}
	public void check(int ind) {

		try{
			
		      clip = Applet.newAudioClip(new URL("file:Songs/"+songs[ind]));
		      clip.play();
		    }
		
		    catch (MalformedURLException mfe){
		      System.out.println("An error occured, please try again...");
		    }
		repaint();
	}

	public void play() {
		clip.play();
	}
	public void loop() {
		clip.loop();
	}
	public void stop() {
		clip.stop();
	}
		
	

}
