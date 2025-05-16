package gh2;
import deque.ArrayDeque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHeroLite {
    public static final double CONCERT_A = 440.0;

    public static void main(String[] args) {
        // 新建吉他弦数组
        ArrayDeque<GuitarString> guitarStrings = new ArrayDeque<>();
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        // 创建每一根吉他弦
        for (int i = 0; i < keyboard.length(); i++) {
            double frequency = CONCERT_A * Math.pow(2, (i-24) / 12.0);
            guitarStrings.addLast(new GuitarString(frequency));
        }
        while (true) {

            // 检测键盘哪个按键被按下
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    guitarStrings.get(keyboard.indexOf(key)).pluck();
                }
            }

            // 创建sample
            double sample = 0.0;
            for (int i = 0; i < guitarStrings.size(); i++) {
                sample += guitarStrings.get(i).sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < guitarStrings.size(); i++) {
                guitarStrings.get(i).tic();
            }
        }
    }
}

