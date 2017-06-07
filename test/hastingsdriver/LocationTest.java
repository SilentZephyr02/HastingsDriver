/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author sup61
 * 
 */
public class LocationTest {
    
    public LocationTest() {
    }
    
    
    static Location testLocation1;
    static Location testLocation2;

    static Street street1a;

    @BeforeClass
    public static void setUpClass() {
        testLocation1 = new Location("Test Location 1");
        testLocation2 = new Location("Test Location 2");
        
        String street1aName = "testStreet";
        
        street1a = mock(Street.class);
        when(street1a.getEnd()).thenReturn(testLocation2);
        when(street1a.getStreetName()).thenReturn(street1aName);
    }

    @Test
    public void testAddStreetAndClockwiseLocation() {
        testLocation1.addStreet(street1a);
        
        assertEquals("Test Location 2",testLocation1.getClockwiseLocation().getLocationName());
    }
    
    @Test
    public void testGetStreetName() {
        String result = testLocation1.getClockwiseStreetName();
        
        assertEquals("testStreet",result);
    }
    
}
