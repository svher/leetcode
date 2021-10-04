package kth_largest_element_in_an_array;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2);
        System.out.println(res);
    }
}
