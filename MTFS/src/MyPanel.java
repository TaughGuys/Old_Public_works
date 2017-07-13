import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MyPanel extends JPanel implements KeyListener{
			
	private static final long serialVersionUID = 1L;
			MyFrame fr;
			Asfalt asf;
			Car car;
			Lines line;
			OtherCar odCar;
			int k;
			int speed=5;
			boolean bo=false;
			CarAudios aud = new CarAudios();
		public MyPanel(MyFrame fr){
			this.fr = fr;
			setSize(600,800);
			setBackground(Color.green);
			asf = new Asfalt(this);
			car = new Car(this, asf);
			line = new Lines(this,asf);
			odCar = new OtherCar(this, asf);
			addKeyListener(this);
			setFocusable(true);
			speed = 5;k=0;
			//aud.loop();
			aud.loop();
		}
		public void paint(Graphics g){
			super.paint(g);
			asf.paint(g);
			line.paint(g);
			car.paint(g);
			odCar.paint(g);
			check();
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial",11,25));
			g.drawString("Wining balls  "+speed,10, 40);
			k++;
			if(k>500){speed+=5;k=0;}
			if (speed>100){
				odCar.moving=false;
				JOptionPane.showMessageDialog(null, "You Are Win! Go and rest");fr.dispose();
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bo){
				aud.stop();
				aud.crash();
				asf.paint(g);
				line.paint(g);
				car.paint(g);
				odCar.paint(g);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aud.stop();
				JOptionPane.showMessageDialog(null, "Good Job:Your scare is "+ odCar.score);
				fr.dispose();
			}
			repaint();
		}
		private void check() {
			if(car.x+15>odCar.x && car.x+15<odCar.x+odCar.w && car.y+15>odCar.y && car.y+15<odCar.y+odCar.h){   //1
				odCar.moving=false;
				bo=true;
				}
			if(car.x+15>odCar.x1 && car.x+15<odCar.x1+odCar.w1 && car.y+15>odCar.y1 && car.y+15<odCar.y1+odCar.h1){  //2
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+15>odCar.x01 && car.x+15<odCar.x01+odCar.w01 && car.y+15>odCar.y01 && car.y+15<odCar.y01+odCar.h01){ //3
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+15>odCar.x11 && car.x+15<odCar.x11+odCar.w11 && car.y+15>odCar.y11 && car.y+15<odCar.y11+odCar.h11){  //4
				odCar.moving=false; 
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x && car.x+car.w-15<odCar.x+odCar.w && car.y+15>odCar.y && car.y+15<odCar.y+odCar.h){  //1
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x1 && car.x+car.w-15<odCar.x1+odCar.w1 && car.y+15>odCar.y1 && car.y+15<odCar.y1+odCar.h1){  //2
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x01 && car.x+car.w-15<odCar.x01+odCar.w01 && car.y+15>odCar.y01 && car.y+15<odCar.y01+odCar.h01){ //3
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x11 && car.x+car.w-15<odCar.x11+odCar.w11 && car.y+15>odCar.y11 && car.y+15<odCar.y11+odCar.h11){  //4
				odCar.moving=false; 
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x && car.x+car.w-15<odCar.x+odCar.w && car.y+car.h-15>odCar.y && car.y+car.h-15<odCar.y+odCar.h){  //1
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x1 && car.x+car.w-15<odCar.x1+odCar.w1 && car.y+car.h-15>odCar.y1 && car.y+car.h-15<odCar.y1+odCar.h1){  //2
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x01 && car.x+car.w-15<odCar.x01+odCar.w01 && car.y+car.h-15>odCar.y01 && car.y+car.h-15<odCar.y01+odCar.h01){ //3
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+car.w-15>odCar.x11 && car.x+car.w-15<odCar.x11+odCar.w11 && car.y+car.h-15>odCar.y11 && car.y+car.h-15<odCar.y11+odCar.h11){  //4
				odCar.moving=false; 
				
				bo=true;
				}
			if(car.x+15>odCar.x && car.x+15<odCar.x+odCar.w && car.y+car.h-15>odCar.y && car.y+car.h-15<odCar.y+odCar.h){  //1
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+15>odCar.x1 && car.x+15<odCar.x1+odCar.w1 && car.y+car.h-15>odCar.y1 && car.y+car.h-15<odCar.y1+odCar.h1){  //2
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+15>odCar.x01 && car.x+15<odCar.x01+odCar.w01 && car.y+car.h-15>odCar.y01 && car.y+car.h-15<odCar.y01+odCar.h01){ //3
				odCar.moving=false;
				
				bo=true;
				}
			if(car.x+15>odCar.x11 && car.x+15<odCar.x11+odCar.w11 && car.y+car.h-15>odCar.y11 && car.y+car.h-15<odCar.y11+odCar.h11){  //4
				odCar.moving=false; 
				
				bo=true;
				
				}
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
				car.left(); 
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				car.right();
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){car.down();}
			if (e.getKeyCode()==KeyEvent.VK_UP){car.up();}
			repaint();
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
