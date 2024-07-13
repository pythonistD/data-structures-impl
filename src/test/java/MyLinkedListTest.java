import cheboksarov.myCollections.IMyList;
import cheboksarov.myCollections.MyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTest {
    @Test
    public void createFromCollectionTest(){
       List<Integer> l = List.of(10, 20, 1, 3, 100, 4);
       IMyList<Integer> l2 = new MyLinkedList<>(l);
        Iterator<Integer> it = l2.iterator();
        for (Integer integer : l) {
            assertEquals(integer, it.next());
        }
    }
    @Test
    public void toArrayTest(){
        IMyList<Integer> l = new MyLinkedList<>(List.of(10, 20, 1, 3, 100, 4));
        assertArrayEquals(new Object[] {10, 20, 1, 3, 100, 4},  l.toArray());
    }
    @Test
    public void addToSpecificPositionMiddleTest(){
        IMyList<Integer> l = new MyLinkedList<>(List.of(10, 20, 1));
        l.add(1, 7);
        assertArrayEquals(new Object[] {10, 7, 20, 1},  l.toArray());
    }
    @Test
    public void addToSpecificPositionStartTest(){
        IMyList<Integer> l = new MyLinkedList<>(List.of(10, 20, 1));
        l.add(0, 7);
        assertArrayEquals(new Object[] {7, 10, 20, 1},  l.toArray());
    }

    @Test
    public void sortTest(){
        IMyList<Integer> l = new MyLinkedList<>(List.of(30, 1, 20, -1, 7, 26));
        l.sort();
        System.out.println(Arrays.toString(l.toArray()));
        assertArrayEquals(new Integer[] {-1, 1, 7, 20, 26, 30}, l.toArray());
    }
}
