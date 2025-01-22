class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] height = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else {
                    height[i][j] = -1;
                }

            }
        }

        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] top = q.poll();
            int r = top[0], c = top[1], ht = height[r][c];
            for (int i = 0; i <= 3; i++) {
                int newR = r + dir[i][0];
                int newC = c + dir[i][1];
                if (newR >= 0 && newR < n && newC >= 0 && newC < m && height[newR][newC] == -1) {
                    height[newR][newC] = ht + 1;
                    q.offer(new int[] { newR, newC });
                }
            }
        }
        return height;
    }
}
