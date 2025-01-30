class Solution {
    public boolean isBipartite(int start, int[] color, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int nd = q.poll();
            for (int adjNode : graph.get(nd)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = color[nd] ^ 1;
                    q.offer(adjNode);
                } else {
                    if (color[adjNode] == color[nd])
                        return false;
                }
            }
        }
        return true;
    }

    public int maxDepth(int start, int n, List<List<Integer>> graph) {
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis[start] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int nd = q.poll();
                for (int adjNode : graph.get(nd)) {
                    if (!vis[adjNode]) {
                        q.offer(adjNode);
                        vis[adjNode] = true;
                    }
                }
            }
            level++;
        }
        return level;
    }

    public int getMaxFromEachComp(int node, int[] maxLevel, boolean[] vis, List<List<Integer>> graph) {
        vis[node] = true;
        int max = maxLevel[node];
        for (int adjNode : graph.get(node)) {
            if (!vis[adjNode]) {
                max = Math.max(max, getMaxFromEachComp(adjNode, maxLevel, vis, graph));
            }
        }
        return max;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!isBipartite(i, color, graph)) {
                    return -1;
                }
            }
        }

        int[] maxLevel = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            maxLevel[i] = maxDepth(i, n, graph);
        }

        boolean[] vis = new boolean[n + 1];
        int maxGroupsFromEachComp = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                maxGroupsFromEachComp += getMaxFromEachComp(i, maxLevel, vis, graph);
            }
        }
        return maxGroupsFromEachComp;
    }
}