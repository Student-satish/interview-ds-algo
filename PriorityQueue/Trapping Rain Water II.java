class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length, m = heightMap[0].length;
        int[][] vis = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    vis[i][j] = 1;
                    pq.offer(new int[] { heightMap[i][j], i, j });
                }
            }
        }

        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        int res = 0, level = 0;
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int ht = info[0], r = info[1], c = info[2];
            level = Math.max(level, ht);
            for (int i = 0; i <= 3; i++) {
                int newR = r + dir[i][0];
                int newC = c + dir[i][1];
                if (newR >= 0 && newR < n && newC >= 0 && newC < m && vis[newR][newC] == 0) {
                    res += Math.max((level - heightMap[newR][newC]), 0);
                    vis[newR][newC] = 1;
                    pq.offer(new int[] { heightMap[newR][newC], newR, newC });
                }
            }
        }
        return res;
    }
}
