package others.binary_manipulation;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(1000);
            // Elementary Yet Precise Worst-Case Analysis of Floyd’s Heap-Construction Program
            // s2(N - 1） == s2(N) + e2(N) - 1
            // very simple proof though
            // but use the Hamming weight (or popCount) and the unrolled binary search loop
            System.out.printf("%d %d\n", Integer.bitCount(val - 1), Integer.numberOfTrailingZeros(val) + Integer.bitCount(val) - 1);

            int a = Character.digit('1', 10);
            Integer.parseInt("123");
        }
    }
}
