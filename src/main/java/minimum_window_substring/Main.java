package minimum_window_substring;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        String res = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
