package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // 创建三个用于存储计时信息的AList和被计时的AList
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        // 开始计时测试（坏的addLast）
//        for (int i = 1000; i <= 128000; i *= 2) {
//            int n;
//            AList<Integer> test = new AList<>();
//            // 创建计时器并开始计时
//            Stopwatch sw = new Stopwatch();
//            for (n = 0; n < i; n++) {
//                test.addLastBad(n);
//            }
//            // 停止计时并把信息存入计时信息AList
//            double timeInSeconds = sw.elapsedTime();
//            Ns.addLast(n);
//            times.addLast(timeInSeconds);
//            opCounts.addLast(n);
//        }

        // 开始计时测试（好的addLast）
        for (int i = 1000; i <= 128000; i *= 2) {
            int n;
            AList<Integer> test = new AList<>();
            // 创建计时器并开始计时
            Stopwatch sw = new Stopwatch();
            for (n = 0; n < i; n++) {
                test.addLast(n);
            }
            // 停止计时并把信息存入计时信息AList
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(n);
            times.addLast(timeInSeconds);
            opCounts.addLast(n);
        }

        // 打印信息
        printTimingTable(Ns, times, opCounts);
    }
}
