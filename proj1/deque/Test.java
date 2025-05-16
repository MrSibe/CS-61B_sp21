package deque;

public class Test {
    public static void main(String[] args) {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        for(int i = 0; i < 10; i++) {
            ad1.addFirst(i);
            ad2.addFirst(i);
        }
        ad2.addFirst(100);
        ad2.addFirst(200);
        System.out.println(ad1.equals(ad2));
    }
}
