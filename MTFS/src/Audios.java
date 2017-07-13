import java.applet.Applet;

import java.applet.AudioClip;

import java.net.URL;
import javax.swing.JOptionPane;
public class Audios   {
	AudioClip clip, clip1,clip11;
	public Audios() {
		super();	
	}
	public void play(int car){
		if (car==1 || car==0 || car ==6 || car==10 ||car==8 ||car==2 ){
			if (clip !=null){
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			clip.stop();}
		try {
			clip = Applet.newAudioClip(new URL("file:Songs/"+car+".wav"));Thread.sleep(20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "audio error");
		}
		clip.play();}}
}

