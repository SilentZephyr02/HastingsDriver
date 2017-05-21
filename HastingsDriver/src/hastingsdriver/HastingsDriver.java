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
    
    public static void main(String[] args) {
        randomGen = new RandomGen();
        myDriver = new Driver(randomGen.getLocation(driverNumber));
    }
      
}
