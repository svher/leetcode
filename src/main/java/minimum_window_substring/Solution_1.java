package minimum_window_substring;

public class Solution_1 implements Solution {

    @Override
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int start = 0, end = 0, counter = t.length();
        int ansStart = -1, ansEnd = s.length();
        while (end < s.length()) {
            if (freq[s.charAt(end)]-- > 0) {
                counter--;
            }
            end++;
            while (counter == 0) {
                if (end - start < ansEnd - ansStart) {
                    ansStart = start;
                    ansEnd = end;
                }
                freq[s.charAt(start)]++;
                if (freq[s.charAt(start)] > 0) {
                    counter++;
                }
                start++;
            }
        }
        return ansStart == -1 ? "" : s.substring(ansStart, ansEnd);
    }
}
