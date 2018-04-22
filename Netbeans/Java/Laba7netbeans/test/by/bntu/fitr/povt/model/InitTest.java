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
public class InitTest {

    public InitTest() {
    }

    /**
     * Test of randomMaker method, of class Init.
     */
    @Test
    public void testRandomMaker() {
        int rows = 5, columns = 4, maxRandom = 100;
        Init massive = new Init(rows, columns);
        int matrix[][] = massive.randomMaker(rows, columns,maxRandom);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < 0 && matrix[i][j] > 100){
                    fail();
                }
            }
        }

    }

}
