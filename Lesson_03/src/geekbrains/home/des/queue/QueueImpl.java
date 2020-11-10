package geekbrains.home.des.queue;

public class QueueImpl<E> implements Queue<E> {


    protected static final int DEFAULT_TAIL = -1;
    protected static final int DEFAULT_HEAD = 0;

    protected E[] data;
    protected int size;

    protected int tail;
    protected int head;

    @SuppressWarnings("uncheked")
    public QueueImpl(int maxSize){
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }


    @Override
    public boolean insert(E value) {
        if (isFull()){
            return false;
        }

        if (tail == data.length - 1){
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()){
            return null;
        }

        if (head == data.length){
            head = DEFAULT_HEAD;
        }

        E removeObj = data[head++];
        size--;
        return removeObj;

    }

    @Override
    public E peekHead() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }
}
