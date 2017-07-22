/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.Serializable;

/**
 *
 * @author manuk
 */
public class TripsWays implements Serializable {
    private String destination;
    private int flightNumber;
    private int time;
    private int price;

    public TripsWays() {
    }

    public TripsWays(String destination, int flightNumber, int time, int price) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.time = time;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " " + destination + "    flight Number  " + flightNumber + "   Time  " + time + "    Price  " + price ;
    }
    
    
}
