class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        HashMap<Integer,Integer> colorCnt = new HashMap<>();
        HashMap<Integer,Integer> ballToColor = new HashMap<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(ballToColor.containsKey(ball)){
                int prevColor = ballToColor.get(ball);
                colorCnt.put(prevColor,colorCnt.get(prevColor)-1);
                if(colorCnt.get(prevColor) == 0){
                    colorCnt.remove(prevColor);
                }
            }
            colorCnt.put(color,colorCnt.getOrDefault(color,0)+1);
            ballToColor.put(ball,color);
            ans[i] = colorCnt.size();
        }
        return ans;
    }
}