package others.kmp;

import java.util.ArrayList;
import java.util.List;

public class KMP {

    private final int[] T;
    private final String pattern;

    public KMP(String pattern) {
        this.pattern = pattern;
        this.T = new int[pattern.length() + 1];
        buildTable();
    }

    public List<Integer> search(String str) {
        int n = str.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 0; i < n;) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    ans.add(i - j);
                    j = T[j];
                }
            } else {
                j = T[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        return ans;
    }

    private void buildTable() {
        T[0] = -1;
        int i = 1, j = 0;

        for (; i < pattern.length(); i++, j++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                T[i] = T[j];
            } else {
                T[i] = j;
                while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = T[j];
                }
            }
        }
        T[pattern.length()] = j;
    }
}
