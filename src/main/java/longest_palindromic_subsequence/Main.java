package longest_palindromic_subsequence;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int ans = solution.longestPalindromeSubseq("bbbab");
        System.out.println(ans);
    }
}
