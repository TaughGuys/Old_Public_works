import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.w3c.dom.css.Rect;



public class SnakePanel extends JPanel implements KeyListener,Runnable{
	
	public static final int scale = 30;
	public static final int pWidth = 20;
	public static final int pHeight = 20;
	public static  int snakeSpeed = 4;
	public boolean StartGame = true;
	public String ValueOfScore = "";
	public static int score = 0;
	Snake s;
	Apple a;
	SnakeGame sg;
	Thread th;
	Rectangle rect;
	Rectangle rectSnake;
	Random rand;
	int aX, aY;
	String path ="pictures\\";
	String snakeDir = "";
	
	Image img;
	Image snakeImg;
	
	int selectImg = 0;
	boolean pause = false;
	
	public SnakePanel(SnakeGame sg){
		this.sg = sg;
		rand = new Random();
		aX = (int)(Math.random()*pWidth);
		aY =  (int)(Math.random()*pWidth);
		a = new Apple(aX,aY,this);
		s = new Snake(40,40,36,40); 
		th = new Thread(this);
		th.start();
		addKeyListener(this);
		setFocusable(true);
		
	}

	public void paint(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, pWidth*scale, pHeight*scale);
		g.setColor(Color.RED);
		g.fillRect(0, 0, pWidth*scale, 2);
		g.fillRect(pWidth*scale- 2, 0, pWidth*scale, pHeight * scale);
		g.fillRect(0,pHeight*scale ,  pWidth*scale,pHeight * scale - 2);
		g.fillRect(0, 0, 2, pHeight*scale);
		
		for(int d = 0; d< s.length; d++){
			
			rectSnake = new Rectangle(s.snakeX[d] * scale + 1, s.snakeY[d]
					* scale + 1, scale + 20, scale + 20);

			if (d != 0) {
					snakeDir = "snakeBody";
			}else{
				switch(s.keyDirect){
				case 0:{
					snakeDir = "snakeHeadRight";
					break;
				}
				case 1:{
					snakeDir = "snakeHeadDown";
					break;
				}
				case 2:{
					snakeDir = "snakeHeadLeft";
					break;
				}
				case 3:{
					snakeDir = "snakeHeadUp";
					break;
				}
				}
				
			}
			snakeImg = new ImageIcon(path + snakeDir + ".png").getImage();
			if(d == 0)
			g.drawImage(snakeImg, rectSnake.x, rectSnake.y,
					rectSnake.width, rectSnake.height, this);
			else
				if(d == s.length-1){
					
					switch(s.keyDirect){
					case 0:{
						g.drawImage(snakeImg, rectSnake.x -10, rectSnake.y +11,
									rectSnake.width-25, rectSnake.height-25, this);
						break;
					}
					case 1:{
						g.drawImage(snakeImg, rectSnake.x +11, rectSnake.y -10,
								rectSnake.width-25, rectSnake.height-25, this);
						break;
					}
					case 2:{
						g.drawImage(snakeImg, rectSnake.x +30, rectSnake.y +11,
								rectSnake.width-25, rectSnake.height-25, this);
						break;
					}
					case 3:{
						g.drawImage(snakeImg, rectSnake.x +11, rectSnake.y +30,
								rectSnake.width-25, rectSnake.height-25, this);
						break;
					}
					}
					
				}else{
				
				switch(s.keyDirect){
				case 0:{
					g.drawImage(snakeImg, rectSnake.x -6, rectSnake.y +7,
							rectSnake.width-16, rectSnake.height-16, this);
					break;
				}
				case 1:{
					g.drawImage(snakeImg, rectSnake.x +7, rectSnake.y -6,
							rectSnake.width-16, rectSnake.height-16, this);
					break;
				}
				case 2:{
					g.drawImage(snakeImg, rectSnake.x +25, rectSnake.y +7,
							rectSnake.width-16, rectSnake.height-16, this);
					break;
				}
				case 3:{
					g.drawImage(snakeImg, rectSnake.x +7, rectSnake.y +25,
							rectSnake.width-16, rectSnake.height-16, this);
					break;
				}
				}
				}
		}
		
		
		rect = new Rectangle(a.posX*scale + 1, a.posY*scale+1, scale-1, scale-1);
		img = new ImageIcon(path + selectImg + ".png").getImage();
		g.drawImage(img, rect.x, rect.y, rect.width+20, rect.height+15, this);		
		
	}
	public Color color(int red, int green, int blue){
		if(green >= 250 ) green = 250;
		return new Color(red,green,blue);
	}

	public void keyPressed(KeyEvent e) {
				
		if((e.getKeyCode() == e.VK_RIGHT) && s.keyDirect != 2 )	s.keyDirect = 0;
		if((e.getKeyCode() == e.VK_DOWN) && s.keyDirect != 3)	s.keyDirect = 1;
		if((e.getKeyCode() == e.VK_LEFT) && s.keyDirect != 0)	s.keyDirect = 2;
		if((e.getKeyCode() == e.VK_UP ) && s.keyDirect != 1)    s.keyDirect = 3;
		
		if(e.getKeyCode() == e.VK_N )  newGAme();
		if(e.getKeyCode() == e.VK_SPACE){
			if(!pause){
				StartGame = false;
				pause = true;
			}else
			if(pause){
				StartGame = true;
				pause = false;
			}
		}

	}
	
	private void newGAme() {
		sg.ap.clip.stop();
		sg.dispose();
		Main.main(new String[0]);
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void changeSnakeSpeed(int sc){
		switch (sc) {

		case 100: {
			snakeSpeed = 5;
			break;
		}
		case 150: {
			snakeSpeed = 6;
			break;
		}
		case 200: {
			snakeSpeed = 7;
			break;
		}
		case 250: {
			snakeSpeed = 8;
			break;
		}
		case 300: {
			snakeSpeed = 9;
			break;
		}
		case 350: {
			snakeSpeed = 10;
			break;
		}
		case 400: {
			snakeSpeed = 11;
			break;
		}
		case 450: {
			snakeSpeed = 14;
			break;
		}
		}
		
	}
	public void run() {
		
		for(;;){
			try {
				
				changeSnakeSpeed(score);
				
				Thread.sleep(1000 / snakeSpeed );
				if(StartGame){
					s.move();
				}else{
					sg.ap.clip.loop();
				}
			} catch (InterruptedException e) {
			} 
			
			
			if ((s.snakeX[0] == a.posX) && (s.snakeY[0] == a.posY)) {
				a.setRandomPosition();
				
				selectImg = rand.nextInt(6);
				s.length++;
				score += 10;
				
			}
			//
			for (int k = 1; k < s.length; k++) {
				if ((s.snakeX[k] == a.posX) && (s.snakeY[k] == a.posY)) {
					a.setRandomPosition();				
				}
			}
			
			ValueOfScore = String.valueOf(score);
			sg.scp.lbScorValue.setText(ValueOfScore);
			if(s.himeselfEat())
				sg.scp.lbLavelValue.setText(" 0 " + "    ");
			else
			sg.scp.lbLavelValue.setText(String.valueOf(snakeSpeed - 4) + "    ");
			
			repaint();
		}
		
	}
	public void Start(){
		StartGame = true;
		
	}
	public void Stop(){
		StartGame = false;
	}

}
