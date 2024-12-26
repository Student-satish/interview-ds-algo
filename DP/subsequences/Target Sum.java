
// first method
// s1_sum = a , remain_sum = totalSum - s1_sum , so s1_sum - remain_sum == target
class Solution {
    int[][] dp;
    int[] nums;
    int n, target, totalSum;
    public int solve(int i,int sum) {
        if(i >= n) {
            return ((totalSum - 2*sum) == target) ? 1 : 0;
        }
        if(dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int inc = solve(i+1,sum+nums[i]);
        int exc = solve(i+1,sum);
        dp[i][sum] = (inc + exc);
        return dp[i][sum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        n = nums.length;
        for(int num: nums) {
            this.totalSum += num;
        }
        this.dp = new int[n][totalSum+1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return solve(0,0);
    }
}

// second method
class Solution {
    int[][] dp;
    int[] nums;
    int n, target, totalSum;
    public int solve(int i,int sum) {
        if(i >= n) {
            return sum == target ? 1 : 0;
        }
        if(dp[i][sum+totalSum] != -1) {
            return dp[i][sum+totalSum];
        }
        int inc = solve(i+1,sum+nums[i]);
        int exc = solve(i+1,sum-nums[i]);
        dp[i][sum+totalSum] = (inc + exc);
        return dp[i][sum+totalSum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        n = nums.length;
        for(int num: nums) {
            this.totalSum += num;
        }
        this.dp = new int[n][2*totalSum+1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return solve(0,0);
    }
}

// third method by solving equations


