package first_missing_positive;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.firstMissingPositive(new int[] {3, 4, -1, 1});
        System.out.println(res);
    }
}
