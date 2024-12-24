class Solution {
    public int binarySearch(int target,List<int[]> monoStack) {
        int l = 0 , r = monoStack.size() - 1;
        int ans = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(monoStack.get(mid)[0] > target) {
                l = mid + 1;
                ans = monoStack.get(mid)[1];
            }else{
                r = mid - 1;
    
            }
        }
        return ans;
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = queries.length;
        List<List<int[]>> newQueries = new ArrayList<>();
        for(int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int a = queries[i][0] , b = queries[i][1];
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            ans[i] = ((heights[a] < heights[b]) || a == b) ? b  : -1;
            if(ans[i] == -1) {
                newQueries.get(b).add(new int[]{heights[a],i});
            }
        }
        List<int[]> monoStack = new ArrayList<>();
        for(int i = heights.length -1; i >= 0; i--) {
            for(int[] query : newQueries.get(i)) {
                int target = query[0] , idx = query[1];
                int pos = binarySearch(target,monoStack);
                if(pos != -1) {
                    ans[idx] = pos;
                }
            }
            while(monoStack.size() > 0 && heights[i] >= monoStack.get(monoStack.size()-1)[0]) {
                monoStack.remove(monoStack.size()-1);
            }
            monoStack.add(new int[]{heights[i],i});
        }
        return ans;
    }
}