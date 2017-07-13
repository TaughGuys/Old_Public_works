package tetris;
import java.awt.*;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String name=JOptionPane.showInputDialog("What is your name?");
		String message=String.format("Welcome,%s,to Tetris Games!", name);
		JOptionPane.showMessageDialog(null, message);
		MyFrame fr=new MyFrame();
		
		fr.setSize(400,700);
		fr.setVisible(true);


	}

}
