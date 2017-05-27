/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

import java.util.Scanner;

/**
 *
 * @author youngj13
 */
public class HastingsDriver {

    private static Driver[] myDriver = new Driver[5];
    private static RandomGen randomGen;
    private static Map map;

    public static void main(String[] args) {
        while (true) {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("what is your nummber? ");
            String n = reader.nextLine();
            int userInput;
            if (n.matches("[0-9]+")) {
                System.out.println("good");
                userInput = Integer.parseInt(n);
                randomGen = new RandomGen(userInput);
                driving();
            } else {
                System.out.println("invalid input");
                return;
            }
        }
    }

    public static void driving() {
        map = new Map();
        for (int i = 0; i < myDriver.length; i++) {
            myDriver[i] = new Driver(i + 1, randomGen.getLocation(i));
            printStarterLocation(myDriver[i].getNumber(), randomGen.getLocation(i));

            int newDirection;
            do {
                newDirection = randomGen.getdirection();
                System.out.println("Driver " + (i + 1) + " moving to " + map.getNextLocationName(myDriver[i].getLocation(), newDirection)
                        + " from " + map.getLocationNameFromInt(myDriver[i].getLocation())
                        + " via " + map.getTravelledStreetNames(myDriver[i].getLocation(), newDirection));

                myDriver[i].moveToLocation(map.getNextLocationInt(myDriver[i].getLocation(), newDirection));
                // System.out.println(map.getLocationNameFromInt(myDriver[i].getLocation()));

                if (myDriver[i].getLocation() > 5) {

                    System.out.println("Driver " + (i + 1) + " has gone to Outside City");
                    //System.out.println("Driver "+ (i+1) + " has gone to " + map.getLocationNameFromInt(myDriver[i].getLocation()));

                    System.out.println("Driver " + (i + 1) + " met with Jonh Jamieson " + myDriver[i].getAkinaCount() + " Times(s)");

                    if (myDriver[i].getAkinaCount() == 0) {
                        System.out.println("That passenger missed out!");
                    } else if (myDriver[i].getAkinaCount() >= 3) {
                        System.out.println("This driver need alot of help!");
                    }

                    System.out.println("-----");
                    break;
                }
            } while (newDirection <= 2);
        }
    }

    private static void printStarterLocation(int driverNumber, int location) {
        System.out.println("Driver " + (driverNumber) + " Started at " + map.getLocationNameFromInt(location));
    }
}