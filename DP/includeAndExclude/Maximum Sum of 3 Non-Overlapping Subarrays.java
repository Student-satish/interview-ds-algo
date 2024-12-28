class Solution {
    int[][] dp;
    int[] prefixSum;
    int n,k;
    List<Integer> ans;
    public int findMaxSum(int i,int count) {
        if(count == 0 || i + k > n) return 0;
        if(dp[i][count] != -1) {
            return dp[i][count];
        }
        int start = prefixSum[i+k] - prefixSum[i] + findMaxSum(i+k,count-1);
        int dont_start = findMaxSum(i+1,count);
        return dp[i][count] =  Math.max(start,dont_start);
    }
    public void findMaxSumPath(int i,int count) {
        if(count == 0) return;
        if(i + k > n) return;
        int start = findMaxSum(i+k,count-1) + prefixSum[i+k] - prefixSum[i];
        int dont_start = findMaxSum(i+1,count);
        if(start >= dont_start) {
            ans.add(i);
            findMaxSumPath(i+k,count-1);
        }else{
            findMaxSumPath(i+1,count);
        }
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        this.n = nums.length;
        this.k = k;
        this.ans = new ArrayList<>();
        prefixSum = new int[n+1];
        for(int i = 0; i < n; i++) {
            prefixSum[i+1] = nums[i] + prefixSum[i];
        }
        dp = new int[n][4];

        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }

        // find maxsum
        findMaxSum(0,3);
 
        // find maxsum path

        findMaxSumPath(0,3);

        return new int[]{ans.get(0),ans.get(1),ans.get(2)};

    }
}
