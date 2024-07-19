package cheboksarov.myCollections;

import java.util.Iterator;

public class MyListIterator<T> implements IMyListIterator<T> {
    private final IMyList<T> collection;
    private int index = 0;
    private T cur;

    public MyListIterator(IMyList<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index+1 <= collection.size();
    }

    @Override
    public T next() {
        cur = collection.get(index++);
        return cur;
    }

    @Override
    public void set(T t) {
        if(collection.isEmpty()) throw new IndexOutOfBoundsException("Collection is empty");
        int lastElIndex = index - 1;
        collection.set(lastElIndex, t);
        /*collection.add(lastElIndex, t);
        collection.remove(index);*/
    }
}
