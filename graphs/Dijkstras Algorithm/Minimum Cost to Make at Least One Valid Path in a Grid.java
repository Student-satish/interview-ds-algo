class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] minCost = new int[n][m];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0, 0 });
        minCost[0][0] = 0;
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int i = info[0], j = info[1], cost = info[2];
            if (i == n - 1 && j == m - 1) {
                return cost;
            }
            for (int k = 0; k <= 3; k++) {
                int dirCost = 0;
                int nextRow = i + dir[k][0];
                int nextCol = j + dir[k][1];
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                    if (grid[i][j] != k + 1)
                        dirCost++;
                    int newCost = cost + dirCost;
                    if (minCost[nextRow][nextCol] > newCost) {
                        minCost[nextRow][nextCol] = newCost;
                        pq.offer(new int[] { nextRow, nextCol, newCost });
                    }
                }
            }
        }
        return minCost[n-1][m-1];
    }
}
