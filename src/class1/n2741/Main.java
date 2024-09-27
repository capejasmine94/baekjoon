package class1.n2741;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long startTime = System.currentTimeMillis();

        int N = sc.nextInt();
        if (N <= 100_000) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(i).append("\n");
            }
            System.out.println(sb);
        } else {
            System.out.println("error");
        }

        long endTime = System.currentTimeMillis();

        long timeTaken = endTime - startTime;
        System.out.println("Time: " + timeTaken + "ms");
    }
}
