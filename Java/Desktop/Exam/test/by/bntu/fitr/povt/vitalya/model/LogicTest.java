package by.bntu.fitr.povt.vitalya.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void even() {
        int actual = 16;
        boolean expect = true;
        assertEquals(Logic.even(actual), expect);
    }
}