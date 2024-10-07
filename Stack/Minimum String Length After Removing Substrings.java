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
// in place modifcation
class Solution {
    public int minLength(String s) {
        int n = s.length();
        char[] temp = s.toCharArray();
        int i = 0; // write
        int j = 1; // read
        // whatever j read just write that on i
        for(j = 1; j < n; j++) {
            if((i >= 0) && ((temp[i] == 'A' && temp[j] == 'B') || (temp[i] == 'C' && temp[j] == 'D'))) {
                i--;
            }else{
                i++;
                temp[i] = temp[j];
            }
        }
        
        return i + 1;
    }
}
