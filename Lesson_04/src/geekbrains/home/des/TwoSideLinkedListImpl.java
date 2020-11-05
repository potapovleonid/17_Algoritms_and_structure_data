package geekbrains.home.des;


public class TwoSideLinkedListImpl<E> extends LinkedListImpl<E> implements TwoSideLinkedList<E> {

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

    }
}
