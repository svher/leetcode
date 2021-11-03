package string_to_integer;

public class Solution_1 implements Solution {

    @Override
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int idx = 0;
        boolean positive = true;
        int n = s.length();
        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            positive = s.charAt(idx) == '+';
            idx++;
        }

        int ans = 0;
        while (idx < s.length()) {
            int digit = s.charAt(idx) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            // IMPORTANT: works even when s equals "-2147483647" or "-2147483648"
            if ((Integer.MAX_VALUE - digit) / 10 < ans) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return positive ? ans : -ans;
    }
}
