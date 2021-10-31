package longest_palindromic_substring;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        String ans = solution.longestPalindrome("aacabdkacaa");
        System.out.println(ans);
    }
}
