package valid_parentheses;

import java.util.*;

public class Solution_1 implements Solution {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
