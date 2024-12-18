import java.util.*;

// monotonic stack
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[prices.length];
        for(int i = prices.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && prices[i] < prices[s.peek()]) {
                s.pop();
            }
            ans[i] = s.isEmpty() ? prices[i] : prices[i] - prices[s.peek()];
            s.push(i);
        }
        return ans;
    }
}


class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] ans = prices.clone();
        for(int i = 0; i < prices.length; i++) {
            while(!s.isEmpty() && prices[s.peek()] >= prices[i]) {
                ans[s.peek()]  -=  prices[i];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }
}