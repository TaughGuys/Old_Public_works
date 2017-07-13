import java.awt.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Snake{
	
	public Snake(){
		
	}

	SnakePanel sp;
	public int keyDirect = 0;
	public int length = 2;
	public boolean himselfeatTest = false;
	public int snakeX[] = new int[(sp.pWidth * sp.pHeight)*2];
	public int snakeY[] = new int[(sp.pWidth * sp.pHeight)*2];

	public Snake(int x0, int y0,int x1,int y1){
		snakeX[0] = x0;
		snakeY[0] = y0;
		snakeX[1] = x1;
		snakeY[1] = y1;
		
	}

	public void move(){
		
		for(int d = length; d>0; d--){
			snakeX[d] = snakeX[d-1];
			snakeY[d] = snakeY[d-1];
		}
		if(keyDirect == 0) {
			snakeX[0]++;
		//Right
		}
		if(keyDirect == 1) {
		//Down
			snakeY[0]++;
		}
		if(keyDirect == 2) {
		//Left
			snakeX[0]--;
		}
		if(keyDirect == 3) {
	    //Up
			snakeY[0]--;
		}
		
		himeselfEat();
		
		
		if(snakeX[0] > sp.pWidth - 1) snakeX[0] = 0;
		if(snakeX[0] < 0) snakeX[0] = sp.pWidth-1;
		if(snakeY[0] > sp.pHeight - 1) snakeY[0] = 0;
		if(snakeY[0] < 0) snakeY[0] = sp.pHeight-1;
	}
	
	
	public boolean himeselfEat()
	{
		himselfeatTest = false;
		for(int d = length-1; d>0; d--){
			if((snakeX[0] == snakeX[d]) && (snakeY[0] == snakeY[d] )){
				length = 2;
				sp.score = 0;
			
				himselfeatTest = true;
				AudioPanel au = new AudioPanel(0);
			}
			if(length < 2) length = 2;
		}
		return himselfeatTest;
	}
}
