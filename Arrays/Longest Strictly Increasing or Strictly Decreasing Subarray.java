class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length, ans = 1, incCnt = 1, decCnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incCnt++;
                decCnt = 1;
            } else if (nums[i] < nums[i - 1]) {
                decCnt++;
                incCnt = 1;
            } else {
                incCnt = 1;
                decCnt = 1;
            }
            ans = Math.max(ans,Math.max(incCnt,decCnt));
        }
        return ans;
    }
}