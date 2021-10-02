package search_in_rotated_sorted_array;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int ret = solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(ret);

        ret = solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println(ret);
    }
}
