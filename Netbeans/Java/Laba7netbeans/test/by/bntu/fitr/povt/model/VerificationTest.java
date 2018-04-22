/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class VerificationTest {
    
    public VerificationTest() {
    }

    @Test
    public void testCheckForUniquecase1() {
        //int [][]matrix,int rows,int columns, int feature
        int matrix [][] = {
            {4,6,3},
            {6,2,8},
            {1,4,8}
        };
        assertEquals(true, Verification.checkForUnique(matrix, 3, 3, 3));
    }
    
    @Test
    public void testCheckForUniquecase2() {
        //int [][]matrix,int rows,int columns, int feature
        int matrix [][] = {
            {4,6,3},
            {6,2,8},
            {1,4,8}
        };
        assertEquals(false, Verification.checkForUnique(matrix, 3, 3, 6));
    }
    
}
