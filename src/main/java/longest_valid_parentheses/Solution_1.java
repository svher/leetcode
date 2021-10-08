package longest_valid_parentheses;

import java.util.Stack;

public class Solution_1 implements Solution {

    @Override
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' && stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        int cur = s.length(), ans = 0;
        while (!stack.isEmpty()) {
            ans = Math.max(cur - stack.peek() - 1, ans);
            cur = stack.pop();
        }
        return ans;
    }
}