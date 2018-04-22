/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.prostrmk.model.logic;

import by.bntu.fitr.povt.prostrmk.model.entity.SuperVector;
import by.bntu.fitr.povt.prostrmk.model.logic.VectorWorker;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prostrmk
 */
public class VectorWorkerTest {
    
    public VectorWorkerTest() {
    }
    @Test
    public void testCalcSumOfNegativeElements() {
        SuperVector vector = new SuperVector(2.31,-4.32,65.12,-5.55);
        double exp = -9.87;
        double real = VectorWorker.calcSumOfNegativeElements(vector);
        assertEquals(exp, real,0.1);
        
    }

    
    @Test
    public void testCalcMultiplicationElementsBetweenMaxAndMin() {
        SuperVector vector = new SuperVector(5.43,4.56,76.32,-53.31,5.76);
        double exp = 1;
        double real = VectorWorker.calcMultiplicationElementsBetweenMaxAndMin(vector);
        assertEquals(exp, real, 0.1);
    }
    
}
