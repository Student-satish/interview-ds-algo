class Solution {
    public int maxWidthRamp(int[] nums) {
        // we have to find the element at the largest index that is greater than current element towards right side
        // approach : sliding window
        // precompute maxValues from right to left
        // step 1 : we continue extending the current window if current element is lesser than so far max element till fast index
        // step 2 we shrink current window if current element is greater than all the element from fast index to end of the array
        int n = nums.length;
        int[] maxRight = new int[n];
        int max = nums[n-1];
        for(int i = n - 1; i >= 0; i--) {
            max = Math.max(max,nums[i]);
            maxRight[i] = max;
        }
        int maxWidth = 0;
        int slow = 0 , fast = 0;
        while(fast < n) {
            if(nums[slow] <= maxRight[fast]) {
                maxWidth = Math.max(maxWidth,fast-slow);
            }else{
                slow++;
            }
            fast++;
        }
        return maxWidth;
    }
}
