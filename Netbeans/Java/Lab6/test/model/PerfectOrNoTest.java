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
public class PerfectOrNoTest {
    
    public PerfectOrNoTest() {
    }

    @Test
    public void testCheckerForPerfection() {
        System.out.println("checkerForPerfection");
        int choose = 496;
        boolean expResult = true;
        boolean result = PerfectOrNo.checkerForPerfection(choose);
        assertEquals(expResult, result);
        
    }
    
}
