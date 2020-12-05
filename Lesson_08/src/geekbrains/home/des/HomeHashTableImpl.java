package geekbrains.home.des;

import java.util.ArrayList;
import java.util.List;

public class HomeHashTableImpl<K,V> implements  HashTable<K, V> {

    private final int maxSize;

    private final List<Node> data[];
    private int size;

    public HomeHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        data = new ArrayList[maxSize];
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);

        List list = data[index];
        Node node;
        for (Object n: list) {
            node = (Node) n;
            if (node.hashCode() == key.hashCode()){
                throw new IllegalArgumentException("Such a key already exists");
            } else {
                list.add(new Node<>(key, value));
                size++;
                return true;
            }
        }
        return false;
    }

    private int hash(K key){
        return key.hashCode() % maxSize;
    }

    @Override
    public V get(K key) {
        int index = hash(key);

        List list = data[index];
        V node;

        for (Object n: list) {
            node = (V) n;
            if (node.hashCode() == key.hashCode()){
                return node;
            }
        }

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
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }
}
