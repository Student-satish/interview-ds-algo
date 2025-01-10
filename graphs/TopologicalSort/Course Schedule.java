// using BFS
// if topological sort exist  then there is excatly n nodes in ans otherwise if it has cycle it has less than n nodes


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] course : prerequisites) {
            adjacencyList.get(course[1]).add(course[0]);
            indegree[course[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int course = 0; course < numCourses; course++) {
            if(indegree[course] == 0) {
                q.offer(course);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for(int adjNode : adjacencyList.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        return topo.size() == numCourses ? true : false;
    }
}

// using cycle detection in directed graphs

class Solution {
    public boolean dfs(int node,int[] vis,int[] pathVis,List<List<Integer>> adjacencyList) {
        vis[node] = 1;
        pathVis[node] = 1;
        for(int adjNode : adjacencyList.get(node)) {
            if(vis[adjNode] == 0) {
                if(dfs(adjNode,vis,pathVis,adjacencyList)) {
                    return true;
                }
            }else if(pathVis[adjNode] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create a adjacencyList
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] course : prerequisites) {
            adjacencyList.get(course[1]).add(course[0]);
        }
        int[] vis = new int[numCourses] , pathVis = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(vis[i] == 0) {
                if(dfs(i,vis,pathVis,adjacencyList)) {
                    return false;
                }
            }
        }
        return true;
    }
}
