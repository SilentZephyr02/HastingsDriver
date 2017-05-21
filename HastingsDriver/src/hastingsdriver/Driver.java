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
    
    public Driver(int location){
        this.location = location;
    }
    
    public void nextDriver(){
        driverNumber++;
    }
    
    public int getNumber(){
        return driverNumber;
    }
    
    public void akinaCheck(){
        akinaCount++;
    }
}
