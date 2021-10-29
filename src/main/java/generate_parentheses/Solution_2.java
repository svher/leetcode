package generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution_2 implements Solution {

    @Override
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisImpl(ans, "", n, n);
        return ans;
    }

    public void generateParenthesisImpl(List<String> ans, String cur, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(cur);
        }
        if (l > 0) {
            generateParenthesisImpl(ans, cur + "(", l - 1, r);
        }
        if (r > 0 && l < r) {
            generateParenthesisImpl(ans, cur + ")", l, r - 1);
        }
    }
}
