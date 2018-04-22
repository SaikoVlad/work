/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class NodAndNokFinderTest {
    
    public NodAndNokFinderTest() {
    }

    @Test
    public void testFinderOfNod() {
        
        int a = 23;
        int b = 37;
        int expResult = 1;
        int result = NodAndNokFinder.finderOfNod(a, b);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testFinderOfNok() {
        
        int a = 648;
        int b = 34;
        int expResult = 11016;
        int result = NodAndNokFinder.finderOfNok(a, b);
        assertEquals(expResult, result);
        
    }
    
}
