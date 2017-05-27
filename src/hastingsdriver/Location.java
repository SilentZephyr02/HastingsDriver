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

    public List<Street> getConnections() {
        return connections;
    }
}
