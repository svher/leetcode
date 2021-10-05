package maximum_product_subarray;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution_1();
        int res = solution.maxProduct(new int[] {2, 3, -2, -4});
        System.out.println(res);
    }
}
