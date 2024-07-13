import cheboksarov.myCollections.IMyList;
import cheboksarov.myCollections.IMyListIterator;
import cheboksarov.myCollections.MyLinkedList;
import cheboksarov.myCollections.MyListIterator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MyListIteratorTest {
    private IMyList<Integer> l = new MyLinkedList<>(List.of(1, 2, 3));
    @Test
    public void hasNextFuncTest(){

    }
    @Test
    public void setFuncTest(){
        IMyListIterator<Integer> it = l.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            it.set(10);
            System.out.println(Arrays.toString(l.toArray()));
        }
        assertArrayEquals(new Integer[]{10, 10, 10}, l.toArray());
    }
}
