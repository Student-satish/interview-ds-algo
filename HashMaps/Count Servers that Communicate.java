class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (rowCnt[i] > 1 || colCnt[j] > 1)) {
                    res++;
                }
            }
        }

        return res;
    }
}