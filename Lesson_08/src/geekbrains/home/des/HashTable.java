package geekbrains.home.des;

public interface HashTable<K, V> {

    boolean put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();

    default boolean isEmpty(){
        return size() == 0;
    }

    void display();

    interface Entry<K,V>{

        K getKey();

        V getValue();

        void setValue(V value);

    }

}
