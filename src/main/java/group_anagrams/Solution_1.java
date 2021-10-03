package group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1 implements Solution {

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] freq = new char[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            String key = new String(freq);
            List<String> res = map.getOrDefault(key, new ArrayList<>());
            res.add(str);
            map.putIfAbsent(key, res);
        }
        return new ArrayList<>(map.values());
    }
}
