/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.awt.ComponentOrientation;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.*;
import java.util.Collections;

/**
 *
 * @author manuk
 */
public class Metodes {
 
   static ArrayList<TripsWays> array = new ArrayList<TripsWays>();
   static APMainFrame mainframe;
   int index=0;
  static Boolean tap;
  static ArrayList<AditionalArrays> arr = new ArrayList<AditionalArrays>();
    //AddFrame addframe;

    public Metodes(APMainFrame mainframe) {
        this.mainframe = mainframe;
        read();
//        show();
    }

    Metodes(AddFrame addframe) {
      //  this.addframe = addframe;

    }

    public Metodes() {
    }

   

    public void add(AddFrame aThis) {
        Boolean t = true;
        String des = null;
        int num = 0;
        int time = 0;
        int price = 0;
        try {
            des = aThis.txtDestination.getText();
            num = Integer.parseInt(aThis.txtNumber.getText());
            time = Integer.parseInt(aThis.txtTime.getText());
            price = Integer.parseInt(aThis.txtPrice.getText());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(aThis, "Error adding");
            t = false;
        }
        if (t) {
            
            TripsWays tw= new TripsWays(des, num, time, price);
            addToArray(tw);
            save();
            show();
            aThis.dispose();
        }
    }

    
    
    public void show() {
        String str=null;
        
        DefaultListModel listMod = new DefaultListModel();
                
        for (TripsWays TW:array){
            str=TW.toString(); 
            listMod.addElement(str);
            
        }
        mainframe.listTrain.setModel(listMod);
        this.tap=true;
      this.arr.clear();
    }

    public void searchBy() {
        DefaultListModel listMod = new DefaultListModel();
        Boolean t = true;
        int i=0;
        switch (mainframe.combSearchby.getSelectedIndex()){
            case 1:
               String str;
                 str = mainframe.txfldSearch.getText();
                for (TripsWays TW: array){
                     i++;
               if ( TW.getDestination().equals(str)){
                   listMod.addElement(TW.toString());
                   AditionalArrays add = new AditionalArrays(i);
                   this.arr.add(add);
                   t=false;}
              
                }
                JOptionPane.showMessageDialog(mainframe, "Searched by Destination");
                break;
            case 2:
               int st = Integer.parseInt( mainframe.txfldSearch.getText());
                for (TripsWays TW: array){
                    i++;
               if ( TW.getPrice()<= (st+100) && TW.getPrice()>= (st-100)   ){
                   listMod.addElement(TW.toString());
                   AditionalArrays add = new AditionalArrays(i);
                   this.arr.add(add);
                   t=false;}
                }
            JOptionPane.showMessageDialog(mainframe, "Searched by price");break;
            case 3:
                int stt = Integer.parseInt( mainframe.txfldSearch.getText());
                for (TripsWays TW: array){
                    i++;
               if ( TW.getTime()<= (stt+100) && TW.getTime()>= (stt-100) ){
                   listMod.addElement(TW.toString());
                   AditionalArrays add = new AditionalArrays(i);
                   this.arr.add(add);
                   t=false;}
                }
                JOptionPane.showMessageDialog(mainframe, "Searched by time");break;
            case 4: 
                int s = Integer.parseInt( mainframe.txfldSearch.getText());
                for (TripsWays TW: array){
                    i++;
               if ( TW.getFlightNumber()<= (s+100)&& TW.getFlightNumber()>= (s-100) ){
                   listMod.addElement(TW.toString());
                   AditionalArrays add = new AditionalArrays(i);
                   this.arr.add(add);
                   t=false;}
                }
                JOptionPane.showMessageDialog(mainframe, "Searched by Flight number");break;
            default:
                break;
        
        } if (t!=true){
            Metodes.tap=false;
            
       APMainFrame.listTrain.setModel(listMod);
//       JOptionPane.showMessageDialog(mainframe, tap);
//       JOptionPane.showMessageDialog(mainframe, arr);
        }
        else {
        JOptionPane.showMessageDialog(mainframe, "No Such items");
        }
    }

