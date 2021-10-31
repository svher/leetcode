package find_the_duplicate_number;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int ans = solution.findDuplicate(new int[] {1, 2, 3, 4, 3});
        System.out.println(ans);
    }
}
