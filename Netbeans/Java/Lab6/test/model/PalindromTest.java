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
public class PalindromTest {
    
    public PalindromTest() {
    }

    @Test
    public void PalindromTest() {
        int a = 3113;
        assertEquals(true, Palindrom.getPalindrome(a));
    }
    
}
