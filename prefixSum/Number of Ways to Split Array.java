class Solution {
    public int waysToSplitArray(int[] nums) {
        long totSum = 0;
        for(int num : nums) totSum += num;
        int validSplits = 0;
        long currSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currSum += nums[i];
            if(2 * currSum >= totSum) validSplits++;
        }
        return validSplits;
    }
}