import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ButtonsPanel extends JPanel implements ActionListener,ItemListener{
	JButton btnNormal;
	JButton btnCrop;
	JButton btnMix;
	JButton btnStop;
	JButton btnStart;
	JButton btnFust;
	JButton btnSlow;
	JButton btnrejim;
	JRadioButton rb1;
	JRadioButton rb2;
	JRadioButton rb3;
	JTextField tfQanak;	
	int o=1;
	MyPanel mp;
	Color color;
	
	public ButtonsPanel(MyPanel mp) {
		this.mp=mp;
		color=new Color(255,255,255);
		setBackground(color);
		btnNormal=new JButton("Normal");
		btnCrop=new JButton("Crop");
		btnMix=new JButton("Mix");
		btnStop=new JButton("Stop");
		btnStart=new JButton("Start");
		btnFust=new JButton("Fust");
		btnSlow=new JButton("Slow");
		btnrejim=new JButton("miangamic");
		rb1=new JRadioButton("method 1");
		rb2=new JRadioButton("method 2");
		rb3=new JRadioButton("method 3");
		rb1.setSelected(true);
		tfQanak=new JTextField(5);
		
		tfQanak.setText("6");
		
		add(btnStart);
		add(btnNormal);
		add(tfQanak);
		add(btnCrop);
		add(btnMix);
		add(btnStop);
		add(btnFust);
		add(btnSlow);
		add(btnrejim);
		add(rb1);
		add(rb2);
		add(rb3);
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(rb1);
		gr.add(rb2);
		gr.add(rb3);
		
		btnNormal.addActionListener(this);
		btnCrop.addActionListener(this);
		btnMix.addActionListener(this);
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		btnFust.addActionListener(this);
		btnSlow.addActionListener(this);
		tfQanak.addActionListener(this);
		btnrejim.addActionListener(this);
		
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNormal){
			mp.nk.normal();
			mp.repaint();
		}
		if(e.getSource()==btnCrop){
			mp.nk.crop();
			mp.repaint();
		}
		if(e.getSource()==btnMix){
			mp.nk.mix();	
			mp.repaint();
		}
		if(e.getSource()==btnStart){
			mp.nk.moving=true;			
		}
		if(e.getSource()==btnStop){
			mp.nk.moving=false;
		}
		if(e.getSource()==btnFust){
			mp.nk.fust();
		}
		if(e.getSource()==btnSlow){
			mp.nk.slow();
		}
		if(e.getSource()==tfQanak){
			int n=Integer.parseInt(mp.mf.bp.tfQanak.getText());
			
			mp.nk.cropNum(n);
		}
		if(e.getSource()==btnrejim){
			mp.nk.rejim();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==rb1){
			o=1;
		}
		if(e.getSource()==rb2){
			o=2;
		}
		if(e.getSource()==rb3){
			o=3;
		}
	}
	
	
}
