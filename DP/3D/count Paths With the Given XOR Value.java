class Solution {
    int mod = (int) Math.pow(10, 9) + 7;
    int[][] grid;
    int[][][] dp;
    int n, m, k;

    public int f(int i, int j, int currXorVal) {
        if (i >= n || j >= m)
            return 0;

        currXorVal = currXorVal ^ grid[i][j];

        if (i == n - 1 && j == m - 1) {
            return currXorVal == k ? 1 : 0;
        }

        if (dp[i][j][currXorVal] != -1) {
            return dp[i][j][currXorVal];
        }

        int right = f(i, j + 1, currXorVal);
        int down = f(i + 1, j, currXorVal);
        dp[i][j][currXorVal] = (right + down) % mod;
        return dp[i][j][currXorVal];
    }

    public int countPathsWithXorValue(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        this.k = k;
        this.grid = grid;
        this.dp = new int[n][m][16];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return f(0, 0, 0);
    }
}
