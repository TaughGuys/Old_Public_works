import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Nkar implements Runnable {

	MyPanel mp;
	Rectangle rect;
	String path = "Pictures//";
	String pic = "sakura.jpg";

	Image img;
	Image[][] cell;

	Rectangle[][] oldRects;
	Rectangle[][] newRects;

	int[][] hinI;
	int[][] hinJ;

	boolean croped = false;
	boolean moving = false;
	boolean norQar = true;
	int w, h;
	int iw, jh;
	int n;
	int dx, dy;
	int hi, hj, ni, nj;
	int ind1, ind2;
	int sq;
	int rej;
	int kk = 0, qq = 0;
	Thread th;
	Random rr;
	CropImageFilter f;
	FilteredImageSource fis;

	public Nkar(MyPanel mp) {
		this.mp = mp;

		img = new ImageIcon(path + pic).getImage();

		n = 6;
		rej = 0;
		dx = 5;
		dy = 5;
		sq = 5;

		init();
		rr = new Random();
		th = new Thread(this);
		th.start();
	}

	private void init() {
		croped = false;
		moving = false;

		// n=Integer.parseInt(mp.mf.bp.tfQanak.getText());

		w = img.getWidth(null);
		h = img.getHeight(null);
		cell = new Image[n][n];

		hinI = new int[n][n];
		hinJ = new int[n][n];

		rect = new Rectangle(50, 50, w, h);

		iw = w / n;
		jh = h / n;

		ind1 = 0;
		ind2 = 0;

		oldRects = new Rectangle[n][n];
		newRects = new Rectangle[n][n];

		kk = 0;
		qq = 0;

		if (n < 10) {
			dx = 10;
			dy = 10;
		}
		if (n > 10) {
			dx = 5;
			dy = 5;
		}
		if (n > 20) {
			dx = 3;
			dy = 3;
		}
		if (n > 30) {
			dx = 2;
			dy = 2;
		}
		if (n > 40) {
			dx = 1;
			dy = 1;
		}
		if (n > 50) {
			dx = 0;
			dy = 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// oldRects[i][j]=new Rectangle(50+i*iw,50+j*jh,iw,jh);
				oldRects[i][j] = new Rectangle(i * (iw + dx), j * (jh + dy), iw, jh);
				newRects[i][j] = new Rectangle(700 + i * iw, 50 + j * jh, iw, jh);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				hinI[i][j] = i;
				hinJ[i][j] = j;
			}
		}

	}

	public void paint(Graphics g) {

		if (!croped) {
			// g.drawRect(rect.x, rect.y, rect.width, rect.height);
			g.drawImage(img, rect.x, rect.y, rect.width, rect.height, null);

			// JOptionPane.showMessageDialog(null, "Hasanq 2");

		} else {

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					g.drawRect(oldRects[i][j].x, oldRects[i][j].y, oldRects[i][j].width, oldRects[i][j].height);
					g.drawRect(newRects[i][j].x, newRects[i][j].y, newRects[i][j].width, newRects[i][j].height);
					g.drawImage(cell[i][j], oldRects[i][j].x, oldRects[i][j].y, oldRects[i][j].width,
							oldRects[i][j].height, null);
				}
			}
		}
	}

	public void normal() {

		init();

		mp.repaint();

	}

	public void crop() {
		// this.n=n;
		// setN(n);
		// JOptionPane.showMessageDialog(null, "croping image, n= "+n);
		n = Integer.parseInt(mp.mf.bp.tfQanak.getText());
		init();
		JPanel jp = new JPanel();
		croped = true;
		// Image mmm = img.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				f = new CropImageFilter(i * iw, j * jh, iw, jh);
				fis = new FilteredImageSource(img.getSource(), f);

				Image temp = jp.createImage(fis);
				cell[i][j] = new ImageIcon(temp).getImage();
			}
		}
	}

	public void mix() {

		int k, q;
		int t1, t2;
		Image t;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				k = rr.nextInt(n);
				q = rr.nextInt(n);

				t = cell[i][j];
				cell[i][j] = cell[k][q];
				cell[k][q] = t;

				t1 = hinI[i][j];
				hinI[i][j] = hinI[k][q];
				hinI[k][q] = t1;

				t2 = hinJ[i][j];
				hinJ[i][j] = hinJ[k][q];
				hinJ[k][q] = t2;
			}
		}
		mp.repaint();
	}

	public void vercnel(int mx, int my) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (oldRects[i][j].contains(mx, my)) {
					hi = i;
					hj = j;
					mp.selected = true;
					return;
				}
			}
		}
		mp.repaint();
	}

	public void dnel(int mx, int my) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (newRects[i][j].contains(mx, my)) {
					oldRects[hi][hj] = newRects[i][j];
					mp.selected = false;
					return;
				}
			}
		}
		mp.repaint();
	}

	public void fust() {
		rej = 0;
		if (sq >1) {
			sq--;
		}
	}

	public void slow() {
		rej = 0;
		sq += 1;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				Thread.sleep(sq);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			if (!moving)
				continue;
			if (mp.mf.bp.o == 1) {
				move1();
			} else if (mp.mf.bp.o == 2) {
				move2();
			} else if (mp.mf.bp.o == 3) {
				move3();
			}

		}
	}

	private void move1() {
		int k = hinI[ind1][ind2];
		int q = hinJ[ind1][ind2];

		if (rej == 1) {
			oldRects[ind1][ind2].x = newRects[k][q].x;
			oldRects[ind1][ind2].y = newRects[k][q].y;
             change1();
		}

		else {
			// JOptionPane.showMessageDialog(null,hinI[ind1][ind2]+"
			// "+hinJ[ind1][ind2]);
			if (oldRects[ind1][ind2].x < newRects[k][q].x) {
				oldRects[ind1][ind2].x++;
			}
			if (oldRects[ind1][ind2].y < newRects[k][q].y) {
				oldRects[ind1][ind2].y++;
			}
			if (oldRects[ind1][ind2].y > newRects[k][q].y) {
				oldRects[ind1][ind2].y--;
			}
			if (oldRects[ind1][ind2].x == newRects[k][q].x && oldRects[ind1][ind2].y == newRects[k][q].y) {
				 change1();
		    }
		}
	}

	private void change1() {
		if (ind1 < n - 1) {
			ind1++;
		} else {
			ind1 = 0;
			if (ind2 < n - 1) {
				ind2++;
			} else {
				JOptionPane.showMessageDialog(null, "Game over");
				moving = false;
				normal();
			}
		}
		
	}

	private void move2() {
		int k = hinI[ind1][ind2];
		int q = hinJ[ind1][ind2];
		// JOptionPane.showMessageDialog(null,hinI[ind1][ind2]);
		// JOptionPane.showMessageDialog(null,k+" "+q);

		if (rej == 1) {
			oldRects[ind1][ind2].x = newRects[k][q].x;
			oldRects[ind1][ind2].y = newRects[k][q].y;
			ind1 = rr.nextInt(n);
			ind2 = rr.nextInt(n);

		} else {

			if (oldRects[ind1][ind2].x < newRects[k][q].x) {
				oldRects[ind1][ind2].x++;
			}
			if (oldRects[ind1][ind2].y < newRects[k][q].y) {
				oldRects[ind1][ind2].y++;
			}
			if (oldRects[ind1][ind2].y > newRects[k][q].y) {
				oldRects[ind1][ind2].y--;
			}
			if (oldRects[ind1][ind2].x == newRects[k][q].x && oldRects[ind1][ind2].y == newRects[k][q].y) {
				ind1 = rr.nextInt(n);
				ind2 = rr.nextInt(n);

			}
		}

	}

	private void move3() {

		if (norQar) {
			norQar = false;
			boolean bb = false;

			for (ind1 = 0; ind1 < n; ind1++) {
				for (ind2 = 0; ind2 < n; ind2++) {
					if (hinI[ind1][ind2] == kk && hinJ[ind1][ind2] == qq) {
						bb = true;
						kk = hinI[ind1][ind2];
						qq = hinJ[ind1][ind2];
						break;
					}
				}
				if (bb)
					break;
			}

		}

		if (rej == 1) {
			oldRects[ind1][ind2].x = newRects[kk][qq].x;
			oldRects[ind1][ind2].y = newRects[kk][qq].y;
            change3();
			
		} else {

			if (oldRects[ind1][ind2].x < newRects[kk][qq].x) {
				oldRects[ind1][ind2].x++;
			}
			if (oldRects[ind1][ind2].y < newRects[kk][qq].y) {
				oldRects[ind1][ind2].y++;
			}
			if (oldRects[ind1][ind2].y > newRects[kk][qq].y) {
				oldRects[ind1][ind2].y--;
			}
			if (oldRects[ind1][ind2].x == newRects[kk][qq].x && oldRects[ind1][ind2].y == newRects[kk][qq].y) {
				change3();
				
			}
		}

	}

	private void change3() {
		norQar = true;
		if (kk < n - 1) {
			kk++;
		} else {
			kk = 0;
			if (qq < n - 1) {
				qq++;
			} else {
				JOptionPane.showMessageDialog(null, "Game over");
				moving = false;
				normal();
			}
		}
	}

	public void cropNum(int n) {
		this.n = n;
		cell = new Image[n][n];

		hinI = new int[n][n];
		hinJ = new int[n][n];

		iw = w / n;
		jh = h / n;

		oldRects = new Rectangle[n][n];
		newRects = new Rectangle[n][n];

		init();

	}

	public void rejim() {
		rej = 1;

	}
}