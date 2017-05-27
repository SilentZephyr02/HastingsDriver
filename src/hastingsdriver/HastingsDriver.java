/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

/**
 *
 * @author sup61
 */
public class HastingsDriver {

    private static Driver myDriver;
    private static int driverNumber = 0;
    private static RandomGen randomGen;
    private static Map map;
    
   
    
    
    public static void main(String[] args) {
        map = new Map();
        randomGen = new RandomGen();
        
        myDriver = new Driver(randomGen.getLocation(driverNumber));
        
        
        myDriver.getLocation();
        
        System.out.println(stringStarterLocation(driverNumber,myDriver.getLocation()));
        
    }
      
    private static String stringStarterLocation(int driver,int location){
        String msg = "Driver " + (driver + 1) + " Started at "  + map.getLocationNameFromInt(location);
        if(location == 3) myDriver.akinaCount();
        return msg;
    } 
}
