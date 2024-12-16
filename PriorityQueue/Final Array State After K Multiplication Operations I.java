import java.util.*;
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        for(int i = 0; i < k; i++) {
            int[] info = pq.poll();
            pq.offer(new int[]{info[0]*multiplier,info[1]});
        }
        int[] ans = new int[nums.length];
        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            ans[info[1]] = info[0];
        }
        return ans;
    }
}

