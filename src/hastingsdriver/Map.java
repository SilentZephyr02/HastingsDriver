/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sup61
 */
public class Map {
    List<Location> locations = new ArrayList();
    Boolean test = false;
    
    
    public Map(){
        //City Locations
        locations.add(new Location("Mahora"));
        locations.add(new Location("Mayfair"));
        locations.add(new Location("Akina"));
        locations.add(new Location("Stortford Lodge"));
        
        //Joining nodes
        locations.add(new Location("MM"));
        locations.add(new Location("MA"));
        locations.add(new Location("AS"));
        locations.add(new Location("SM"));
        
        //Exit nodes
        locations.add(new Location("Flaxmere"));
        locations.add(new Location("Napier"));
        locations.add(new Location("Havelock"));
        locations.add(new Location("Railway"));
        
        
        //Locations to Joining Nodes
        streetSetOneWay("Fredrick Road",locations.get(0),locations.get(4));
        streetSetOneWay("Grove Street",locations.get(4),locations.get(1));
        streetSetOneWay("Windsor Ave",locations.get(1),locations.get(5));
        streetSetOneWay("Riverslea Road",locations.get(5),locations.get(2));
        streetSetOneWay("Murdoch Road",locations.get(2),locations.get(6));
        streetSetOneWay("Oliaphant Road",locations.get(6),locations.get(3));
        streetSetOneWay("Maraekakoho Road",locations.get(3),locations.get(7));
        streetSetOneWay("Pakowhai Road",locations.get(7),locations.get(0));
        
        streetSetOneWayReverse("Fredrick Road",locations.get(0),locations.get(4));
        streetSetOneWayReverse("Grove Street",locations.get(4),locations.get(1));
        streetSetOneWayReverse("Windsor Ave",locations.get(1),locations.get(5));
        streetSetOneWayReverse("Riverslea Road",locations.get(5),locations.get(2));
        streetSetOneWayReverse("Murdoch Road",locations.get(2),locations.get(6));
        streetSetOneWayReverse("Oliaphant Road",locations.get(6),locations.get(3));
        streetSetOneWayReverse("Maraekakoho Road",locations.get(3),locations.get(7));
        streetSetOneWayReverse("Pakowhai Road",locations.get(7),locations.get(0));

        
        //Joining Nodes to Exit Nodes
        streetSetOneWay("Karamu Road",locations.get(4),locations.get(9));
        streetSetOneWay("Havelock Road",locations.get(5),locations.get(10));
        streetSetOneWay("Railway Road",locations.get(6),locations.get(11));
        streetSetOneWay("Omahu Road",locations.get(7),locations.get(8));
    }
    
    private void streetSetOneWay(String streetName,Location locationStart, Location locationEnd){
        Street street = new Street(streetName,locationStart,locationEnd);
        
        locationStart.addStreet(street);

        if(test) System.out.println(locationStart.getLocationName() + " was joined with " + locationEnd.getLocationName() + " via " + streetName );
    }
    
    private void streetSetOneWayReverse(String streetName,Location locationStart, Location locationEnd){
        Street street = new Street(streetName,locationEnd,locationStart);
        
        locationEnd.addStreet(street);

        if(test) System.out.println(locationStart.getLocationName() + " was joined with " + locationEnd.getLocationName() + " via " + streetName );
    }
    
    public String getLocationNameFromInt(int locationInt){
        return locations.get(locationInt-1).getLocationName();
    }
    
    public String getNextLocationName(int currentLocation,int direction){
        String newLocation = null;
        switch (direction) {
            case 1:
                newLocation = locations.get(currentLocation-1).getConnections().get(0).getEnd().getConnections().get(0).getEnd().getLocationName();
                break;
            case 2:
                newLocation = locations.get(currentLocation-1).getConnections().get(1).getEnd().getConnections().get(1).getEnd().getLocationName();
                break;
            case 3:
                newLocation = locations.get(currentLocation-1).getConnections().get(0).getEnd().getConnections().get(2).getEnd().getLocationName();
                break;
            case 4:
                newLocation = locations.get(currentLocation-1).getConnections().get(1).getEnd().getConnections().get(2).getEnd().getLocationName();
                break;
        }
        return newLocation;
    }

    
    public String getTravelledStreetNames(int currentLocation,int direction){
        String newLocation = null;
        switch (direction) {
            case 1:
                newLocation = locations.get(currentLocation-1).getConnections().get(0).getStreetName() + " and " +
                        locations.get(currentLocation-1).getConnections().get(0).getEnd().getConnections().get(0).getStreetName();
                break;
            case 2:
                newLocation = locations.get(currentLocation-1).getConnections().get(1).getStreetName() + " and " +
                        locations.get(currentLocation-1).getConnections().get(1).getEnd().getConnections().get(1).getStreetName();
                break;
            case 3:
                newLocation = locations.get(currentLocation-1).getConnections().get(0).getStreetName() + " and " +
                        locations.get(currentLocation-1).getConnections().get(0).getEnd().getConnections().get(2).getStreetName();
                break;
            case 4:
                newLocation = locations.get(currentLocation-1).getConnections().get(1).getStreetName() + " and " +
                        locations.get(currentLocation-1).getConnections().get(1).getEnd().getConnections().get(2).getStreetName();
                break;
        }
        return newLocation;
    }
    
    public int getNextLocationInt(int currentLocation,int direction){
        int newLocationInt = -1;
        switch (direction) {
            case 1:
                newLocationInt = locations.indexOf(locations.get(currentLocation-1).getConnections().get(0).getEnd().getConnections().get(0).getEnd());
                break;
            case 2:
                newLocationInt = locations.indexOf(locations.get(currentLocation-1).getConnections().get(1).getEnd().getConnections().get(1).getEnd());
                break;
            case 3:
                int g =0;
                newLocationInt = locations.indexOf(locations.get(currentLocation-1).getConnections().get(0).getEnd().getConnections().get(2).getEnd());
                break;
            case 4:
                 int gw =0;
                newLocationInt = locations.indexOf(locations.get(currentLocation-1).getConnections().get(1).getEnd().getConnections().get(2).getEnd());
                break;
        }
        return newLocationInt+1;
    }
}
