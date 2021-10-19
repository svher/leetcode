package unique_paths;

public class Solution_1 implements Solution {

    @Override
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        // 这里不用 long 会溢出
        long res = 1;
        // 公式为 (n + m)! / (n! * m!)，这里 i 选择 m + 1 或者 n + 1 都可以
        for (int i = n + 1, j = 1; i <= m + n; i++, j++) {
            // IMPORTANT FOR THIS TO WORK:
            // if we divide res by j, we already multiplied res by j consecutive numbers,
            // so we must have a number which is multiple of j
            res *= i;
            res /= j;
        }
        return (int)res;
    }
}
