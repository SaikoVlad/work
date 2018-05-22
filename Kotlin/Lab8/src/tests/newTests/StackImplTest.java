package tests.newTests;

import by.bntu.fitr.povt.cng.model.collections.neww.stack.StackImpl;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StackImplTest {

    StackImpl<Character> characters = new StackImpl<>('l','o','l');

    @Test
    public void size() {
        assertEquals(3,characters.size());
    }

    @Test
    public void push() {
        StackImpl<Character> exp = new StackImpl<>('l','o','l','1');
        characters.push('1');
        assertEquals(exp,characters);
    }

    @Test
    public void isEmpty() {
        assertEquals(false, characters.isEmpty());
    }

    @Test
    public void toArray(){
        StackImpl<Integer> integerStack = new StackImpl<>(1,2,3,4,5,6);
        Integer []integers = new Integer[6];
        for (int i = 0; i < 6; i++) {
            integers[i] = i+1;
        }
        assertArrayEquals(integers,integerStack.toArray());
    }

    @Test
    public void peek() {
        Object o = characters.peek();
        StackImpl<Character> exp = new StackImpl<>('l','o','l');
        assertEquals(exp,characters);
        assertEquals('l',o);
    }

    @Test
    public void pop() {
        StackImpl<Character> exp = new StackImpl<>('l','o');
        Character pop = characters.pop();
        assertEquals(new Character('l'),pop);
        assertEquals(exp,characters);
    }

    @Test
    public void iterator() {
        int i = 0;
        for (Character character : characters) {
            i++;
        }
        assertEquals(i,characters.size());
    }

    @Test
    public void equals() {
        StackImpl<Character> exp = new StackImpl<>('l','o','l');
        assertEquals(exp,characters);
    }

    @Test
    public void contains(){
        assertEquals(true,characters.contains('o'));
        assertEquals(false,characters.contains('`'));
    }

    @Test
    public void containsAll(){
        assertEquals(true,characters.containsAll(Arrays.asList('l','o')));
        assertEquals(false,characters.containsAll(Arrays.asList('l','b')));
    }


}