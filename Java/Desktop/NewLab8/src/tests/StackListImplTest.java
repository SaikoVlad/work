package tests;

import by.bntu.fitr.povt.cng.model.collections.deprecated.StackListImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackListImplTest {

    private StackListImpl <Number> numbers = new StackListImpl<>(1,23,4,5);


    @Test
    public void size() {
        assertEquals(4,numbers.size());
    }

    @Test
    public void pop() {
        assertEquals(5,numbers.pop());
    }

    @Test
    public void isEmpty() {
        assertEquals(false,numbers.isEmpty());
    }

    @Test
    public void collectionToArray() {
        Object []exp = {1,23,4,5};
        Object []real = numbers.CollectionToArray();
        assertArrayEquals(exp,real);
    }

    @Test
    public void push() {
        numbers.push(123);
        StackListImpl <Number> temp = new StackListImpl<>(1,23,4,5,123);
        assertEquals(numbers,temp);

    }

    @Test
    public void equals() {
        StackListImpl <Number> tempTrue = new StackListImpl<>(1,23,4,5);
        StackListImpl <Number> tempFalse = new StackListImpl<>(1,3,74,3,7,3,67);
        assertEquals(false, numbers.equals(tempFalse));
        assertEquals(true,numbers.equals(tempTrue));
    }



}