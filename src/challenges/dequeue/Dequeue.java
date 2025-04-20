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
        Set<Integer> uniqueNumbers = new HashSet<>();
        int maxUniqueNumber = 0;
        int n = 100000;
        int m = 98777;
        for (int i = 0; i < n; i++) {
            int numActual = numbers.get(i);
            if (i <= m - 1) {
                // Build initial deque
                updateMem(mem, numActual);
                deque.add(numActual);
                if (i == m - 1) {
                    uniqueNumbers.addAll(deque);
                    maxUniqueNumber = uniqueNumbers.size();
                }
            }
            else {
                // Remove element and update mem & set
                int firstNum = deque.getFirst();
                int firstRepeats = mem.get(firstNum);
                if (firstRepeats == 1) {
                    uniqueNumbers.remove(firstNum);
                    mem.put(firstNum, 0);
                }
                else {
                    mem.put(firstNum, firstRepeats - 1);
                }
                deque.removeFirst();

                // Add element and update mem & set
                deque.add(numActual);
                updateMem(mem, numActual);
                uniqueNumbers.add(numActual);
                maxUniqueNumber = Math.max(maxUniqueNumber, uniqueNumbers.size());
            }
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("Max unique numbers: " + maxUniqueNumber);
    }

    private static void updateMem(Map<Integer, Integer> mem, int numActual) {
        if (mem.containsKey(numActual)) {
            int repeats = mem.get(numActual);
            repeats++;
            mem.put(numActual, repeats);
        }
        else {
            mem.put(numActual, 1);
        }
    }

    private static List<Integer> getTestNumbers() throws Exception {
        String inputText = Files.readString(Paths.get("src/challenges/dequeue/testCase.txt"));
        String[] inputs = inputText.split("\\s+");
        return Arrays.stream(inputs).map(Integer::parseInt).toList();
    }
}
