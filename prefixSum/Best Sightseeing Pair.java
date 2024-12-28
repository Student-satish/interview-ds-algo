class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] suffixMax = new int[n];
        suffixMax[0] = values[0];
        for(int i = 1; i < n; i++) {
            suffixMax[i] = Math.max(suffixMax[i-1],values[i]+i);
        }
        int maxPairScore = Integer.MIN_VALUE;
        for(int j = 1; j < n; j++) {
            maxPairScore = Math.max(maxPairScore,values[j]-j + suffixMax[j-1]);
        }
        return maxPairScore;
    }
}

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxLeftScore = values[0] , maxPairScore = Integer.MIN_VALUE;
        for(int i = 1; i < values.length; i++) {
            maxPairScore = Math.max(maxPairScore,maxLeftScore+values[i]-i);
            maxLeftScore = Math.max(maxLeftScore,values[i]+i);
        }
        return maxPairScore;
    }
}
