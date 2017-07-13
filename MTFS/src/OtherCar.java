import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class OtherCar implements Runnable{
	int x, y,x1,y1,y01,x01,x11,y11, w,w1,h1,w11,h11,w01,h01, h,CarChooseer,CarChooseer01,CarChooseer1,CarChooseer11;
	int score=0;
	MyPanel mp;
	Asfalt asf;
	Thread th;
	Random r;
	Image img,img1,img01,img11;
	String path = "Pictures/";
	boolean moving=true;
	Font ft;
	Audios aud= new Audios();
	
	
	public OtherCar(MyPanel mp, Asfalt asf) {
		this.mp=mp;
		this.asf=asf;
		x = asf.x+20;
		y = 50;
		x01=asf.x+asf.w/4+50;
		y01=asf.h/2-50;		
		x1=asf.x+asf.w*3/4+50;
		y1=asf.y+asf.h;
		x11=asf.x+asf.w/2+70;
		y11=asf.h/2;
		r=new Random();
		//CarChooseer=r.nextInt(10);
		th=new Thread(this);
		th.start();
		CarChooseer=7;CarChooseer1=17;
		CarChooseer01=6;CarChooseer11=15;
		//img =new ImageIcon(path+CarChooseer+".png").getImage();
		//w = img.getWidth(null);
		//h = img.getHeight(null);
	}
	public void paint(Graphics g) {
		//g.setColor(Color.yellow);
		//g.fillRect(x, y, w, h);
		//CarChooseer=r.nextInt(10);
		ft=new Font("Arial", 11, 25);
		img01=new ImageIcon(path+CarChooseer01+".png").getImage();
		img11 =new ImageIcon(path+(CarChooseer11+11)+".png").getImage();
		img1=new ImageIcon(path+(CarChooseer1+11)+".png").getImage();
		img =new ImageIcon(path+CarChooseer+".png").getImage();
		w = img.getWidth(null);
		h = img.getHeight(null);
		w1= img1.getWidth(null);
		h1= img1.getHeight(null);
		w11= img11.getWidth(null);
		h11= img11.getHeight(null);
		w01= img01.getWidth(null);
		h01= img01.getHeight(null);
		g.drawImage(img, x, y, w, h, null);
		g.drawImage(img1, x1, y1, w1, h1, null);
		g.drawImage(img01, x01, y01, w01, h01, null);
		g.drawImage(img11, x11, y11, w11, h11, null);
		g.setColor(Color.BLACK);
		g.setFont(ft);
		g.drawString("Score "+score, asf.x+asf.w+50, 100);
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
			
			if(moving){
			 move();
			 //break;
			}else{break;}
		}
		
	}
	private void move() {
		y+=CarChooseer/2+4;
		if(y>asf.y+asf.h){
			y=0;
			score+=(CarChooseer+1);
			CarChooseer=r.nextInt(10);
			aud.play(CarChooseer);
			x =asf.x+r.nextInt(asf.w/4-50);
		}
		y1-=(CarChooseer1/2+4);
		if (y1<10){
			y1=asf.y+asf.h;
			score+=(CarChooseer1+1);
			CarChooseer1=r.nextInt(10);x1=asf.x+r.nextInt(asf.w/4-50)+asf.w*3/4;
			aud.play(CarChooseer1);
		}y11-=(CarChooseer11/2+5);
		if (y11<10){
			y11=asf.y+asf.h;
			score+=(CarChooseer11+1);
			CarChooseer11=r.nextInt(10);x11=asf.x+r.nextInt(asf.w/4-50)+asf.w/2;
			aud.play(CarChooseer11);
		}
		y01+=(CarChooseer01/2+5);
		if (y01>asf.y+asf.h){
			y01=0;
			score+=(CarChooseer01+1);
			CarChooseer01=r.nextInt(10)
					;x01=asf.x+r.nextInt(asf.w/4-50)+asf.w*1/4;
			aud.play(CarChooseer01);
		}
	}

}
