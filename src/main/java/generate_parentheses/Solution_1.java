package generate_parentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1 implements Solution {

    @Override
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Collections.singletonList(""));
        for (int i = 1; i <= n; i++) {
            List<String> tmpList = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (String p0 : dp.get(j - 1)) {
                    for (String p1 : dp.get(i - j)) {
                        tmpList.add("(" + p0 + ")" + p1);
                    }
                }
            }
            dp.add(tmpList);
        }
        return dp.get(n);
    }
}
