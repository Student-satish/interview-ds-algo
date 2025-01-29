class Solution {
    class DisjointSet {
        int[] par;
        int[] size;

        public DisjointSet(int n) {
            this.par = new int[n + 1];
            this.size = new int[n + 1];
            Arrays.fill(size, 1);
            for (int i = 0; i <= n; i++)
                par[i] = i;
        }

        public int findUPar(int x) {
            if (par[x] == x)
                return x;
            return par[x] = findUPar(par[x]);
        }

        public void unionBySize(int u, int v) {
            int u_u = findUPar(u);
            int u_v = findUPar(v);
            if (size[u_u] >= size[u_v]) {
                par[u_v] = u_u;
                size[u_u] += size[u_v];
            } else {
                par[u_u] = u_v;
                size[u_v] += size[u_u];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet set = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (set.findUPar(u) == set.findUPar(v)) {
                return new int[] { u, v };
            }
            set.unionBySize(u, v);
        }
        return new int[0];
    }
}