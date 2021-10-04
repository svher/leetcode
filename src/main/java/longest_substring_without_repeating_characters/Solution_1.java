package longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 implements Solution {

    @Override
    // the longer sequence is valid, the narrow sequence is also valid
    // but since we want the longest sequence we simply ignore the rest
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int ans = 0;
        int prev_anchor = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            // 获取上一个元素位置，将信标和到该位置处的元素全部从 Map 中删除
            if (chars.containsKey(ch)) {
                int anchor = chars.get(ch) + 1;
                for (int j = prev_anchor; j < anchor; ++j) {
                    chars.remove(s.charAt(j));
                }
                prev_anchor = anchor;
            }
            chars.put(ch, i);
            ans = Math.max(ans, chars.size());
        }
        return ans;
    }
}
