package cheboksarov.myCollections;

import java.util.*;

public class MyLinkedList<E> implements IMyList<E>{
    private Node<E> first;
    private Node<E> last;
    // Указывает на индекс последнего элемента, size = counter + 1
    private int counter;
    private boolean isSorted;

    public MyLinkedList(){
        this.counter = -1;
        this.isSorted = false;
    }
    public MyLinkedList(Collection<? extends E> c){
        this();
        addAll(c);
    }

    @Override
    public void add(E e) {
        if(first == null){
            first = new Node<>(null, null, e, ++counter);
            last = first;
        }else{
            Node<E> t = last;
            last = new Node<>(t, null, e, ++counter);
            t.next = last;
        }
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        for(E e : c) {
            add(e);
        }
    }

    @Override
    public void add(int index, E e) {
        checkBounds(index);
        Node<E> n = findByIndex(index);
        Node<E> newNode = new Node<>(null,null, e, index);
        if(n.prev == null){
            first = new Node<>(null, n, e, index);
            n.prev = first;
        }else{
            n.prev.next = newNode;
            newNode.prev = n.prev;
            newNode.next = n;
            n.prev = newNode;
        }
        counter++;
    }

    @Override
    public void remove(E e) {
        int idx = indexOf(e);
        remove(idx);
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        Node<E> n = findByIndex(index);
        Node<E> prev = n.prev;
        Node<E> next = n.next;
        if(prev == null && next == null){
            first = null;
            last = null;
            counter = -1;
        } else if (index == 0) {
            next.prev = null;
            first = next;
            counter--;
        } else if (index == counter) {
            prev.next = null;
            last = prev;
            counter--;
        }else{
            prev.next = next;
            next.prev = prev;
            counter--;
        }
    }

    @Override
    public E get(int index) {
        checkBounds(index);
        Node<E> n = findByIndex(index);
        if(n == null) throw new NoSuchElementException();
        return n.val;
    }

    @Override
    public E getFirst() {
        return first.val;
    }

    @Override
    public E getLast() {
        return last.val;
    }

    @Override
    public int indexOf(E e) {
        Node<E> n = first;
        int i = 0;
        while(n!= null){
            if(n.val.equals(e)) return i;
            i++;
            n = n.next;
        }
        return -1;
    }

    private Node<E> findByIndex(int index){
        Node<E> cur = first;
        int i = 0;
        while(cur!=null){
            if(i++ == index) return cur;
            cur = cur.next;
        }
        return null;
    }
    private void checkBounds(int index){
        if(index < 0 || index > counter){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public int size() {
        return counter + 1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[counter + 1];
        IMyListIterator<E> it = iterator();
        for(int i= 0; i< counter+1; i++){
            arr[i] = it.next();
        }
        return arr;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public IMyListIterator<E> iterator() {
        return new MyListIterator<>(this);
    }
    @Override
    @SuppressWarnings("unchecked")
    public void sort(){
        if(isSorted) return;
        Object[] array = this.toArray();
        SortingAlgorithms.bubbleSort(array);
        IMyListIterator<E> it = this.iterator();
        for(Object e : array){
            it.next();
            it.set((E) e);
        }
        isSorted = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyLinkedList<?> that)) return false;
        return counter == that.counter && Objects.equals(first, that.first) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, counter);
    }

    private static class Node<E>{
        Node<E> next;
        Node<E> prev;
        E val;
        public Node(Node<E> prev, Node<E> next, E val, int index) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }
}
