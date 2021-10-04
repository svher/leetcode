package subarray_sum_equals_k;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.subarraySum(new int[] {1, 1, 1}, 2);
        System.out.println(res);
    }
}
