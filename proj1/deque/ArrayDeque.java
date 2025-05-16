package deque;

import java.util.Iterator;

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
        nextFirst = 3;
        nextLast = 4;
    }

    public class ArrayDequeIterator implements Iterator<T> {
        int currentIndex;

        public ArrayDequeIterator() {
            currentIndex = index(nextFirst+1);
        }

        @Override
        public boolean hasNext() {
            return currentIndex != nextLast;
        }

        @Override
        public T next() {
            T returnItem = items[currentIndex];
            currentIndex = index(currentIndex+1);
            return returnItem;
        }
    }

    public int index(int i) {
        if (i > items.length-1) {
            return i % items.length;
        }
        else if (0 <= i) {
            return i;
        } else if (-items.length+1 <= i) {
            return i + items.length;
        } else {
            return index(i % items.length);
        }
    }

    public void resize(int capacity) {
        T[] alter = (T[]) new Object[capacity];
        for (int i = nextFirst+1, j = 0; i <= nextFirst+size; i++, j++) {
            alter[j] = items[index(i)];
        }
        items = alter;
        nextFirst = index(-1);
        nextLast = index(size);
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = index(nextFirst-1);
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = index(nextLast+1);
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (size < items.length / 4 && size > 8) {
            resize(items.length / 4);
        }
        nextFirst = index(nextFirst+1);
        size--;
        return items[nextFirst];
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size < items.length / 4 && size > 8) {
            resize(items.length / 4);
        }
        nextLast = index(nextLast-1);
        size--;
        return items[nextLast];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    @Override
    public T get(int index) {
        return items[index(index+nextFirst+1)];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque) {
            if (this.size != ((ArrayDeque<?>) o).size) {
                return false;
            }
            int p = this.index(nextFirst + 1), q = ((ArrayDeque<?>) o).index(nextFirst + 1);
            while (q != this.index(nextLast) && q != ((ArrayDeque<?>) o).index(nextLast)) {
                if (this.items[p] != ((ArrayDeque<?>) o).items[q]) {
                    return false;
                }
                p = index(p+1);
                q = ((ArrayDeque<?>) o).index(q+1);
            }
            return true;
        } else {
            return false;
        }
    }
}
