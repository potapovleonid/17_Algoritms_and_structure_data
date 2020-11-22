package geekbrains.home.des;

import java.util.ArrayList;

public class HomeHashTableImpl<K,V> implements  HashTable<K, V> {

    private final int maxSize;

    private final ArrayList[] data;
    private int size;

    public HomeHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        data = new ArrayList[maxSize];
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    private int hash(K key){
        return key.hashCode() % maxSize;
    }

    @Override
    public V get(K key) {
        return null;
    }


    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {

    }
}
