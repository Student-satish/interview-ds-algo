class Solution {
    int n;
    int[] dp;

    public int getNextDay(int idx, int passNo, int[] days) {
        int maxDay = days[idx] + passNo;
        for (int j = idx; j < n; j++) {
            if (days[j] >= maxDay) {
                return j;
            }
        }
        return n;
    }

    public int solve(int i, int[] days, int[] costs) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int oneDayPass = costs[0] + solve(getNextDay(i, 1, days), days, costs);
        int sevenDayPass = costs[1] + solve(getNextDay(i, 7, days), days, costs);
        int thirtyDayPass = costs[2] + solve(getNextDay(i, 30, days), days, costs);
        return dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }

    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, days, costs);
    }
}
