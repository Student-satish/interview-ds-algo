
// Brute force


class Solution {
    int n;
    int[][] dir;
    public int dfs(int r,int c,boolean[][] vis,int[][] grid) {
        vis[r][c] = true;
        int size = 1;
        for(int i = 0; i < 4; i++) {
            int nextR = r + dir[i][0];
            int nextC = c + dir[i][1];
            if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !vis[nextR][nextC] && grid[nextR][nextC] != 0) {
                size += dfs(nextR,nextC,vis,grid);
            }
        }
        return size;
    }
    public int maxAreaFromAllIslands(int[][] grid) {
        int maxArea = 0;
        boolean[][] vis = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea,dfs(i,j,vis,grid));
                }
                
            }
        }
        return maxArea;
    }
    public int largestIsland(int[][] grid) {
        this.n = grid.length;
        this.dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int maxArea = maxAreaFromAllIslands(grid);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    grid[i][j] = 1;
                    maxArea = Math.max(maxArea,maxAreaFromAllIslands(grid));
                    grid[i][j] = 0;
                }

            }
        }
        return maxArea;
    }
}


// optimal

class Solution {
    class DisjointSet {
        int[] par;
        int[] size;

        public DisjointSet(int n) {
            this.par = new int[n];
            this.size = new int[n];
        }

        public int findUPar(int x) {
            if (par[x] == x)
                return x;
            return par[x] = findUPar(par[x]);
        }

        public void unionBySize(int u, int v) {
            int u_u = findUPar(u);
            int u_v = findUPar(v);
            if (u_u != u_v) {
                if (size[u_u] >= size[u_v]) {
                    size[u_u] += size[u_v];
                    par[u_v] = u_u;
                } else {
                    size[u_v] += size[u_u];
                    par[u_u] = u_v;
                }
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet set = new DisjointSet(n * n);
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < n * n; i++) {
            set.par[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                set.size[k] = grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int u = i * n + j;
                    for (int k = 0; k < 4; k++) {
                        int nextR = i + dir[k][0];
                        int nextC = j + dir[k][1];
                        if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && grid[nextR][nextC] == 1) {
                            int v = nextR * n + nextC;
                            set.unionBySize(u,v);
                        }
                    }
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> st = new HashSet<>();
                    int size = 1;
                    for (int k = 0; k < 4; k++) {
                        int nextR = i + dir[k][0];
                        int nextC = j + dir[k][1];
                        if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && grid[nextR][nextC] == 1) {
                            int parent = set.findUPar(nextR * n + nextC);
                            if (!st.contains(parent)) {
                                size += set.size[parent];
                                st.add(parent);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, size);
                }
            }
        }

        return maxArea == 0 ? n * n : maxArea;

    }
}