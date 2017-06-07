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
public class MapTest {
    
    public MapTest() {
    }
    
    static Map testMap;
    
    @BeforeClass
    public static void setUpClass() {
        testMap = new Map();
    }

    @Test
    public void testGetLocationNameFromInt() {
        String result = testMap.getLocationNameFromInt(1);
        assertEquals("Mahora",result);
        result = testMap.getLocationNameFromInt(2);
        assertEquals("Mayfair",result);
        result = testMap.getLocationNameFromInt(3);
        assertEquals("Akina",result);
        result = testMap.getLocationNameFromInt(4);
        assertEquals("Stortford Lodge",result);
    }

    @Test
    public void testGetNextLocationName() {
        String result = testMap.getNextLocationName(1,1);
        assertEquals("Mayfair",result);
        result = testMap.getNextLocationName(1,2);
        assertEquals("Stortford Lodge",result);
        result = testMap.getNextLocationName(1,3);
        assertEquals("Napier",result);
        result = testMap.getNextLocationName(1,4);
        assertEquals("Flaxmere",result);
    }

    @Test
    public void testGetTravelledStreetNames() {
        String result = testMap.getTravelledStreetNames(1,1);
        assertEquals("Fredrick Road and Grove Street",result);
        result = testMap.getTravelledStreetNames(1,2);
        assertEquals("Pakowhai Road and Maraekakoho Road",result);
        result = testMap.getTravelledStreetNames(1,3);
        assertEquals("Fredrick Road and Karamu Road",result);
        result = testMap.getTravelledStreetNames(1,4);
        assertEquals("Pakowhai Road and Omahu Road",result);
    }

    @Test
    public void testGetNextLocationInt() {
        int result = testMap.getNextLocationInt(1,1);
        assertEquals(2,result);
        result = testMap.getNextLocationInt(1,2);
        assertEquals(4,result);
        result = testMap.getNextLocationInt(1,3);
        assertEquals(10,result);
        result = testMap.getNextLocationInt(1,4);
        assertEquals(9,result);
    }
}
