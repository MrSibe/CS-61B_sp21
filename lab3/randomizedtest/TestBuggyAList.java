package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        // 初始化列表
        AListNoResizing<Integer> correctAList = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        // 添加三次元素
        for (int i = 0; i < 3; i++) {
            correctAList.addLast(i);
            buggyAList.addLast(i);
        }

        // 检查是否相同
        for (int i = 0; i < 3; i++) {
            assertEquals(correctAList.removeLast(), buggyAList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                assertEquals(size1, size2);
//                System.out.println("size: " + size1);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0 && B.size() > 0) {
                    int LastNumber1 = L.getLast();
                    int LastNumber2 = B.getLast();
                    assertEquals(LastNumber1, LastNumber2);
//                    System.out.println("getLast(" + LastNumber1 + ")");
                }
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() > 0) {
                    int LastNumber1 = L.removeLast();
                    int LastNumber2 = B.removeLast();
                    assertEquals(LastNumber1, LastNumber2);
//                    System.out.println("removeLast(" + LastNumber1 + ")");
                }
            }
        }
    }
}
