import java.util.*;
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int  n = nums.length;
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            int x = nums[i] - k , y = nums[i] + k;
            intervals[i][0] = x;
            intervals[i][1] = y;
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        Deque<int[]> dq = new ArrayDeque<>();
        int ans = 0;
        for(int[] interval: intervals) {
            int start = interval[0] , end = interval[1];
            while(dq.size() > 0 && dq.peekFirst()[1] < start) {
                dq.pollFirst();
            }
            dq.offerLast(new int[]{start,end});
            ans = Math.max(ans,dq.size());
        }
        return ans;
    }
}
