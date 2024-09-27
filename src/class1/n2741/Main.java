package class1.n2741;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        long startTime = System.currentTimeMillis();

        // Your main program logic goes here
        int N = sc.nextInt();
        if (N <= 100_000) {
            for (int i = 1; i <= N; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("error");
        }

//        long endTime = System.currentTimeMillis();
//
//        long timeTaken = endTime - startTime;
//        System.out.println("Time: " + timeTaken + "ms");
    }
}
