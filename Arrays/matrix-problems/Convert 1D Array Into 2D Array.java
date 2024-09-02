class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (m * n != len)
            return new int[0][0];
        int[][] ans = new int[m][n];
        int row = -1;
        for (int i = 0; i < len; i++) {
            int col = i % n;
            if (col == 0)
                row++;
            ans[row][col] = original[i];
        }
        return ans;
    }
}