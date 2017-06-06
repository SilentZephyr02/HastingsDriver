/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sup61
 */
public class LocationTest {
    
    public LocationTest() {
    }
    
    
    static Location testLoaction1;
    static Location testLoaction2;

    
    static Street street1a;
    static Street street1b;

    @BeforeClass
    public static void setUpClass() {
        testLoaction1 = new Location("Test Location 1");
        testLoaction2 = new Location("Test Location 2");
        
        street1a = new Street("Test Street",testLoaction1,testLoaction2);
        street1b = new Street("Test Street",testLoaction2,testLoaction1);
    }

    /**
     * Test of addStreet method, of class Location.
     */
    @Test
    public void testAddStreet() {
        testLoaction1.addStreet(street1a);
        testLoaction2.addStreet(street1b);
        
        assertEquals("Test Location 2",testLoaction1.getClockwiseLocation().getLocationName());
    } 
}
