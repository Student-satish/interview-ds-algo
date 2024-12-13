import java.util.*;
class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        long score = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int el = top[0], idx = top[1];
            if (st.contains(idx))
                continue;
            score += el;
            st.add(idx + 1);
            st.add(idx - 1);
        }
        return score;
    }
}