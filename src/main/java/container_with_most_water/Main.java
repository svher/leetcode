package container_with_most_water;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int ans = solution.maxArea(new int[] {4, 3, 2, 1, 4});
        System.out.println(ans);
    }
}
