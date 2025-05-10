package deque;

public class Test {
    public static void main(String[] args) {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addLast(1);
        array.addLast(2);
        array.addFirst(3);
        array.addFirst(4);
        array.isFull();
        array.isEmpty();
        array.get(0);
    }
}
