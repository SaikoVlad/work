/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.model.Test;

import by.bntu.fitr.povt.model.Dragon;
import org.junit.Test;
import static org.junit.Assert.*;


public class DragonTest {
    
    public DragonTest() {
    }

    @Test
    public void testCount() {
        String wait = "Голов: 135.\n" + "Глаз: 270.";
        String real = Dragon.count(45);
        assertEquals(wait, real);
    }
    
    @Test
    public void testCount1() {
        String wait = "Недопустимый возраст дракона!";
        String real = Dragon.count(-13);
        assertEquals(wait, real);
    }
    
    @Test
    public void testCount2() {
        String wait = "Голов: 1000.\n" +"Глаз: 2000.";
        String real = Dragon.count(500);
        assertEquals(wait, real);
    }
    
    @Test
    public void testCount3() {
        String wait = "Голов: 700.\n" + "Глаз: 1400.";
        String real = Dragon.count(250);
        assertEquals(wait, real);
    }
    
    
    
    
}
