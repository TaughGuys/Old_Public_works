import javax.swing.JFrame;




public class MyFrame extends JFrame{
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			MyPanel mp;
		public MyFrame(){
			mp = new MyPanel(this);
			add(mp);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(600,800);
			setLocation(20,10);
			setTitle("Tough Crash");
			
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			
		}
}
