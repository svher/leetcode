package unique_paths;

public class Solution_1 implements Solution {

    @Override
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        long res = 1;
        for (int i = m + 1, j = 1; i <= m + n; i++, j++) {
            // IMPORTANT FOR THIS TO WORK:
            // if we divide res by j, we already multiplied res by j consecutive numbers,
            // so we must have a number which is multiple of j
            res *= i;
            res /= j;
        }
        return (int)res;
    }
}
