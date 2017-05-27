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
        locations.add(new Location("Mahora",1));
        locations.add(new Location("Mayfair",2));
        locations.add(new Location("Akina",3));
        locations.add(new Location("Stortford Lodge",4));
        
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
        streetSet("Frederick Road",locations.get(0),locations.get(4));   //Mahora MM
        streetSet("Grove Road",locations.get(4),locations.get(1));       //MM Mayfair
        streetSet("Windsor Ave",locations.get(1),locations.get(5));      //Mayfair MA
        streetSet("Riverslea Road",locations.get(5),locations.get(2));   //MA Akina
        streetSet("Murdoch Road",locations.get(2),locations.get(6));     //Akina AS
        streetSet("Oliphant Road",locations.get(6),locations.get(3));    //AS Stortford
        streetSet("Maraekakoho Road",locations.get(3),locations.get(7)); //Stortford SM
        streetSet("Pakowhai Road",locations.get(7),locations.get(0));    //SM Mahora
        
        //Joining Nodes to Exit Nodes
        streetSetEnd("Karamu Road",locations.get(4),locations.get(9));
        streetSetEnd("Havelock Road",locations.get(5),locations.get(10));
        streetSetEnd("Railway Road",locations.get(6),locations.get(11));
        streetSetEnd("Omahu Road",locations.get(7),locations.get(8));
    }
    
    private void streetSet(String streetName,Location location1, Location location2){
        Street street1 = new Street(streetName,location1,location2);
        Street street2 = new Street(streetName,location2,location1);
        
        location1.addStreet(street1);
        location2.addStreet(street2);
        
        if(test){
            System.out.println(location1.getLocationName() + " was joined with " + location2.getLocationName() + " thur " + streetName );
            System.out.println(location2.getLocationName() + " was joined with " + location1.getLocationName() + " thur " + streetName );
        }
    }
    
    private void streetSetEnd(String streetName,Location location1, Location location2){
        Street street = new Street(streetName,location1,location2);
        
        location1.addStreet(street);

        if(test) System.out.println(location1.getLocationName() + " was joined with " + location2.getLocationName() + " thur " + streetName );
    }
    
    public String getLocationNameFromInt(int locationInt){
        for(Location l : locations){
            if(l.getLocationNumber() == (locationInt)){
                return l.getLocationName();
            }
        }
        return null;
    }
}
