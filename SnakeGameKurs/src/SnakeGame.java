import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class SnakeGame extends JFrame{

	SnakePanel sp;
	AudioPanel ap;
	ScorePanel scp;
	Color color;
	public SnakeGame(){
		ap = new AudioPanel(this);
		sp = new SnakePanel(this);
		scp = new ScorePanel(this);
		add(sp,BorderLayout.CENTER);
		add(scp,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Snake");
		setSize(607,675);
		setBackground(new Color(255,216,200));
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}
