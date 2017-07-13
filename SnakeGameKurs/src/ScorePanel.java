import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel{

	JLabel lbScor;
	JLabel lbScorValue;
	JLabel lbLevel;
	JLabel lbLavelValue;
	
	Font font;
	SnakeGame sg;
	public String value = "0";
	public String lvlValue = "0";
	
	
	public ScorePanel(SnakeGame sn){
		
		font = new Font("Verdana", Font.PLAIN, 26);
		this.sg = sn;
		lbLevel = new JLabel("Level : ");
		lbLavelValue = new JLabel(lvlValue);
		lbScor = new JLabel("SCORE : ");
		lbScorValue = new JLabel(value);
		add(lbLevel,BorderLayout.NORTH);
		add(lbLavelValue,BorderLayout.NORTH);
		add(lbScor,BorderLayout.WEST);
		add(lbScorValue,BorderLayout.EAST);
		
		lbLevel.setFont(font);	
		lbLavelValue.setFont(font);
		lbScor.setFont(font);
		lbScorValue.setFont(font);
		
		setBackground(Color.CYAN);
		setVisible(true);
	}
}
