package geekbrains.home.des;

public class LinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {

    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removeElement = firstElement;
        E data = removeElement.item;

        firstElement = firstElement.next;
        removeElement.next = null;
        removeElement.item = null;

        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {
        if (isEmpty()) {
            return false;
        }

        Node<E> current = firstElement;
        Node<E> previos = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previos = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previos.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("*******************************");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("*******************************");

    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }
}
