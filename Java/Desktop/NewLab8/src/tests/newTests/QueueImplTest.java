package tests.newTests;

import by.bntu.fitr.povt.cng.model.collections.neww.queue.QueueImpl;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QueueImplTest {

    QueueImpl<Integer> integers = new QueueImpl<>(1,2,3,4,5,6,7,8);

    @Test
    public void enqueue() {
        QueueImpl <Integer> exp = new QueueImpl<>(1,2,3,4,5,6,7,8,9);
        integers.enqueue(9);
        assertEquals(exp,integers);
    }

    @Test
    public void dequeue() {
        QueueImpl <Integer> exp = new QueueImpl<>(2,3,4,5,6,7,8);
        integers.dequeue();
        assertEquals(exp,integers);
    }

    @Test
    public void peek() {
        QueueImpl <Integer> exp = new QueueImpl<>(1,2,3,4,5,6,7,8);
        Integer peek = integers.peek();
        assertEquals(new Integer(1), peek);
        assertEquals(exp, integers);

    }

    @Test
    public void toArray(){
        Object []exp = new Object[8];
        for (int i = 0; i < 8; i++) {
            exp[i] = i+1;
        }
        assertArrayEquals(exp,integers.toArray());
    }

    @Test
    public void size() {
        assertEquals(8, integers.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(false, integers.isEmpty());
    }

    @Test
    public void addAll(){
        QueueImpl <Integer> exp = new QueueImpl<>(1,2,3,4,5,6,7,8,-4,-3,-2,-1,0);
        integers.addAll(Arrays.asList(-4,-3,-2,-1,0));
        System.out.println(exp.equals(integers));
        assertEquals(exp.toString(),integers.toString());
    }

    @Test
    public void iterator() {
        int i = 0;
        for (Integer integer : integers) {
            i++;
        }
        assertEquals(i, integers.size());
    }

    @Test
    public void contains(){
        assertEquals(true,integers.contains(3));
        assertEquals(false, integers.contains(333111));
    }

    @Test
    public void containsAll(){
        assertEquals(true, integers.containsAll(Arrays.asList(1,2,3,4,5)));
        assertEquals(false,integers.containsAll(Arrays.asList(1,2,3,666)));
    }

}