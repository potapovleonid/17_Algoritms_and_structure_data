package geekbrains.home.des;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoSideLinkedListImpl<E> extends LinkedListImpl<E> implements TwoSideLinkedList<E>, Iterable<E> {

    private Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size() == 1){
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removedData = super.removeFirst();
        if (isEmpty()){
            lastElement = null;
        }

        return removedData;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null){
            if (current.item.equals(value)){
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null){
            return false;
        }

        if (size == 1){
            return removeFirst() != null;
        }

        if (current == firstElement){
            firstElement = firstElement.next;
        } else if(current == lastElement){
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;


    }

    @Override
    public void insertLast(E value) {
        Node<E> entry = new Node<>(value, null);
        if (isEmpty()){
            firstElement = entry;
        } else {
            lastElement.next = entry;
        }

        lastElement = entry;
        size++;
    }


    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator<E>{

        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            int newCursor = cursor;
            if (newCursor >= size){
                throw new NoSuchElementException("My Two Side Linked List " +
                        "caused an error when the cursor was out of the array");
            }

            if (cursor == 0){
                return firstElement.item;
            }

            Node<E> returnItem = firstElement;

            for (int i = 0; i < newCursor; i++) {
                returnItem = returnItem.next;
            }

            return returnItem.item;

        }
    }
}
