package edit_distance;

import java.util.Arrays;

public class Solution_1 implements Solution {

    @Override
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] cur = new int[n + 1], prev = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prev[i] = i;
            cur[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    // insertion;; deletion;; replace
                    cur[j] = Math.min(Math.min(cur[j - 1], prev[j]), prev[j - 1])+ 1;
                }
            }
            System.arraycopy(cur, 0, prev, 0, n + 1);
        }
        return cur[n];
    }
}
