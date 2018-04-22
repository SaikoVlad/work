package test.by.bntu.fitr.povt.model;

import by.bntu.fitr.povt.model.Calculating;

import static org.junit.Assert.*;

public class CalculatingTest {

    @org.junit.Before
    public void initialize(){

    }

    @org.junit.Test
    public void minFinder()  {
        int [][]mas = {
                {3,2,5},
                {6,3,6},
                {65,1,8}
        };
        int exp = 1;
        int real = Calculating.minFinder(3, 3, mas);
        assertEquals(exp,real);
    }

    @org.junit.Test
    public void maxFinder() {
        int [][]mas = {
                {34,4,5},
                {1,25,36},
                {-5,1,-8}
        };
        int exp = 36;
        int real = Calculating.maxFinder(3,3,mas);
        assertEquals(exp,real);
    }

    @org.junit.Test
    public void sort() {
        int [][]mas = {
                {34,4,5},
                {1,25,36},
                {-5,1,-8}
        };
        int [][]exp = {
                {4,5,34},
                {25,36,1},
                {1,-8,-5}
        };
        assertArrayEquals(exp, Calculating.sort(3,3,mas,1));

    }

}