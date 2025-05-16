package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        this.comparator = c;
    }

    public T max() {
        return max(this.comparator);
    }

    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            get(0);
        }
        T maxItem = get(0);
        for (int i = 1; i < size(); i++) {
            if(c.compare(maxItem, get(i)) < 0) {
                maxItem = get(i);
            }
        }
        return maxItem;

    }
}
