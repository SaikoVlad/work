package tests.newTests;

import by.bntu.fitr.povt.cng.model.collections.neww.stack.LinkedStack;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedStackTest {

    LinkedStack<String> strings = new LinkedStack<>("link", "ed", "stack");
    int size = 3;
    @Test
    public void size() {
        assertEquals(3,strings.size());
    }

    @Test
    public void add() {
        strings.push("!");
        assertEquals(strings, new LinkedStack<>("link", "ed", "stack", "!"));
    }

    @Test
    public void peek() {
        assertEquals("stack",strings.peek());
    }

    @Test
    public void push() {
        LinkedStack<String> exp = new LinkedStack<>("link", "ed", "stack", "!!!");
        strings.push("!!!");
        assertEquals(exp,strings);
    }

    @Test
    public void pop() {
        String realStr = strings.pop();
        LinkedStack<String> expStack = new LinkedStack<>("link", "ed");
        assertEquals("stack", realStr);
        assertEquals(expStack, strings);
    }

    @Test
    public void iterator() {
        int i = 0;
        for (String string : strings) {
            i++;
        }
        assertEquals(i, size);
    }

    @Test
    public void equals() {
        assertFalse(strings.equals(new LinkedStack<>("ed","asdd","gagaga")));
    }
}