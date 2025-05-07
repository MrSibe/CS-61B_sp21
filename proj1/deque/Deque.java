package deque;

import java.util.Iterator;

public interface Deque<T> {
    /** 将类型为 T 的元素添加到双端队列的前端 */
    public void addFirst(T item);

    /** 将类型为 T 的元素添加到双端队列的后端 */
    public void addLast(T item);

    /** 移除并返回双端队列前端的元素 */
    public T removeFirst();

    /** 移除并返回双端队列末尾的元素 */
    public T removeLast();

    /** 判断是否为空 */
    public boolean isEmpty();

    /** 获取大小 */
    public int size();

    /** 打印队列元素 */
    public void printDeque();

    /** 获取给定索引位置的元素 */
    public T get(int index);
}
