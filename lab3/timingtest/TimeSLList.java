package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // 创建三个用于存储计时信息的AList和被计时的SLList
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int n = 1000; n <= 128000; n *= 2) {
            // 初始化SLList
            SLList<Integer> test = new SLList<>();
            for (int i = 0; i < n; i++) {
                test.addLast(i);
            }

            // 创建计时器并开始计时
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < 10000; i++) {
                test.getLast();
            }

            // 停止计时并把信息存入计时信息AList
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(n);
            times.addLast(timeInSeconds);
            opCounts.addLast(10000);
        }

        // 打印信息
        printTimingTable(Ns, times, opCounts);
    }

}
