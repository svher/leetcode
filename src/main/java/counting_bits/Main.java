package counting_bits;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int[] res = solution.countBits(5);
        System.out.println(Arrays.toString(res));
    }
}
