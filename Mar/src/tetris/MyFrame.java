package tetris;
import javax.swing.*;


import tetris.MyPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ReadOnlyBufferException;

public class MyFrame extends JFrame implements ActionListener{
	
	JButton startG,exitG;
    JPanel panel;
    ImageIcon ii;
    JLabel picture;
    JLabel statusbar;
	public MyFrame()
	{
		statusbar = new JLabel(" 0");
		add(statusbar, BorderLayout.SOUTH);
		MyPanel mp=new MyPanel(this);
		add(mp);
		mp.start();
		setBackground(Color.GREEN);



		setTitle("Tetris");
		JMenu fileMenu=new JMenu("Game");
		JMenuItem newItem=fileMenu.add(new TestAction("New"));
		
        
		fileMenu.add(new AbstractAction("Exit") {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
				// TODO Auto-generated method stub
				
			}
		}) ;
	
			// TODO Auto-generated method stub
			JMenu optionMenu=new JMenu("Options");
			optionMenu.addSeparator();
			JMenu helpMenu=new JMenu("Help");
			helpMenu.setMnemonic('H');
			JMenuItem indexItm=new JMenuItem("Index");
			indexItm.setMnemonic('I');
			helpMenu.add(indexItm);
			Action aboutAction=new TestAction("About");
			aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
			JMenuBar menuBar=new JMenuBar();
			setJMenuBar(menuBar);
			menuBar.add(fileMenu);
			menuBar.add(helpMenu);
			
			
		
	
		
		
	}
	public JLabel getStatusBar() {
		return statusbar;
		   }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
