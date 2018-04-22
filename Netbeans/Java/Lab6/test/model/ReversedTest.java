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
public class ReversedTest {
    
    public ReversedTest() {
    }

    @Test
    public void ReversedTest() {
        int a = 321;
        assertEquals(123, Reversed.reverser(a));
        
    }
    
}
