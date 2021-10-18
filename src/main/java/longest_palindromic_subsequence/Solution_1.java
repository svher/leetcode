package longest_palindromic_subsequence;

public class Solution_1 implements Solution {

    @Override
    public int longestPalindromeSubseq(String s) {
        int[] dp = new int[s.length()];
        int n = s.length();
        // 矩阵从下往上遍历
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int tmp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = tmp;
            }
        }
        return dp[n - 1];
    }
}
