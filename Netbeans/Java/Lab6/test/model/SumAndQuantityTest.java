/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class SumAndQuantityTest {
    
    public SumAndQuantityTest() {
    }
    
    @Test
    public void quantity(){
        int n = 13;
        assertEquals(2, SumAndQuantity.quantity(n));
    }

    @Test
    public void sumTest() {
        int n = 13;
        assertEquals(4, SumAndQuantity.sum(n));
    }
    
}
