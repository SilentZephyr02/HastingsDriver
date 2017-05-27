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
    private Random generator;
    private int[] locationStart = new int[5];
    private String psuedo;
    private int countdirection;
    private int[] myint;

    public RandomGen(int seed) {
        psuedoGen(seed);
        for (int i = 0; i < locationStart.length; i++) {
            locationStart[i] = Integer.parseInt(psuedo.substring(i, i + 2));
        }
        setdirection();
    }

    private void psuedoGen(int seed) {
        generator = new Random(seed);
        double random = generator.nextDouble();

        psuedo = Double.toString(random).substring(2); //removes the 0. off the double
    }

    public int getLocation(int driverNumber) {
        int i = locationStart[driverNumber];
        if (i < 25) {
            i = 1;
        } else if (i < 50) {
            i = 2;
        } else if (i < 75) {
            i = 3;
        } else if (i < 100) {
            i = 4;
        }
        return i;
    }

    private void setdirection() {
        myint = new int[psuedo.length()];
        for (int i = 0; i < psuedo.length(); i++) {
            myint[i] = Integer.parseInt(psuedo.substring(i, i + 1));
            if (myint[i] < 4 && myint[i] >= 0) {
                myint[i] = 1;
            } else if (myint[i] < 8 && myint[i] > 3) {
                myint[i] = 2;
            } else if (myint[i] == 8) {
                myint[i] = 3;
            } else if (myint[i] == 9) {
                myint[i] = 4;
            }
        }
        countdirection = 0;
    }

    public int getdirection() {
        if (countdirection == 15) {
            psuedoGen(myint[0] + myint[1] + myint[2] + myint[3]);
            setdirection();
        }
        countdirection++;
        return myint[countdirection - 1];
    }
}
 
