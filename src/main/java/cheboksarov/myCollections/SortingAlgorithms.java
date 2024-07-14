package cheboksarov.myCollections;

import java.util.Comparator;

public class SortingAlgorithms {

    public static <T> void sort(T[] arr, Comparator<Object> c) {
        if(c==null){
            bubbleSort(arr);
        }else{
            bubbleSort(arr, c);
        }
    }
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> void bubbleSort(T[] arr) {
        for(int i = 0; i < arr.length - 1 - i; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(((Comparable) arr[j]).compareTo(arr[j+1]) > 0){
                    T tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    public static void bubbleSort(Object[] arr, Comparator<Object> c) {

    }
}
