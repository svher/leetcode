package regular_expression_matching;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        boolean res = solution.isMatch("ab", ".*");
        System.out.println(res);

        res = solution.isMatch("aa", "a*");
        System.out.println(res);

        res = solution.isMatch("ab", ".*");
        System.out.println(res);

        res = solution.isMatch("aab", "c*a*b");
        System.out.println(res);
    }
}
