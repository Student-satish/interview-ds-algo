class Solution {
    public boolean canAllReachZero(int n, List<List<int[]>> adjacencyList, int target) {
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = 1;
        while(!q.isEmpty()) {
            int top = q.poll();
            for(int[] info : adjacencyList.get(top)) {
                int adjNode = info[0] , wt = info[1];
                if(vis[adjNode] == 0 && wt <= target) {
                    vis[adjNode] = 1;
                    q.offer(adjNode);
                }
            }
        }
        for(int i = 1; i < n; i++) {
            if(vis[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public int minMaxWeight(int n, int[][] edges, int threshold) {
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // reverse all edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adjacencyList.get(v).add(new int[]{u,wt});
        }


        int right = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            right = Math.max(right, edge[2]);
            left = Math.min(left, edge[2]);
        }
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAllReachZero(n, adjacencyList, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
