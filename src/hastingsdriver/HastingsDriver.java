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
            System.out.println("What is your number?");
            String userString = reader.nextLine();
            int userInput;
            if (userString.matches("[0-9]{1,9}")) {//max int
                userInput = Integer.parseInt(userString);
                randomGen = new RandomGen(userInput);
                driving();
            } else {
                System.out.println("Invalid Input");
                System.out.println("Exiting Application");
                return;
            }
        }
    }

    public static void driving() {
        map = new Map();
        for (int i = 0; i < myDriver.length; i++) {
            myDriver[i] = new Driver(i + 1, randomGen.getStartLocation(i));
            printStarterLocation(myDriver[i].getNumber(), randomGen.getStartLocation(i));

            int newDirection;
            do {
                newDirection = randomGen.getDirection();              
                if(newDirection >= 3){ //if newDirection is 3 or 4 it goes to a end node
                    printTravellingPathToExit(i,newDirection);
                    //Akina count
                    System.out.println("Driver " + (i + 1) + " met with John Jamieson " + myDriver[i].getAkinaCount() + " Times(s)");
                    
                    if (myDriver[i].getAkinaCount() == 0) {
                        System.out.println("That passenger missed out!");
                    } else if (myDriver[i].getAkinaCount() >= 3) {
                        System.out.println("This driver need alot of help!");
                    }
                    
                    System.out.println("-----");
                    break;
                }else{ //else it travells to another location node
                    printTravellingPath(i,newDirection);
                    myDriver[i].moveToLocation(map.getNextLocationInt(myDriver[i].getLocation(), newDirection));
                }
            } while (newDirection <= 2);
        }
    }
    
    //Outputs "Driver (x) moving to (LocationEnd) from (LocationStart) via (Street1) and (Street2)"
    private static void printTravellingPath(int driverNumber,int direction){
        System.out.println("Driver " + (driverNumber + 1) + " moving to " + map.getNextLocationName(myDriver[driverNumber].getLocation(), direction)
            + " from " + map.getLocationNameFromInt(myDriver[driverNumber].getLocation())
            + " via " + map.getTravelledStreetNames(myDriver[driverNumber].getLocation(), direction));
    }
    
    //Outputs "Driver (x) moving to Outside City from (LocationStart) via (Street1) and (Street2)"
    //Also Outputs "Driver (x) has gone to (Napier/Flaxmere)" if aplicable
    private static void printTravellingPathToExit(int driverNumber,int direction){
        System.out.println("Driver " + (driverNumber + 1) + " moving to Outside City from " + map.getLocationNameFromInt(myDriver[driverNumber].getLocation())
            + " via " + map.getTravelledStreetNames(myDriver[driverNumber].getLocation(), direction));
        
        if((map.getNextLocationInt(myDriver[driverNumber].getLocation(), direction)==9)||(map.getNextLocationInt(myDriver[driverNumber].getLocation(), direction)==10)){
            System.out.println("Driver " + (driverNumber + 1) + " has gone to " + map.getNextLocationName(myDriver[driverNumber].getLocation(), direction));
        }
    }

    //Outputs "Driver (x) Started at (Location)"
    private static void printStarterLocation(int driverNumber, int location) {
        System.out.println("Driver " + (driverNumber) + " Started at " + map.getLocationNameFromInt(location));
    }
}