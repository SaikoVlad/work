package tests;

import by.bntu.fitr.povt.cng.model.collections.deprecated.StackMasImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackMasImplTest {

    private StackMasImpl<String> strings = new StackMasImpl<>("hello", ", ", "world");

    @Test
    public void size() {
        assertEquals(3,strings.size());
    }

    @Test
    public void push() {
        strings.push("!");
        StackMasImpl<String> temp = new StackMasImpl<>("hello", ", ", "world", "!");
        assertEquals(temp,strings);
    }

    @Test
    public void setElement() {
        strings.setElement(0,"welcome");
        StackMasImpl <String> temp = new StackMasImpl<>("welcome", ", ", "world");
        assertEquals(temp,strings);
    }

    @Test
    public void pop() {
        String exp = strings.get(strings.size() - 1);
        String real = strings.pop();
        assertEquals(exp,real);
    }

    @Test
    public void isEmpty() {
        assertEquals(false,strings.isEmpty());
    }

    @Test
    public void add() {
        StackMasImpl <String> temp = new StackMasImpl<>("hello", ", ", "world", "_");
        strings.add("_");
        assertEquals(temp,strings);
    }

    @Test
    public void collectionToArray() {
        Object [] exp = {"hello", ", ", "world"};
        Object [] real = strings.CollectionToArray();
        assertArrayEquals(exp,real);
    }

    @Test
    public void equals() {
        StackMasImpl <String> tempFalse = new StackMasImpl<>("12321314qddfsfew");
        StackMasImpl <String> tempTrue = new StackMasImpl<>("hello", ", ", "world");
        assertEquals(false, strings.equals(tempFalse));
        assertEquals(true, strings.equals(tempTrue));
    }

}