import cheboksarov.myCollections.IMyList;
import cheboksarov.myCollections.MyLinkedList;
import cheboksarov.myCollections.SortingAlgorithms;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    @Nested
    class BubbleSortTest {
        @Test
        public void basicTest(){
            Integer[] arr = new Integer[]{10, 20, 1, 3, 100, 4};
            SortingAlgorithms.bubbleSort(arr);
            System.out.println(Arrays.toString(arr));
            assertArrayEquals(new Integer[]{1, 3, 4, 10, 20, 100}, arr);
        }
    }

}
