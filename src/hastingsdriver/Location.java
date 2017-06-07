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
 * Uses how the Locations and Street are joined together to be able to use the
 * Counter clockwise and End node locations
 */
public class Location {
    private String locationName;
    private List<Street> connections = new ArrayList();
    
    public Location(String name){
        this.locationName = name;
    }
    
    public void addStreet(Street s){
        connections.add(s);
    }

    public String getLocationName() {
        return locationName;
    }
    
    //Return names for locations 
    public String getClockwiseStreetName(){
        return this.connections.get(0).getStreetName();
    }
    
    public String getCounterClockwiseStreetName(){
        return this.connections.get(1).getStreetName();
    }
    
    public String getEndStreetName(){
        return this.connections.get(2).getStreetName();
    }    
    
    //Return Location
    public Location getClockwiseLocation(){
        return this.connections.get(0).getEnd();
    }
    
    public Location getCounterClockwiseLocation(){
        return this.connections.get(1).getEnd();
    }
    
    public Location getEndLocation(){
        return this.connections.get(2).getEnd();
    }
}
