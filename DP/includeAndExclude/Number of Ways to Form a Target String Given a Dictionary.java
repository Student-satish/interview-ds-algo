class Solution {
    int mod = (int) Math.pow(10, 9) + 7;
    int n, m;
    String target;
    int[][] charFreq;
    int[][] dp;

    public int solve(int i, int j) {
        if (j == m)
            return 1;
        if (i == n)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int pos = target.charAt(j) - 'a';
        int pick = (int)((1L * charFreq[i][pos] * solve(i+1,j+1)) % mod);
        int nonPick = solve(i + 1, j) % mod;
        return dp[i][j] = (pick + nonPick) % mod;
    }

    public int numWays(String[] words, String target) {
        int wordsLen = words.length, eachWordLen = words[0].length();
        charFreq = new int[eachWordLen][26];
        for (int i = 0; i < eachWordLen; i++) {
            for (int j = 0; j < wordsLen; j++) {
                int pos = words[j].charAt(i) - 'a';
                charFreq[i][pos]++;
            }
        }
        n = charFreq.length;
        m = target.length();
        this.target = target;
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0);
    }
}
