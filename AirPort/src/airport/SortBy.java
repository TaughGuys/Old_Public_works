/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import static airport.Metodes.array;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/** Collections.sort(arr,new SortBy(0,stDir)); 
 *
 * @author manuk
 */
public class SortBy implements Comparator<TripsWays>{
    int p=0;

    public SortBy(int p) {
        this.p=p;
        
    }

    @Override
    public int compare(TripsWays t, TripsWays t1) {
        switch(p){
        case 1:
               return t.getDestination().compareTo(t1.getDestination());
                
            case 2:
                if (t.getPrice()>t1.getPrice()){
                return 1;}
                else if (t.getPrice()<t1.getPrice()){ return -1;}
                else { return 0;}
               
            case 3:
                if (t.getTime()>t1.getTime()){
                return 1;}
                else if (t.getTime()<t1.getTime()){ return -1;}
                else { return 0;}          
            case 4:
                if (t.getFlightNumber()>t1.getFlightNumber()){
                return 1;}
                else if (t.getFlightNumber()<t1.getFlightNumber()){ return -1;}
                else { return 0;}     
            default:
                return 0;
        }
    }
} 
    

