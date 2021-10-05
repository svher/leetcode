package house_robber;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.rob(new int[] {1, 2, 3, 1});
        System.out.println(res);
    }
}
