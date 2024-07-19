package cheboksarov.myCollections;

import java.util.*;

public interface IMyList<E> extends Iterable<E>{
    void add(E e);
    void addAll(Collection<? extends E> c);
    void add(int index, E e);
    void remove(E e);
    void remove(int index);
    E get(int index);
    // Retrieves, but does not remove, the head (first element) of this list.
    E getFirst();
    E getLast();
    int indexOf(E e);
    int size();
    Object[] toArray();
    boolean isEmpty();
    IMyListIterator<E> iterator();
    void set(int index, E e);

    @SuppressWarnings("unchecked")
    default void sort(){
        Object[] array = this.toArray();
        SortingAlgorithms.sort(array, null);
        IMyListIterator<E> it = this.iterator();
        for(Object e : array){
            it.next();
            it.set((E) e);
        }
    }
}
