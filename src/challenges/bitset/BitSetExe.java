package challenges.bitset;

import java.util.BitSet;

public class BitSetExe {
    public static void main(String[] args) {
        String[] inputs = inputString.split("\n");
        String[] configs = inputs[0].split(" ");
        int size = Integer.parseInt(configs[0]);
        BitSet b1 = new BitSet(size);
        BitSet b2 = new BitSet(size);
        for (int i = 1; i < inputs.length; i++) {
            String[] input = inputs[i].split("\\s+");
            String op = input[0];
            if (input[1].equals("1")) {
                logicalOp(op, b1, b2, Integer.parseInt(input[2]));
            }
            else {
                logicalOp(op, b2, b1, Integer.parseInt(input[2]));
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }

    private static void logicalOp(String op, BitSet target, BitSet set, int index) {
        switch (op) {
            case "AND":
                target.and(set);
                break;
            case "OR":
                target.or(set);
                break;
            case "XOR":
                target.xor(set);
                break;
            case "FLIP":
                target.flip(index);
                break;
            case "SET":
                target.set(index);
                break;
        }
    }

    private static final String inputString =
            "5 4\n" +
            "AND 1 2\n" +
            "SET 1 4\n" +
            "FLIP 2 2\n" +
            "OR 2 1";
}
