package longest_consecutive_sequence;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2});
        System.out.println(res);
    }
}
