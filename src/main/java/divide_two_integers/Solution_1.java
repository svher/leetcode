package divide_two_integers;

public class Solution_1 implements Solution {

    @Override
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long ans = 0;
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long ldvd = Math.abs((long)dividend);
        long ldvr = Math.abs((long)divisor);
        while (ldvd >= ldvr) {
            long tmp = ldvr, m = 1;
            while (tmp << 1 < ldvd) {
                tmp <<= 1;
                m <<= 1;
            }
            ldvd -= tmp;
            ans += m;
        }
        return (int)(sign * ans);
    }
}
