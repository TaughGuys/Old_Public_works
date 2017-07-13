import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class MyPanel extends JPanel implements MouseListener{
	Nkar nk;
	MyFrame mf;
	boolean selected;
	Color color;
	public MyPanel(MyFrame mf){
		this.mf=mf;
		color=new Color(0,0,0);
		setBackground(color);
		nk=new Nkar(this);
		addMouseListener(this);
		
	}
	public void paint(Graphics g){
		super.paint(g);
		nk.paint(g);
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(!selected){
			nk.vercnel(e.getX(),e.getY());
			repaint();
		}
		else{
			nk.dnel(e.getX(),e.getY());
			repaint();
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
