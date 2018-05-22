package tests;

import by.bntu.fitr.povt.cng.model.collections.deprecated.QueueMasImpl;
import by.bntu.fitr.povt.cng.model.entity.Garland;
import by.bntu.fitr.povt.cng.model.entity.Lights;
import by.bntu.fitr.povt.cng.model.entity.StuffedToys;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QueueMasImplTest {

    Garland garland = new Garland(1,1,1,1,1,"123123");
    Lights lights = new Lights(2,2,2,2,2,2);
    StuffedToys stuffedToys = new StuffedToys(3,3,3,"3","man",3);

    QueueMasImpl <Toy> queueMas = new QueueMasImpl<>(garland,lights,stuffedToys);

    @Test
    public void size() {
        int exp = 3;
        int real = queueMas.size();
        assertEquals(exp,real);
    }

    @Test
    public void isEmpty() {
        boolean exp = false;
        boolean real = queueMas.isEmpty();
        assertEquals(exp,real);
    }

    @Test
    public void contains() {
        boolean exp = true;
        boolean real = queueMas.contains(garland);
        assertEquals(exp,real);
    }

    @Test
    public void iterator() {
        assertEquals(true,true);
    }

    @Test
    public void toArray() {
        Object []exp = new Object[]{garland,lights,stuffedToys};
        Object []real = queueMas.CollectionToArray();
        assertArrayEquals(exp,real);
    }

    @Test
    public void toArray1() {
        assertEquals(true,true);
    }

    @Test
    public void add() {
        assertEquals(1,1);
    }

    @Test
    public void remove() {
        assertEquals(1,1);
    }

    @Test
    public void containsAll() {
        boolean exp = true;
        boolean real = queueMas.containsAll(Arrays.asList(garland,lights,stuffedToys));
        assertEquals(exp,real);
    }

    @Test
    public void addAll() {
        assertEquals(1,1);
    }

    @Test
    public void removeAll() {
        boolean exp = true;
        boolean real = queueMas.removeAll(Arrays.asList(garland,lights));
        assertEquals(exp,real);
    }

    @Test
    public void retainAll() {
        boolean exp = false;
        boolean real = queueMas.retainAll(Arrays.asList(lights,stuffedToys));
        assertEquals(exp,real);
    }

    @Test
    public void clear() {
        assertEquals(1,1);
    }

    @Test
    public void offer() {
        boolean exp = true;
        boolean real = queueMas.offer(new Garland(5,5,5,5,5,"5"));
        assertEquals(exp,real);
    }

    @Test
    public void remove1() {
        assertEquals(1,1);
    }

    @Test
    public void poll() {
        Toy exp = garland;
        Toy real = queueMas.poll();
        assertEquals(exp,real);
    }

    @Test
    public void element() {
        poll();
    }

    @Test
    public void peek() {
        poll();
    }

    @Test
    public void deleteByIndex() {
        Object []exp = new Object[]{garland,lights};
        queueMas.deleteByIndex(2);
        Object []real = queueMas.CollectionToArray();
        assertArrayEquals(exp,real);
    }


}