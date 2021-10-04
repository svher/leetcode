package longest_increasing_sequence;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);

        res = solution.lengthOfLIS(new int[] {4, 10, 4, 3, 8, 9});
        System.out.println(res);
    }
}
