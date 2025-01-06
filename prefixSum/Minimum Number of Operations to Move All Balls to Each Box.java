class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for(int i = 0; i < n;i++) {
            for(int j = 0; j < n; j++) {
                if(boxes.charAt(j) == '1') {
                    ans[i] += Math.abs(i-j);
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        // prefix sum
        int balls = 0 , moves = 0;
        for(int i = 0; i < n; i++) {
            moves += balls;
            ans[i] = moves;
            if(boxes.charAt(i) == '1') {
                balls++;
            }
        }
        balls = 0;
        moves = 0;
        // suffix sum
        for(int i =  n - 1; i >= 0; i--) {
            moves += balls;
            ans[i] += moves;
            if(boxes.charAt(i) == '1') {
                balls++;
            }
        }
        return ans;
    }
}
