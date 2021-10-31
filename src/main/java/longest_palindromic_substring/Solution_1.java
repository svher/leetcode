package longest_palindromic_substring;

public class Solution_1 implements Solution {

    @Override
    public String longestPalindrome(String s) {
        int n = s.length();
        int beginIdx = 0, endIdx = 0;
        int maxLen = 1;
        boolean[] dp = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = true;
            boolean pre = true;
            for (int j = i + 1; j < n; j++) {
                boolean tmp = dp[j];
                dp[j] = s.charAt(i) == s.charAt(j) && pre;
                if (dp[j] && j - i + 1 > maxLen) {
                    beginIdx = i;
                    endIdx = j;
                    maxLen = j - i + 1;
                }
                pre = tmp;
            }
        }
        return s.substring(beginIdx, endIdx + 1);
    }
}
