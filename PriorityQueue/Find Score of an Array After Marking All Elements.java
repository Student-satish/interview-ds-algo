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
            while (!pq.isEmpty() && st.contains(pq.peek()[1])) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] top = pq.poll();
                int el = top[0], idx = top[1];
                score += el;
                if (idx + 1 < n) {
                    st.add(idx + 1);
                }
                if (idx - 1 >= 0) {
                    st.add(idx - 1);
                }
            }
        }
        return score;
    }
}