package longest_substring_without_repeating_characters;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        String s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));

        s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));

        s = "eeydgwdykpv";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
