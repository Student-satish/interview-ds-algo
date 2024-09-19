import java.util.*;
class Solution {
    public List<Integer> solve(int start, int end, String expression) {
        int len = end - start + 1;
        if (len <= 2) {
            List<Integer> temp = new ArrayList<>();
            if (len == 1) {
                temp.add(expression.charAt(start) - '0');
            } else {
                temp.add((expression.charAt(start) - '0') * 10 + expression.charAt(end) - '0');
            }
            return temp;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            char ch = expression.charAt(i);
            if (ch == '*' || ch == '-' || ch == '+') {
                List<Integer> left = solve(start, i - 1, expression);
                List<Integer> right = solve(i + 1, end, expression);
                for (int x : left) {
                    for (int y : right) {
                        if (ch == '*')
                            result.add(x * y);
                        else if (ch == '-')
                            result.add(x - y);
                        else
                            result.add(x + y);
                    }
                }
            }
        }
        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(0, expression.length() - 1, expression);
    }
}