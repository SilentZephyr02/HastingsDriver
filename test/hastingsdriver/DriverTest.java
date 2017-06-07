/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

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
public class DriverTest {
    
    public DriverTest() {
    }

    Driver testDriver;
    int testNumber = 1;
    int testLocation = 2;
     
    @Before
    public void setUp() {
        testDriver = new Driver(testNumber,testLocation);
    }

    /**
     * Test of moveToLocation method and the akinaCount/ getAkinaCount
     */
    @Test
    public void testMoveToLocationAndAkina() {
        int newLocation = 2;
        testDriver.moveToLocation(newLocation);
        int result = testDriver.getLocation();
        assertEquals("Location was incorrect: ",newLocation, result);
        
        newLocation = 3;
        testDriver.moveToLocation(newLocation);
        result = testDriver.getAkinaCount();
        assertEquals("Akina Count was incorrect: ", 1 , result);
    }
}
