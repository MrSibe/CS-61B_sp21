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
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public boolean isFull() {
        return this.size == items.length;
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    public void addFirst(T item) {
        // 判断是否为满，满则resize
//        if (isFull()) {
//            resize(16);
//        }
        // 赋值
        items[nextFirst] = item;
        // nextFirst指针移动
        nextFirst = nextFirst == 0 ? items.length-1 : nextFirst-1;
        size++;
    }

    @Override
    public void addLast(T item) {
        // 判断是否为满，满则resize
//        if (isFull()) {
//            resize(16);
//        }
        // 赋值
        items[nextLast] = item;
        // nextLast指针移动
        nextLast = nextLast == items.length-1 ? 0 : nextLast+1;
        size++;
    }

    @Override
    public T removeFirst() {
        size--;
        nextFirst++;
        return items[nextFirst-1];
    }

    @Override
    public T removeLast() {
        size--;
        nextLast--;
        return items[nextLast+1];
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
        for(int i = nextFirst+1; i <= nextLast-1; i++) {
            System.out.print(items[i] + " ");
        }
    }

    @Override
    public T get(int index) {
        return items[index];
    }
}
