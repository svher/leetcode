package decode_ways;

public class Solution_1 implements Solution {

    @Override
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int num1 = s.charAt(i - 1) - '0';
            int num2 = s.charAt(i - 2) - '0';
            int prev = num2 * 10 + num1;
            if (prev >= 10 && prev <= 26) {
                dp[i] += dp[i - 2];
            }
            if (num1 > 0) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n];
    }
}
