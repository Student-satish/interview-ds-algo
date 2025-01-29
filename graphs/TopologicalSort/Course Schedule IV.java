// dfs

class Solution {
    public boolean dfs(int src, int dest, boolean[] vis, List<List<Integer>> adjacencyList) {
        vis[src] = true;
        if (src == dest)
            return true;
        for (int adjNode : adjacencyList.get(src)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, dest, vis, adjacencyList))
                    return true;
            }
        }
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacencyList.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0], b = prerequisite[1];
            adjacencyList.get(a).add(b);
        }

        int n = queries.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int u = queries[i][0], v = queries[i][1];
            ans.add(dfs(u, v, new boolean[numCourses], adjacencyList));
        }
        return ans;
    }
}

// topological sort
class Solution {
    public void dfs(int node, boolean[] vis, Stack<Integer> topoSort, List<List<Integer>> adjacencyList) {
        vis[node] = true;
        for (int adjNode : adjacencyList.get(node)) {
            if (!vis[adjNode])
                dfs(adjNode, vis, topoSort, adjacencyList);
        }
        topoSort.push(node);
    }

    public void dfs1(int prerequisite, int node, boolean[] vis,HashMap<Integer, HashSet<Integer>> map,
            List<List<Integer>> adjacencyList) {
                vis[node] = true;
        for (int adjNode : adjacencyList.get(node)) {
            if(!vis[adjNode]) {
                map.get(adjNode).add(prerequisite);
                dfs1(prerequisite, adjNode, vis, map, adjacencyList);
            }
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacencyList.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0], b = prerequisite[1];
            adjacencyList.get(a).add(b);
        }

        Stack<Integer> topoSort = new Stack<>();

        boolean[] vis = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                dfs(i, vis, topoSort, adjacencyList);
            }
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            map.put(i, new HashSet<>());

        while (!topoSort.isEmpty()) {
            int node = topoSort.pop();
            dfs1(node, node, new boolean[numCourses], map, adjacencyList);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (map.get(v).contains(u)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;

    }
}