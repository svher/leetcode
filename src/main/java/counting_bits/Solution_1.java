package counting_bits;

public class Solution_1 implements Solution {

    @Override
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i % 2);
        }
        return res;
    }
}
