class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs =((long)n * (n - 1))/ 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        long cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            int target = nums[i] - i;
            cnt += map.getOrDefault(target,0);
            map.put(target,map.getOrDefault(target,0) + 1);
        }
        return totalPairs - cnt;
        
    }
}