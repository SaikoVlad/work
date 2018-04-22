/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.model.Test;

import by.bntu.fitr.povt.model.Data;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class DataTest {
    
    public DataTest() {
    }

    @Test
    public void testNext() {
        String expected = "2017.11.8";
        assertEquals(expected, Data.next(2017,11,7));
    }
    
    @Test
    public void testNext1() {
        String expected = "2017.11.8";
        assertEquals(expected, Data.next(2017,11,7));
    }
    
}
