package challenges.dequeue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Dequeue {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = getTestNumbers();
        long startTime = System.currentTimeMillis();
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer,Integer> mem = new HashMap<>();
        int n = 100000;
        int m = 98777;
        int maxUniqueNumber = 0;
        for (int i = 0; i < n; i++) {
            int numActual = numbers.get(i);
            deque.add(numActual);
            mem.put(numActual, mem.getOrDefault(numActual, 0) + 1);
            if (deque.size() == m + 1) {
                int firstNum = deque.getFirst();
                int repeats = mem.get(firstNum);
                if (repeats == 1) {
                    mem.remove(firstNum);
                }
                else {
                    mem.put(firstNum, repeats - 1);
                }
                deque.removeFirst();
            }
            maxUniqueNumber = Math.max(maxUniqueNumber, mem.size());
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("Max unique numbers: " + maxUniqueNumber);
    }

    private static List<Integer> getTestNumbers() throws Exception {
        String inputText = Files.readString(Paths.get("src/challenges/dequeue/testCase.txt"));
        String[] inputs = inputText.split("\\s+");
        return Arrays.stream(inputs).map(Integer::parseInt).toList();
    }
}
