/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.model.Test;

import by.bntu.fitr.povt.model.Koren;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class KorenTest {
    
    public KorenTest() {
    }

    @Test
    public void testRoot() {
        
        double wait = -0.5;
        double real = Koren.root(2, 3, 1, 1);
        assertEquals(wait, real,0.1);
    }
    
}
