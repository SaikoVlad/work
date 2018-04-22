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
public class MaxValueTest {
    
    public MaxValueTest() {
    }

    @Test
    public void testMaxValue() {
        
        String line = "165486";
//        int expResult = 0;
        char expResult = '8';
        int result = MaxValue.maxValue(line);
        assertEquals(expResult, result);
        
    }
    
}
