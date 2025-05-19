package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private final Node firstSentinel;
    private final Node lastSentinel;
    private int size;

    private class Node {
        private Node prev;
        private Node next;
        private T item;

        Node(Node p, Node n, T i) {
            this.prev = p;
            this.next = n;
            this.item = i;
        }
    }

    public LinkedListDeque() {
        this.size = 0;
        this.firstSentinel = new Node(null, null, null);
        this.lastSentinel = new Node(firstSentinel, null, null);
        this.firstSentinel.next = this.lastSentinel;
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node p;

        LinkedListDequeIterator() {
            p = firstSentinel.next;
        }

        @Override
        public boolean hasNext() {
            return p != lastSentinel;
        }

        @Override
        public T next() {
            T returnItem = p.item;
            p = p.next;
            return returnItem;
        }
    }

    @Override
    public void addFirst(T item) {
        firstSentinel.next.prev = new Node(firstSentinel, firstSentinel.next, item);
        firstSentinel.next = firstSentinel.next.prev;
        size++;
    }

    @Override
    public void addLast(T item) {
        lastSentinel.prev.next = new Node(lastSentinel.prev, lastSentinel, item);
        lastSentinel.prev = lastSentinel.prev.next;
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T value = firstSentinel.next.item;
        firstSentinel.next.next.prev = firstSentinel;
        firstSentinel.next = firstSentinel.next.next;
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T value = lastSentinel.prev.item;
        lastSentinel.prev = lastSentinel.prev.prev;
        lastSentinel.prev.next = lastSentinel;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (size == 0) {
            return;
        }
        Node p = firstSentinel.next;
        while (p.next != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    @Override
    public T get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        Node p = firstSentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }


    public T getRecursive(int index) {
        return get(index);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Deque) {
            if (this.size() != ((Deque<?>) o).size()) {
                return false;
            }
            for (int i = 0; i < size(); i++) {
                if (!this.get(i).equals(((Deque<?>) o).get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
