class Solution {
    public int solve(long curr, long next, int n) {
        int countNum = 0;
        while (curr <= n) {
            // it will find total count between two prefixes at current level
            countNum += next - curr;
            // moving to next level where every node have 10 children
            curr *= 10;
            next *= 10;
            // here when next crosses more than n we will take upper limit as n + 1
            next = Math.min(next, n + 1);
        }
        return countNum;
    }

    public int findKthNumber(int n, int k) {
        long curr = 1;
        while (k > 1) {
            // total numbers that are lesser than n between curr and curr + 1 but only starting with curr prefix
            int count = solve(curr, curr + 1, n);
            if (count < k) {
                // that means ans exist in next prefix we will do curr + 1 which is next prefix
                k -= count;
                curr++;
            } else {
                // case when ans exist same prefix tree we will remove curr number and we will come down by multiplying with 10
                curr *= 10;
                k -= 1;
            }
        }
        return (int)curr;
    }
}