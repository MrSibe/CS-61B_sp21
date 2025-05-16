package deque;

import java.util.Iterator;

public interface Deque<T> extends Iterable<T> {
    /** 将类型为 T 的元素添加到双端队列的前端 */
    void addFirst(T item);

    /** 将类型为 T 的元素添加到双端队列的后端 */
    void addLast(T item);

    /** 移除并返回双端队列前端的元素 */
    T removeFirst();

    /** 移除并返回双端队列末尾的元素 */
    T removeLast();

    /** 判断是否为空 */
    default boolean isEmpty() {
        return size() == 0;
    }

    /** 获取大小 */
    int size();

    /** 打印队列元素 */
    void printDeque();

    /** 获取给定索引位置的元素 */
    T get(int index);

    /** 迭代器 */
    Iterator<T> iterator();

    /** equal */
    boolean equals(Object o);
}
