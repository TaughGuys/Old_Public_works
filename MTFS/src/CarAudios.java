import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class CarAudios {
	AudioClip clip1;
	public CarAudios() {
		super();	
	}
public void loop(){
	try {
			clip1 = Applet.newAudioClip(new URL("file:Songs/"+"Standart.wav"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "audio error");
		}
		
		clip1.loop();
	}
public void stop() {
	clip1.stop();
	
}
public void crash() {
	try {
		clip1 = Applet.newAudioClip(new URL("file:Songs/"+"Crash.wav"));
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "audio error");
	}
	clip1.play();
	
}
}
