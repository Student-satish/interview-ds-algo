class Solution {
    public int maxChunksToSorted(int[] arr) {
        int prefixSum = 0 , sortedSum = 0 , ans = 0;
        for(int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            sortedSum += i;
            if(prefixSum == sortedSum) {
                ans++;
            }
        }
        return ans;
    }
}