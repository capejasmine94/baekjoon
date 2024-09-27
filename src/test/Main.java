package test;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // To store the color and number of each card
        List<String> colors = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        // Read 5 cards
        for (int i = 0; i < 5; i++) {
            String color = sc.next();
            int number = sc.nextInt();
            colors.add(color);
            numbers.add(number);
        }

        // Sort numbers to make checking consecutive easier
        Collections.sort(numbers);

        // Count occurrences of each color and number
        Map<String, Integer> colorCount = new HashMap<>();
        Map<Integer, Integer> numberCount = new HashMap<>();

        for (String color : colors) {
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }

        for (Integer number : numbers) {
            numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
        }

        // Get the maximum occurrences of any number and color
        int maxColorCount = Collections.max(colorCount.values());
        int maxNumberCount = Collections.max(numberCount.values());

        // Helper variables
        boolean isConsecutive = true;
        for (int i = 0; i < 4; i++) {
            if (numbers.get(i) + 1 != numbers.get(i + 1)) {
                isConsecutive = false;
                break;
            }
        }

        // Rule 1: All cards have the same color and are consecutive
        if (maxColorCount == 5 && isConsecutive) {
            System.out.println(900 + numbers.get(4));
            return;
        }

        // Rule 2: Four cards have the same number
        if (maxNumberCount == 4) {
            for (int number : numberCount.keySet()) {
                if (numberCount.get(number) == 4) {
                    System.out.println(800 + number);
                    return;
                }
            }
        }

        // Rule 3: Three cards have the same number and two cards have the same number
        if (maxNumberCount == 3 && numberCount.size() == 2) {
            int threeSame = 0, twoSame = 0;
            for (int number : numberCount.keySet()) {
                if (numberCount.get(number) == 3) {
                    threeSame = number;
                } else if (numberCount.get(number) == 2) {
                    twoSame = number;
                }
            }
            System.out.println(700 + threeSame * 10 + twoSame);
            return;
        }

        // Rule 4: All cards have the same color
        if (maxColorCount == 5) {
            System.out.println(600 + numbers.get(4));
            return;
        }

        // Rule 5: The numbers on the cards are consecutive
        if (isConsecutive) {
            System.out.println(500 + numbers.get(4));
            return;
        }

        // Rule 6: Three cards have the same number
        if (maxNumberCount == 3) {
            for (int number : numberCount.keySet()) {
                if (numberCount.get(number) == 3) {
                    System.out.println(400 + number);
                    return;
                }
            }
        }

        // Rule 7: Two cards have the same number and another two cards have the same number
        if (maxNumberCount == 2 && numberCount.size() == 3) {
            List<Integer> pairs = new ArrayList<>();
            for (int number : numberCount.keySet()) {
                if (numberCount.get(number) == 2) {
                    pairs.add(number);
                }
            }
            Collections.sort(pairs);
            System.out.println(300 + pairs.get(1) * 10 + pairs.get(0));
            return;
        }

        // Rule 8: Two cards have the same number
        if (maxNumberCount == 2) {
            for (int number : numberCount.keySet()) {
                if (numberCount.get(number) == 2) {
                    System.out.println(200 + number);
                    return;
                }
            }
        }

        // Rule 9: None of the above rules apply
        System.out.println(100 + numbers.get(4));
    }
}
