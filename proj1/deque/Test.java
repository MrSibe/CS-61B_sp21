package deque;

public class Test {
    public static void main(String[] args) {
        LinkedListDeque<Integer> ad = new LinkedListDeque<>();
        for(int i = 0; i < 100; i++) {
            ad.addFirst(i);
        }
        for(Integer item: ad) {
            System.out.println(item);
        }
    }
}
