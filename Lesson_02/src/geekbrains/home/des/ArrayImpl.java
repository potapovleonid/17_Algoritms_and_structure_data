package geekbrains.home.des;

import java.util.Arrays;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 16;

    protected E[] data;
    protected int size;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initCapacity){
        this.data = (E[]) new Comparable[initCapacity];
    }

    private void checkAndGrow(){
        if (data.length == size){
            data = Arrays.copyOf(data, calculateNewLengthArray());
        }
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new CustomIndexOfBoundException(index, size);
        }
    }

    private int calculateNewLengthArray(){
        return size > 0 ? size * 2 : 1;
    }

    @Override
    public void add(E obj) {
        checkAndGrow();
        data[size++] = obj;
    }

    @Override
    public void insert(E obj, int index) {
        doInsert(obj, index);
    }

    private void doInsert(E obj, int index) {
        checkAndGrow();
        if (index == size){
            add(obj);
        } else {
            checkIndex(index);
            if (size - index >= 0 ){
                System.arraycopy(data, index, data, index + 1, size - index);
            }
            set(obj, index);
            size++;
        }
    }


    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void set(E obj ,int index){
        data[index] = obj;
    }

    //test знаю что неправильно, но так проще засэтить 1 массив для всех 3х сортировок
    public void setData(E[] data) {
        this.data = data;
        size = data.length;
    }

    @Override
    public boolean remove(E obj) {
        int index = indexOf(obj);
        return index != -1 && (remove(index) != null);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E removeObj = get(index);
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }

        set(null, size - 1);
        size--;
        return removeObj;

    }

    @Override
    public int indexOf(E obj) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(obj)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printArray() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void trimToSize() {
        data = Arrays.copyOf(data, size);
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size -1; j++) {
                if (get(j).compareTo(get(j+1)) > 0){
                    swapElement(j, j+1);
                }
            }
        }
    }

    private void swapElement(int srcIndex, int destinationIndex){
        E tmp = get(srcIndex);
        set(get(destinationIndex), srcIndex);
        set(tmp, destinationIndex);
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = 0; j < size; j++) {
                if (get(j).compareTo(get(minIndex)) < 0){
                    minIndex = j;
                }
            }
            swapElement(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 0; i < size; i++) {
            E tmp = get(i);
            int input = i;
            while (input > 0 && get(input - 1).compareTo(tmp) >= 0){
                set(get(input-1), input);
                input--;
            }
            set(tmp, input);
        }
    }
}
