

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Car {
		int x, y, w, h;
		MyPanel mp;
		Asfalt asf;
		Image img;
		String path = "Pictures/";
		CarAudios carau = new CarAudios();
		public Car(MyPanel mp, Asfalt asf) {
			this.mp = mp;
			this.asf = asf;
			x = asf.x+asf.w/2;
			y = asf.y+asf.h/2-50;
			
			img =new ImageIcon(path+"000.png").getImage();
			w = img.getWidth(null);
			h = img.getHeight(null);
	}
		public void paint(Graphics g) {
			//g.setColor(Color.red);
			//g.fillRect(x, y, w, h);
			g.drawImage(img, x, y, w, h, null);
		}
		public void left() {
			if(x>asf.x+20){
				x-=20;
			}
			
		}
		public void right() {
			
			if(x+w<asf.x+asf.w-20){
				x+=20;
			}
		}
		public void down() {
			if(y+h<asf.h){y+=20;}
			// TODO Auto-generated method stub
			
		}
		public void up() {
			if (y>0){y-=20;}
			// TODO Auto-generated method stub
			
		}

		
		
}
