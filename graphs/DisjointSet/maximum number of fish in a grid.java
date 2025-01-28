// dfs
class Solution {
    int n,m;
    public int dfs(int r,int c,int[][] grid,boolean[][] vis) {
        if(grid[r][c] == 0) {
            return 0;
        }
        vis[r][c] = true;
        int totFish = grid[r][c];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i <= 3; i++) {
            int nextR = r + dir[i][0];
            int nextC = c + dir[i][1];
            if(nextR >= 0 && nextC >= 0 && nextR < n && nextC < m && !vis[nextR][nextC]) {
                totFish += dfs(nextR,nextC,grid,vis);
            }
        }
        return totFish;
    }
    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int maxFish = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0 && !vis[i][j]) {
                    maxFish = Math.max(maxFish,dfs(i,j,grid,vis));
                }
            }
        }
        return maxFish;
    }
}

// bfs


class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int maxFish = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0 && !vis[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                    int fish = 0;
                    while(!q.isEmpty()) {
                        int[] cell = q.poll();
                        int r = cell[0] , c = cell[1];
                        fish += grid[r][c];
                        for(int k = 0; k <= 3; k++) {
                            int nextR = r + dir[k][0];
                            int nextC = c + dir[k][1];
                            if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && !vis[nextR][nextC] && grid[nextR][nextC] != 0) {
                                q.offer(new int[]{nextR,nextC});
                                vis[nextR][nextC] = true;
                            }
                        }
                    }
                    maxFish = Math.max(maxFish,fish);
                }
            }
        }
        return maxFish;
    }
}


// disjointset

class Solution {
    class DisjointSet {
        int[] par;
        int[] size;
        int[] totFish;

        public DisjointSet(int n) {
            par = new int[n];
            size = new int[n];
            totFish = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }

        public int findUPar(int x) {
            if (par[x] == x) {
                return x;
            }
            return par[x] = findUPar(par[x]);
        }

        public void unionBySize(int u, int v) {
            int u_u = findUPar(u);
            int u_v = findUPar(v);

            if (size[u_u] >= size[u_v]) {
                par[u_v] = u_u;
                size[u_u] += size[u_v];
                totFish[u_u] += totFish[u_v];
            } else {
                par[u_u] = u_v;
                size[u_v] += size[u_u];
                totFish[u_v] += totFish[u_u];
            }
        }
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        DisjointSet s = new DisjointSet(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = i * m + j;
                s.totFish[k] = grid[i][j];
            }
        }
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u = i * m + j;
                if (grid[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextR = i + dir[k][0];
                        int nextC = j + dir[k][1];
                        if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && grid[nextR][nextC] != 0) {
                            int v = nextR * m + nextC;
                            if (s.findUPar(u) != s.findUPar(v)) {
                                s.unionBySize(u, v);
                            }
                        }
                    }
                }

            }
        }

        int maxFish = 0;
        for (int i = 0; i < n * m; i++) {
            maxFish = Math.max(maxFish, s.totFish[i]);
        }

        return maxFish;

    }
}