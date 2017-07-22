/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import com.seaglasslookandfeel.SeaGlassLookAndFeel;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.laffy.buttons.ButtonPanel;

/**
 *
 * @author manuk
 */
public class SeaFrame extends JFrame {
    public SeaFrame(){
        try {
            UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SeaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);       
        InitComponent();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setSize(200, 200);
    }
   

    private void InitComponent() {
        //To change body of generated methods, choose Tools | Templates.
////        JButton buton;
       
        
       
      // jpan.setVisible(true);
       
        
       
                
    }
    
}