    void sortBy() {
            DefaultListModel listMod = new DefaultListModel();
        Boolean t = true;
        switch (mainframe.comboSort.getSelectedIndex()){
            case 1:
               Collections.sort(array,new SortBy(1)); 
                JOptionPane.showMessageDialog(mainframe, "Sorted by Destination");
                break;
            case 2:
                Collections.sort(array,new SortBy(2)); 
            JOptionPane.showMessageDialog(mainframe, "Sorted by price");break;
            case 3:
                 Collections.sort(array,new SortBy(3)); 
                JOptionPane.showMessageDialog(mainframe, "Sorted by time");break;
            case 4: 
                 Collections.sort(array,new SortBy(4)); 
                JOptionPane.showMessageDialog(mainframe, "Sorted by Flight number");break;
            default:
                break;
        
        } 
        show();
        //save();
    }

    void listActions() {
//        index =  mainframe.listTrain.getSelectedIndex();
        RemoveOrUptate rem = new RemoveOrUptate(mainframe, true); 
    }

    void remove() {
        if (this.tap!=false){
        array.remove(mainframe.listTrain.getSelectedIndex());}
        else {
            AditionalArrays add = new AditionalArrays();
      add=  this.arr.get(mainframe.listTrain.getSelectedIndex());
      array.remove(add.getI()-1);
        }
        show();
       save();
    }

    void update() {
        int ind = 0;
        if (this.tap!=false){
        ind =mainframe.listTrain.getSelectedIndex();
        }
        else {
            AditionalArrays add = new AditionalArrays();
      add=  this.arr.get(mainframe.listTrain.getSelectedIndex());
      ind=(add.getI()-1);
        }
        updateFrame apt= new updateFrame(mainframe, true);
        apt.updTxtDes.setText(array.get(ind).getDestination());
        apt.updTxtNum.setText(""+ array.get(ind).getFlightNumber());
        apt.updTxtPrice.setText(""+ array.get(ind).getPrice());
        apt.updTxtTime.setText(""+ array.get(ind).getTime());
        apt.visable();
    }
   
    void save() {
        try {
            FileOutputStream fos = new FileOutputStream("basa");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(array);
            
            oos.close();
            fos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainframe, "Error Saving");
        }
        JOptionPane.showMessageDialog(mainframe, "saved");
    }

     private void read() {
        try {
            FileInputStream fis = new FileInputStream("basa");
            ObjectInputStream ois = new ObjectInputStream(fis);
            array = (ArrayList<TripsWays>) ois.readObject();
            
            ois.close();
            fis.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainframe, "Erorr in reading");
        }

    }

    private void addToArray(TripsWays tw) {
            array.add(tw);
            JOptionPane.showMessageDialog(mainframe, "Added");
    }

     void updateAccept(updateFrame apt) {
         Boolean t=true;
          int ind = 0;
        if (this.tap!=false){
        ind =mainframe.listTrain.getSelectedIndex();
        }
        else {
            AditionalArrays add = new AditionalArrays();
      add=  this.arr.get(mainframe.listTrain.getSelectedIndex());
      ind=(add.getI()-1);
        }
         try{
         array.get(ind).setDestination(apt.updTxtDes.getText());
         array.get(ind).setFlightNumber(Integer.parseInt(apt.updTxtNum.getText()));
         array.get(ind).setPrice(Integer.parseInt(apt.updTxtPrice.getText()));
         array.get(ind).setTime(Integer.parseInt(apt.updTxtTime.getText()));}
         catch(Exception e ){
         JOptionPane.showMessageDialog(mainframe, "Error updating");
         t=false;
         }
         if (t){
             save();
             show();
             apt.dispose();
       JOptionPane.showMessageDialog(mainframe, "updated");}
    }
}
