
import java.util.*;
class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        int left = 0 , right = 0 , n = nums.length;
        long ans = 0;
        while(right < n) {
            while(!minDq.isEmpty() && nums[right] <= nums[minDq.peekLast()]) {
                minDq.pollLast();
            }
            while(!maxDq.isEmpty() && nums[right] >= nums[maxDq.peekLast()]) {
                maxDq.pollLast();
            }
            minDq.offerLast(right);
            maxDq.offerLast(right);
            while(!minDq.isEmpty() && !maxDq.isEmpty() && nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > 2) {
                int jump = Math.min(maxDq.peekFirst(),minDq.peekFirst());
                left = jump + 1;
                while(!minDq.isEmpty() && minDq.peekFirst() < left) {
                    minDq.pollFirst();
                }
                while(!maxDq.isEmpty() && maxDq.peekFirst() < left) {
                    maxDq.pollFirst();
                }
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
