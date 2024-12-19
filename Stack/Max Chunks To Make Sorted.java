import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        // for  every chunk store the max element
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(s.isEmpty() || arr[i] > s.peek()) {
                s.push(arr[i]);
            }else{
                int maxEle = s.peek();
                while(!s.isEmpty() && arr[i] < s.peek()) {
                    s.pop();
                }
                s.push(maxEle);
            }
        }
        return s.size();
    }
}
