import java.awt.Rectangle;
import java.util.Random;



public class Apple {
	public int posX;
	public int posY;
	SnakePanel sp;
	Random rand;
	
	public Apple(int startX, int startY,SnakePanel sp){
		this.sp = sp;
		posX = startX;
		posY = startY;	
	}
	
	public  void setRandomPosition(){
		posX = (int)(Math.random() * sp.pWidth);
		posY = (int)(Math.random() * sp.pHeight);
		
	}
}
