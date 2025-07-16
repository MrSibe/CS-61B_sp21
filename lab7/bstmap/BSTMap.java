package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BSTNode root;
    private int size;

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode leftChild;
        private BSTNode rightChild;

        public BSTNode() {
            new BSTNode(null, null);
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return get(root, key) != null;
    }

    @Override
    public V get(K key) {
        BSTNode b = get(root, key);
        if (b == null) {
            return null;
        }
        return b.value;
    }

    private BSTNode get(BSTNode b, K key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (b == null) {
            return null;
        }
        int cmp = b.key.compareTo(key);
        if (cmp < 0) {
            return get(b.rightChild, key);
        } else if (cmp > 0) {
            return get(b.leftChild, key);
        } else {
            return b;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(K key, V value) {
        root = put(this.root, key, value);
    }

    private BSTNode put(BSTNode b, K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (b == null) {
            size++;
            return new BSTNode(key, value);
        }
        int cmp = b.key.compareTo(key);
        if (cmp < 0) {
            b.rightChild = put(b.rightChild, key, value);
        } else if (cmp > 0) {
            b.leftChild = put(b.leftChild, key, value);
        } else {
            b.value = value;
        }
        return b;
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

    public void printInOrder() {
        System.out.println("Print BSTMap in order:");
        printInOrder(this.root);
    }

    private void printInOrder(BSTNode b) {
        if (b == null) {
            return;
        }
        if (b.leftChild != null) {
            printInOrder(b.leftChild);
        }
        System.out.println(b.value);
        if (b.rightChild != null) {
            printInOrder(b.rightChild);
        }
    }
}