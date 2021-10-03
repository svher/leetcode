package top_k_frequent_elements;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int[] res = solution.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(res));
    }
}
