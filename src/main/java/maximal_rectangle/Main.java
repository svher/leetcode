package maximal_rectangle;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_2();
        int res = solution.maximalRectangle(new char[][] {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}});
        System.out.println(res);

        res = solution.maximalRectangle(new char[][] {
                {'1', '1'},
                {'1', '1'}});
        System.out.println(res);

        res = solution.maximalRectangle(new char[][] {
                {'0', '1'},
                {'0', '1'}});
        System.out.println(res);
    }
}
