package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private Node FirstSentinel;
    private Node LastSentinel;
    private int size;

    public class Node {
        public Node prev;
        public Node next;
        public T item;

        public Node(Node p, Node n, T i) {
            this.prev = p;
            this.next = n;
            this.item = i;
        }
    }

    public LinkedListDeque() {
        this.size = 0;
        this.FirstSentinel = new Node(null, null, null);
        this.LastSentinel = new Node(FirstSentinel, null, null);
        this.FirstSentinel.next = this.LastSentinel;
    }

    @Override
    public void addFirst(T item) {
        FirstSentinel.next.prev = new Node(FirstSentinel, FirstSentinel.next, item);
        FirstSentinel.next = FirstSentinel.next.prev;
        size++;
    }

    @Override
    public void addLast(T item) {
        LastSentinel.prev.next = new Node(LastSentinel.prev, LastSentinel, item);
        LastSentinel.prev = LastSentinel.prev.next;
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        T value = FirstSentinel.next.item;
        FirstSentinel.next.next.prev = FirstSentinel;
        FirstSentinel.next = FirstSentinel.next.next;
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        T value = LastSentinel.prev.item;
        LastSentinel.prev = LastSentinel.prev.prev;
        size--;
        return value;
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
        if (size == 0) return;
        Node p = FirstSentinel.next;
        while(p.next != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    @Override
    public T get(int index) {
        if (size == 0 || index >= size) return null;
        Node p = FirstSentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return get(index);
    }

    /**
     * 返回参数 o 是否等于该双端队列
     */
    public boolean equals(Object o) {
        return false;
    }
}
