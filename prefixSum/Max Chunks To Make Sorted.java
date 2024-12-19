class Solution {
    public int maxChunksToSorted(int[] arr) {
        int prefixSum = 0 , sortedPrefixSum = 0 , ans = 0;
        for(int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            sortedPrefixSum += i;
            if(prefixSum == sortedPrefixSum) {
                ans++;
            }
        }
        return ans;
    }
}