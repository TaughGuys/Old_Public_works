import java.awt.BorderLayout;

import javax.swing.JFrame;


public class MyFrame extends JFrame {
	MyPanel mp;
	ButtonsPanel bp;
	public MyFrame(){
		mp=new MyPanel(this);
		bp=new ButtonsPanel(mp);
		add(mp,BorderLayout.CENTER);
		add(bp,BorderLayout.SOUTH);
		setSize(1250,750);
		setVisible(true);
		setTitle("Pazzle");
	}
}
