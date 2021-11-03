package zigzag_conversion;

public class Solution_1 implements Solution {

    @Override
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < numRows; i++) {
            int topGap = 2 * i;
            int bottomGap = 2 * (numRows - i - 1);
            int j = i;
            while (j < n) {
                if (i != numRows - 1) {
                    sb.append(s.charAt(j));
                    j += bottomGap;
                }
                if (i != 0 && j < n) {
                    sb.append(s.charAt(j));
                    j += topGap;
                }
            }
        }
        return sb.toString();
    }
}
