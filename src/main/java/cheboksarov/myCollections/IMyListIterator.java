package cheboksarov.myCollections;

import java.util.Iterator;

public interface IMyListIterator<T> extends Iterator<T> {
    void set(T t);
    boolean hasNext();
    T next();

}
