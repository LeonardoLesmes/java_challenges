package challenges;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        NoBinomialSolution();
        BinomialSolution();
    }

    public static void NoBinomialSolution() {
        int levels = 8;
        List<Integer> level = new ArrayList<>();
        while (level.size() < levels) {
            System.out.print(" ".repeat(levels - level.size()));
            List<Integer> previous = new ArrayList<>(level);
            level.clear();
            level.addFirst(2);
            for (int i = 0; i < previous.size(); i++) {
                int next = 0;
                if (i + 1 < previous.size()) {
                    next = previous.get(i + 1);
                }
                level.add(previous.get(i) + next);
                System.out.print(level.get(i) + " ");
            }
            System.out.println(level.getLast());
        }
    }

    public static void BinomialSolution() {
        int n = 8;
        for (int line = 1; line <= n; line++) {
            for (int j = 0; j <= n - line; j++) {
                System.out.print(" ");
            }
            int k = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(k + " ");
                k = k * (line - i) / i;
            }
            System.out.println();
        }
    }
}
