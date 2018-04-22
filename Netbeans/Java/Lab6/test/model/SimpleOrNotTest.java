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
public class SimpleOrNotTest {
    
    public SimpleOrNotTest() {
    }

    @Test
    public void simpleOrNot() {
        int n = 7;
        assertEquals(true, SimpleOrNot.simpleOrNot(n));
    }
    
}
