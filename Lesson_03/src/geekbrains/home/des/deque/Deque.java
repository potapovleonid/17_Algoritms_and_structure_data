package geekbrains.home.des.deque;

import geekbrains.home.des.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();

}
