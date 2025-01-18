// just add those nodes to result which are not involved in cycle

class Solution {
    public boolean isCycle(int node,int[] vis,int[] pathVis,int[][] graph) {
        vis[node] = 1;
        pathVis[node] = 1;
        for(int adjNode : graph[node]) {
            if(vis[adjNode] == 0) {
                if(isCycle(adjNode,vis,pathVis,graph)) {
                    return true;
                }
            }else if(pathVis[adjNode] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        for(int i = 0; i < n ;i++) {
            if(vis[i] == 0) {
                isCycle(i,vis,pathVis,graph);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(pathVis[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
