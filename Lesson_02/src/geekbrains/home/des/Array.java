package geekbrains.home.des;

public interface Array<E> {

    void add(E obj);

    void insert(E obj, int index);

    E get(int index);

    boolean remove(E obj);
    E remove(int index);

    int indexOf(E obj);

    default boolean contains(E obj){
        return indexOf(obj) != -1;
    }

    int size();

    default boolean isEmpty(){
        return size() == 0;
    }

    void printArray();

    void trimToSize();

    void sortBubble();
    void sortSelect();
    void sortInsert();

}
