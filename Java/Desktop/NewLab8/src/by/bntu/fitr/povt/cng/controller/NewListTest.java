package by.bntu.fitr.povt.cng.controller;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NewListTest {

    @Test
    public void split() {
        var one = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        var two = new ArrayList<>(Arrays.asList(2, 4, 7, 8));
        NewList.split(one,two);
        assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8)), one);


    }
}