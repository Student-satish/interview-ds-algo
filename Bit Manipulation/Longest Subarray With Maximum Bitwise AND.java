class Solution {
    public int longestSubarray(int[] nums) {
        // concept
        // 1 & 1 = 1
        // 1 & 0 = 0
        // 0 & 1 = 0
        // 0 & 0 = 0
        // a & a = a
        // a & b = ans <= Math.min(a,b)
        int n = nums.length;
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        int maxLen = 1 , i = 0;
        while (i < n) {
            int count = 0;
            while(i < n && nums[i] == max) {
                count++;
                i++;
            }
            maxLen = Math.max(maxLen,count);
            count = 0;
            i++;
        }
        return maxLen;
    }
}