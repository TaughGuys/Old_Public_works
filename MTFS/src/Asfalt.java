import java.awt.Color;
import java.awt.Graphics;


public class Asfalt  {
		int x,y,w,h , xl1 ,xl2 ;
		MyPanel mp;
		public Asfalt(MyPanel mp){
			this.mp = mp;
			x = 0;
			y = 0;
			w = mp.getWidth();
			h = mp.getHeight();
			xl1=mp.getWidth()/2-7;xl2=mp.getWidth()/2+2;
		}
		public void paint(Graphics g) {
			g.setColor(Color.gray);
			g.fillRect(x, y, w, h);
			g.setColor(Color.WHITE);
			g.fillRect(xl1, 0, 5, h);
			g.fillRect(xl2, 0, 5, h);
		}
		
}
