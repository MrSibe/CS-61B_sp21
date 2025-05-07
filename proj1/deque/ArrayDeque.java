package deque;

import java.util.Iterator;
import java.util.Objects;

/** ArrayDeque
 * 采用循环双端数组实现
 * 这比双向数组实现起来舒服的多
 * */
public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void resize(int capacity) {
        T[] alter = (T[]) new Object[capacity];
        System.arraycopy(items, 0, alter, 0, size);
        items = alter;
    }

    @Override
    public void addFirst(T item) {
        items[size-1] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        items[size] = item;
        size++;
    }

    @Override
    public T removeFirst() {
        size--;
        return items[0];
    }

    @Override
    public T removeLast() {
        size--;
        return items[size+1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    @Override
    public T get(int index) {
        return items[index];
    }
}
