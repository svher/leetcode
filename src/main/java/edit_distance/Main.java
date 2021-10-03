package edit_distance;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.minDistance("horse", "ros");
        System.out.println(res);

        res = solution.minDistance("intention", "execution");
        System.out.println(res);

        res = solution.minDistance("", "a");
        System.out.println(res);
    }
}
