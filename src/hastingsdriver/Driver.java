/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

/**
 *
 * @author youngj13
 */
public class Driver {
    private int driverNumber;
    private int location;
    private int akinaCount;
    
    public Driver(int number,int location){
        this.driverNumber = number;
        moveToLocation(location);
    }
    
    public int getNumber(){
        return driverNumber;
    }
    
    public void moveToLocation(int location){
        this.location = location;
        if (location == 3) akinaCount++;
    }
    
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getAkinaCount() {
        return akinaCount;
    }


}