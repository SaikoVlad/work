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
public class CalculatingTest {
    
    public CalculatingTest() {
        
    }
    int rows = 3, columns = 3;
        int matrix[][] = {
        {3,2,5},
        {7,27,56},
        {23,76,44}
        };

    @Test
    public void testMinFinder() {
        assertEquals(2, Calculating.minFinder(rows, columns, matrix));
    }

    @Test
    public void testMaxFinder() {
        assertEquals(76, Calculating.maxFinder(rows, columns, matrix));
    }
    
    @Test
    public void testSortMinToMax() {
        int out[][] = {
            {2,3,5},
            {27,7,56},
            {76,23,44}
        };
        assertArrayEquals(out, Calculating.sort(rows, columns, matrix, 1));
    }
    
    @Test
    public void testSortMaxToMin() {
        int out[][] = {
            {5,3,2},
            {56,7,27},
            {44,23,76}
        };
        assertArrayEquals(out, Calculating.sort(rows, columns, matrix, 2));
    }
    
}
