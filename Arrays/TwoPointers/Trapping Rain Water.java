class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMaxHt = new int[n];
        int[] rightMaxHt = new int[n];
        leftMaxHt[0] = height[0];
        rightMaxHt[n-1] = height[n-1];
        for(int i = 1; i < n; i++) {
            leftMaxHt[i] = Math.max(leftMaxHt[i-1],height[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            rightMaxHt[i] = Math.max(rightMaxHt[i+1],height[i]);
        }
        int totTrappedWater = 0;
        for(int i = 0; i < n; i++) {
            totTrappedWater += Math.max((Math.min(rightMaxHt[i],leftMaxHt[i]) - height[i]),0);
        }
        return totTrappedWater;
    }
}

class Solution {
    public int trap(int[] height) {
        int l = 0 , r = height.length - 1 , leftmax = 0 , rightmax = 0 , res = 0;
        while(l <= r){
            if(height[l] <= height[r]){
                if(leftmax < height[l]){
                    leftmax = height[l];
                }else{
                    res += leftmax - height[l];
                }
                l++;
            }else{
                if(rightmax < height[r]){
                    rightmax = height[r];
                }else{
                    res += rightmax - height[r];
                }
                r--;
            }
        }
        return res;
    }
}
