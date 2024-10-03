 import java.util.*;
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totSum = 0;
        for (int num : nums) {
            totSum = (totSum + num) % p;
        }
        // we have to find the minimum subarray length that has remainder equal to target remaining sum divisible by k
        // it is combination of two questions
        // subarray sum equals k
        // subarray sum divisbile by k
        int target = totSum % p;
        if (target == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0, minLen = n;
        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int need = (prefixSum - target + p) % p;
            if (map.containsKey(need)) {
                minLen = Math.min(minLen, i - map.get(need));
            }
            map.put(prefixSum, i);
        }
        return minLen == n ? -1 : minLen;

    }
}
