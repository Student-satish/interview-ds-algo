class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }

        int[] row = new int[n];
        Arrays.fill(row, m);
        int[] col = new int[m];
        Arrays.fill(col, n);
        for (int i = 0; i < n * m; i++) {
            int[] pos = map.get(arr[i]);
            int r = pos[0], c = pos[1];
            row[r]--;
            col[c]--;
            if (row[r] == 0 || col[c] == 0) {
                return i;
            }
        }

        return -1;

    }
}
