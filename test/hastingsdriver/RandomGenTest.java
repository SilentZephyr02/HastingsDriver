/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastingsdriver;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author sup61
 */
public class RandomGenTest {
    
    public RandomGenTest() {
    }
    
    String testPsuedo = "7308781907032909";
    int[] locationNumber = {3,2,1,4,4};
    int[] myInt = {3,2,1,4,3,4,1,4,1,3,1,2,1,4,1,4};
    RandomGen testRandom = new RandomGen(1);

    
    @Test
    public void testGetStartLocation() {
        int result = testRandom.getStartLocation(0);
        assertEquals(result,locationNumber[0]);
        
        result = testRandom.getStartLocation(1);
        assertEquals(result,locationNumber[1]);
        
        result = testRandom.getStartLocation(2);
        assertEquals(result,locationNumber[2]);
        
        result = testRandom.getStartLocation(3);
        assertEquals(result,locationNumber[3]);
        
        result = testRandom.getStartLocation(4);
        assertEquals(result,locationNumber[4]);
    }
    
    @Test
    public void testGetAndSetLocation() {
        int result;
        for(int i = 0;  i < 15;i++){
            result = testRandom.getDirection();
            assertEquals(result,myInt[i]);
        }
    }
}
