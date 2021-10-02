package regular_expression_matching;

public class Solution_1 implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                if (!dp[0][i - 1]) {
                    break;
                }
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                } else if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = s.charAt(i) == p.charAt(j) && dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
}
