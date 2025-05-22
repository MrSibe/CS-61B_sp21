package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private K key;
    private V value;
    private BSTMap<K, V> left;
    private BSTMap<K, V> right;

    public BSTMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public BSTMap() {
        new BSTMap(null, null);
    }

    public void printInOrder() {
        printInOrder(this);
    }

    public void printInOrder(BSTMap<K, V> b) {
        if (b == null) {
            return;
        }
        System.out.print(value + " ");
        printInOrder(b.left);
        printInOrder(b.right);
    }

    @Override
    public void clear() {
        this.left = null;
        this.right = null;
        this.key = null;
        this.value = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(this, key);
    }

    public V get(BSTMap<K, V> b, K key) {
        if (key == null) {
            return null;
        }
        int cmp = key.compareTo(this.key);
        if (cmp > 0) {
            get(b.right, key);
        } else if (cmp == 0) {
            return value;
        } else {
            get(b.left, key);
        }
        return null;
    }

    @Override
    public int size() {
        return size(this);
    }

    public int size(BSTMap<K, V> b) {
        if (b == null) {
            return 0;
        }
        return 1 + size(b.left) + size(b.right);
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        put(this, key, value);
    }

    public void put(BSTMap<K, V> b, K key, V value) {
        if (b == null) {
            new BSTMap<>(key, value);
        }
        int cmp = key.compareTo(this.key);
        if (cmp > 0) {
            if (b != null) {
                put(b.right, key, value);
            }
        } else if (cmp < 0) {
            if (b != null) {
                put(b.left, key, value);
            }
        } else {
            if (b != null) {
                b.value = value;
            }
        }
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
