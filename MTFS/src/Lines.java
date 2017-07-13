import java.awt.Color;
import java.awt.Graphics;



public class Lines implements Runnable{
	MyPanel mp;
	Asfalt asf;
	
	Thread th;
	int x0,y0,x1;

	public Lines(MyPanel mp, Asfalt asf) {
		this.mp = mp;
		this.asf = asf;
		x0=asf.x+asf.w/4;	x1=asf.x+asf.w*3/4;
		y0=0;	
		th = new Thread(this);
		th.start();
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		for (int i=0; i<15;i++){
			g.fillRect(x0, y0 + i * (60), 10, 40);
			g.fillRect(x1, y0 + i * (60), 10, 40);
		}
	}

	@Override
	public void run() {
		for(;;){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			move();
		}
		
	}

	private void move() {
	     y0+=5;
	     if(y0>50) y0=0;
		
	}
		
}
