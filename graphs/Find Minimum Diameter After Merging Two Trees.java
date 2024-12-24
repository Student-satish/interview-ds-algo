import java.util.*;
class Solution {
    public void makeGraph(int n,int[][] edges,List<List<Integer>> graph) {
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    public int findDiameter(int node,int n,List<List<Integer>> graph) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        int depth = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int currNode = q.poll();
                for(int adjNode : graph.get(currNode)) {
                    if(!vis[adjNode]) {
                        vis[adjNode] = true;
                        q.offer(adjNode);
                    }
                }

            }
            depth++;
        }
        return depth;
    }
    public int getFarthestNode(int n,List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int extremeNode = 0;
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < n; i++) {
                int node = q.poll();
                extremeNode = node;
                for(int adjNode : graph.get(node)) {
                    if(!vis[adjNode]) {
                        vis[adjNode] = true;
                        q.offer(adjNode);
                    }
                }
            }
        }
        return extremeNode;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // logic
        // if we join two trees through extreme nodes diameter will be larger
        // so try to join two trees through middle nodes diameter will be minimized

        // For graph1
        int n = edges1.length + 1;
        List<List<Integer>> graph1 = new ArrayList<>();
        makeGraph(n,edges1,graph1);
        int firstExtremeNode = getFarthestNode(n,graph1);
        int diam1 = findDiameter(firstExtremeNode,n,graph1);


        // For graph2
        int m = edges2.length + 1;
        List<List<Integer>> graph2 = new ArrayList<>();
        makeGraph(m,edges2,graph2);
        int seconExtremeNode = getFarthestNode(m,graph2);
        int diam2 = findDiameter(seconExtremeNode,m,graph2);


        return Math.max(diam1,Math.max(diam2,1 + (int)Math.ceil(diam1 / 2.0) + (int)Math.ceil(diam2/2.0)));
    }
}
