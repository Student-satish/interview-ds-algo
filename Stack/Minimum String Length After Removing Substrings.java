import java.util.*;
class Solution {
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int minLen = n;
        for(int i = 0; i < n; i++) {
            if(!stack.isEmpty() && ((stack.peek() == 'A' && s.charAt(i) == 'B') || (stack.peek() == 'C' && s.charAt(i) == 'D'))) {
                minLen -= 2;
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return minLen;
    }
}
