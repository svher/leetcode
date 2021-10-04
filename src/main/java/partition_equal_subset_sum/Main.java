package partition_equal_subset_sum;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        boolean res = solution.canPartition(new int[] {1, 5, 11, 5});
        System.out.println(res);

        res = solution.canPartition(new int[] {1, 2, 5});
        System.out.println(res);
    }
}
