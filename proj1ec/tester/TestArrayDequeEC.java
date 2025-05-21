package tester;

import edu.princeton.cs.introcs.StdRandom;
import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void TestArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String message = "";
        for (int i = 0; i < 1000; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                sad.addLast(i);
                ads.addLast(i);
                message += "addLast(" + i + ")\n";
            } else if(numberBetweenZeroAndOne < 0.5) {
                sad.addFirst(i);
                ads.addFirst(i);
                message += "addFirst(" + i + ")\n";
            } else if (numberBetweenZeroAndOne < 0.75) {
                if (sad.isEmpty() || ads.isEmpty()) {
                    continue;
                }
                message += "removeFirst()\n";
                assertEquals(message, sad.removeFirst(), ads.removeFirst());
            } else {
                if (sad.isEmpty() || ads.isEmpty()) {
                    continue;
                }
                message += "removeLast()\n";
                assertEquals(message, sad.removeLast(), ads.removeLast());
            }
        }
    }
}
