/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.model.Test;

import by.bntu.fitr.povt.model.Nastroi;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class NastroiTest {
    
    public NastroiTest() {
    }

    @Test
    public void testNastroi() {
        String wait,real;
        real = Nastroi.nastroi(3);
        wait = "У тебя сейчас плохое настроение( ты о чем то сильно сожалеешь...): \n" +
                        "                                               /(￣︿￣)\\";
        assertSame(wait, real);
    }
    
}
