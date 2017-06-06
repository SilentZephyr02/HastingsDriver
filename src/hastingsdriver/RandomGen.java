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
    private int countDirection;
    private int[] myInt;

    public RandomGen(int seed) {
        psuedoGen(seed);
        for (int i = 0; i < locationStart.length; i++) {
            locationStart[i] = Integer.parseInt(psuedo.substring(i, i + 2));
        }
        setDirection();
    }

    private void psuedoGen(int seed) {
        generator = new Random(seed);
        double random = generator.nextDouble();

        psuedo = Double.toString(random).substring(2); //removes the 0. off the double
    }

    public int getStartLocation(int driverNumber) {
        int locationNumber = locationStart[driverNumber];
        if (locationNumber < 25) {
            locationNumber = 1;
        } else if (locationNumber < 50) {
            locationNumber = 2;
        } else if (locationNumber < 75) {
            locationNumber = 3;
        } else if (locationNumber < 100) {
            locationNumber = 4;
        }
        return locationNumber;
    }

    private void setDirection() {
        myInt = new int[psuedo.length()];
        for (int i = 0; i < psuedo.length(); i++) {
            myInt[i] = Integer.parseInt(psuedo.substring(i, i + 1));
            if (myInt[i] <= 2 && myInt[i] >= 0) {
                myInt[i] = 1;
            } else if (myInt[i] <= 5 && myInt[i] >= 3) {
                myInt[i] = 2;
            } else if (myInt[i] == 6 || myInt[i] == 7) {
                myInt[i] = 3;
            } else if (myInt[i] == 8 || myInt[i] == 9) {
                myInt[i] = 4;
            }
        }
        countDirection = 0;
    }

    public int getDirection() {
        if (countDirection == 15) {
            psuedoGen(myInt[0] + myInt[1] + myInt[2] + myInt[3] + myInt[4]);
            setDirection();
        }
        countDirection++;
        return myInt[countDirection - 1];
    }
}
 
