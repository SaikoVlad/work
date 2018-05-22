package tests.newTests;

import by.bntu.fitr.povt.cng.model.collections.neww.queue.LinkedQueue;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedQueueTest {

    LinkedQueue<Integer> integers = new LinkedQueue<>(1,2,3,4,5);
    int size = integers.size();

    @Test
    public void enqueue() {
        integers.enqueue(6);
        assertEquals(integers, new LinkedQueue<>(1,2,3,4,5,6));
    }

    @Test
    public void dequeue() {
        integers.dequeue();
        LinkedQueue exp = new LinkedQueue<>(2,3,4,5);
        assertEquals(exp, integers);
    }

    @Test
    public void peek() {
        Integer peek = integers.peek();
        assertEquals(new Integer(5),peek);
    }

    @Test
    public void size() {
        assertEquals(5,integers.size());
    }

    @Test
    public void add() {
        enqueue();
    }

    @Test
    public void iterator() {
        Iterator iterator = integers.iterator();
        int i = 0;
        while (iterator.hasNext()){
            i++;
            iterator.next();
        }
        assertEquals(i,size);

    }

    @Test
    public void equals() {
        assertEquals(integers, new LinkedQueue<>(1,2,3,4,5));
        boolean eq = integers.equals(new LinkedQueue<>(-1,-2,-3,-4,-5));
        assertFalse(eq);
    }
}