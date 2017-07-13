import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class OpenFrame extends JFrame implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton start ;
JButton close;
JPanel panel;
Image img;
Audios aud=new Audios();
	public OpenFrame() throws HeadlessException {
		super();
		
		start= new JButton("Start Game");
		close= new JButton("Exit");
		panel=new JPanel();
		start.addActionListener(this);
		close.addActionListener(this);
		panel.setLayout(new FlowLayout());
		panel.add(start);panel.add(close);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Tough Crash");
		add(panel, BorderLayout.NORTH);
		setLayout(new FlowLayout());
		img=new ImageIcon("Pictures/er1.jpg").getImage();
		setVisible(true);
	}
	public void paint (Graphics g){
		g.setColor(Color.BLUE);
		//g.fillRect(10, 20, 10, 40);
		g.drawImage(img, 0, 0, 300,200,null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==start){
	new MyFrame();
	}else{dispose();}
	}

	
	
}
