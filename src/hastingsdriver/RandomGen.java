/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

import java.util.Random;

/**
 *
 * @author youngj13
 */
public class RandomGen {
    Boolean test = true;
    Random generator;
    int[] locationStart = new int[5];
    String psuedo;        
    
    public RandomGen(){
        generator = new Random();
        double random = generator.nextDouble();
        
        psuedo = Double.toString(random).substring(2); //removes the 0. off the double
        
        if(test)System.out.println(psuedo);
        
        for(int i = 0; i < locationStart.length; i++){
            locationStart[i] = Integer.parseInt(psuedo.substring(i, i+2));
            if(test)System.out.println(getLocation(i));
        }
    }
    
    public int getLocation(int driverNumber){
        int i = locationStart[driverNumber];
        if(i < 25){
            i = 1;
        }else if (i < 50){
            i = 2;
        }else if (i < 75){
            i = 3;
        }else if (i < 100){
            i = 4;
        }
        return i;
    }
}
