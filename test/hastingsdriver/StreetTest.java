/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sup61
 */
public class StreetTest {
    
    public StreetTest() {
    }
    
    static Location dummyLocationStart = new Location("Start");
    static Location dummyLocationEnd = new Location("End");
    
    static Street testStreet;
    
    @BeforeClass
    public static void setUpClass() {
        testStreet = new Street("Test Road",dummyLocationStart,dummyLocationEnd);
    }
    

    /**
     * Test of getEnd method, of class Street.
     */
    @Test
    public void testGetEnd() {
        assertEquals(dummyLocationEnd,testStreet.getEnd());
    }

    /**
     * Test of getStreetName method, of class Street.
     */
    @Test
    public void testGetStreetName() {
        assertEquals("Test Road",testStreet.getStreetName());
    }
    
}
