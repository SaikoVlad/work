package tests;

import by.bntu.fitr.povt.cng.model.collections.deprecated.QueueListImpl;
import by.bntu.fitr.povt.cng.model.entity.Garland;
import by.bntu.fitr.povt.cng.model.entity.Lights;
import by.bntu.fitr.povt.cng.model.entity.StuffedToys;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

public class QueueListImplTest {

    Garland garland = new Garland(1, 1, 1, 1, 1, "123123");
    Lights lights = new Lights(2, 2, 2, 2, 2, 2);
    StuffedToys stuffedToys = new StuffedToys(3, 3, 3, "3", "man", 3);

    private QueueListImpl<Toy> toyQueueList = new QueueListImpl<>(garland, lights, stuffedToys);

    @Test
    public void size() {
        int exp = 3;
        int real = toyQueueList.size();
        assertEquals(exp, real);
    }

    @Test
    public void isEmpty() {
        boolean exp = false;
        boolean real = toyQueueList.isEmpty();
    }

    @Test
    public void contains() {
        assertEquals(true, toyQueueList.contains(garland));
    }

    @Test
    public void iterator() {
        QueueListImpl <Toy> temp = new QueueListImpl<>(garland,stuffedToys);
        Iterator iterator = toyQueueList.iterator();
        Iterator iterator1 = temp.iterator();
        assertEquals(true,!iterator.equals(iterator1));
    }

    @Test
    public void toArray() {
        Object[] exp = {garland, lights, stuffedToys};
        Object[] real = toyQueueList.toArray();
        assertArrayEquals(exp, real);

    }

    @Test
    public void collectionToArray() {
        toArray();
    }

    @Test
    public void setElement() {
        toyQueueList.setElement(0, garland);
        QueueListImpl<Toy> exp = new QueueListImpl<>(garland, garland, lights, stuffedToys);
        assertEquals(exp, toyQueueList);
    }

    @Test
    public void toArray1() {
        toArray();
    }

    @Test
    public void add() {
        QueueListImpl<Toy> temp = toyQueueList;
        toyQueueList.add(lights);
        temp.setElement(temp.size(), lights);
        assertEquals(toyQueueList, temp);
    }

    @Test
    public void get() {
        Object exp = garland;
        Object real = toyQueueList.get(0);
        assertEquals(exp, real);
    }


    @Test
    public void containsAll() {
        boolean exp = true;
        boolean real = toyQueueList.containsAll(Arrays.asList(garland,lights,stuffedToys));

//        assertEquals(exp,real);
        assertEquals(true, toyQueueList.containsAll(Arrays.asList(garland,lights,stuffedToys)));
    }

    @Test
    public void addAll() {
        QueueListImpl <Toy> temp = new QueueListImpl<>(garland,lights,stuffedToys,garland,lights,stuffedToys);
        toyQueueList.addAll(Arrays.asList(garland,lights,stuffedToys));
        assertEquals(temp,toyQueueList);
    }

    @Test
    public void removeAll() {
        QueueListImpl<Toy> temp = new QueueListImpl<>(garland);
        toyQueueList.removeAll(Arrays.asList(lights,stuffedToys));
        assertEquals(temp,toyQueueList);
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void clear() {
        toyQueueList.clear();
        assertEquals(new QueueListImpl<>(),toyQueueList);
    }

    @Test
    public void offer() {
        add();
    }




}