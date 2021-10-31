package longest_palindromic_substring;

public class Solution_2 implements Solution {

    int beginIdx = 0, endIdx = 0;
    int maxLen = 0;

    @Override
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(beginIdx, endIdx + 1);
    }

    private void extend(String s, int l, int r) {
        int n = s.length();
        while (l >= 0 && r < n) {
            if (s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len > maxLen) {
                    beginIdx = l;
                    endIdx = r;
                    maxLen = len;
                }
            } else {
                break;
            }
            l--;
            r++;
        }
    }
}
