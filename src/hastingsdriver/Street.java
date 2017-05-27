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
public class Street {
    private String streetName;
    private Location start,end;
    
    public Street(String name,Location start,Location end){
        this.streetName = name;
        this.start = start;
        this.end = end;
    }

    public Location getEnd() {
        return end;
    }

    public String getStreetName() {
        return streetName;
    }
}
