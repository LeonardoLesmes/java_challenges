package challenges.textnumber;

import java.util.Scanner;

public class TextToNumber {

    public static void main(String[] args) {
        textToNumber();
    }

    public static void textToNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("ENTER THE NUMBER: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("exit") || input.equals("quit")) {
                break;
            }
            String[] words = input.split(" ");
            long result = 0;
            long base = 1;
            long multiplier = 1;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                boolean isMultiplier = isMultiplier(word);
                long number = getNumberValue(word);
                if (!isMultiplier) {
                    base = number;
                    if (i + 1 < words.length) {
                        continue;
                    }
                }
                else {
                    multiplier *= number;
                    if (i + 1 < words.length) {
                        String nextWord = words[i + 1];
                        if (isMultiplier(nextWord)) {
                            continue;
                        }
                        else if ((word.equals("hundred") || word.equals("h"))&& i + 1 < words.length - 1) {
                            multiplier *= 1000;
                        }
                    }
                }
                result += base * multiplier;
                base = 1;
                multiplier = 1;
            }
            System.out.println(formatter(result));
        }
        scanner.close();
    }

    private static String formatter(Long number) {
        String numberStringify = number.toString();
        StringBuilder result = new StringBuilder();
        int length = numberStringify.length();
        int init = length - (length / 3 * 3);
        result.append(numberStringify, 0, init);
        for (int i = init; i < length; i++) {
            if ((i - 1) % 3 == 0) {
                result.append(',');
            }
            result.append(numberStringify.charAt(i));
        }
        return result.toString();
    }

    private static boolean isMultiplier(String text) {
        return text.equals("hundred") || text.equals("thousand") || text.equals("million") || text.equals("billion")
                || text.equals("h") || text.equals("t") || text.equals("m") || text.equals("b");
    }

    private static long getNumberValue(String word) {
        try {
            return Integer.parseInt(word);
        }
        catch (NumberFormatException exception) {
            if (word.equals("one") || word.equals("a")) {
                return 1;
            }
            String[] values = word.split("-");
            if (values.length == 1) {
                return convertToNumber(values[0]);
            }
            long result = 0;
            for (String value : values) {
                result += convertToNumber(value);
            }
            return result;
        }
    }

    private static long convertToNumber(String word) {
        return switch (word) {
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            case "ten" -> 10;
            case "eleven" -> 11;
            case "twelve" -> 12;
            case "thirteen" -> 13;
            case "fourteen" -> 14;
            case "fifteen" -> 15;
            case "sixteen" -> 16;
            case "seventeen" -> 17;
            case "eighteen" -> 18;
            case "nineteen" -> 19;
            case "twenty" -> 20;
            case "thirty" -> 30;
            case "forty" -> 40;
            case "fifty" -> 50;
            case "sixty" -> 60;
            case "seventy" -> 70;
            case "eighty" -> 80;
            case "ninety" -> 90;
            case "hundred" -> 100;
            case "h" -> 100;
            case "thousand"-> 1000;
            case "t"-> 1000;
            case "million" -> 1000000;
            case "m" -> 1000000;
            case "billion" -> 1000000000;
            case "b" -> 1000000000;
            default -> 0;
        };
    }
}
