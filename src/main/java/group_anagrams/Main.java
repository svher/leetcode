package group_anagrams;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        List<List<String>> res = solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res.toString());
    }
}
