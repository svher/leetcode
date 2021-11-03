package basic_calculator_ii;

public class Solution_1 implements Solution {

    @Override
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int ans = 0, num = 0, tmp = 0;
        char lastSign = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (i == n - 1 || (!Character.isDigit(ch) && ch != ' ')) {
                switch (lastSign) {
                    case '+':
                        ans += tmp; // merge the previous top element;
                        tmp = num; // push to stack
                        break;
                    case '-':
                        ans += tmp;
                        tmp = -num;
                        break;
                    case '*':
                        tmp *= num; // update top element
                        break;
                    case '/':
                        tmp /= num;
                        break;
                }
                lastSign = ch;
                num = 0;
            }
        }
        return ans + tmp;
    }
}
