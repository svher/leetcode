package median_of_two_sorted_arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        double res = solution.findMedianSortedArrays(new int[] {2, 3}, new int[] {1});
        System.out.println(res);
    }
}
