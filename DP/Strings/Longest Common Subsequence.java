

// explanation

// case - 1 : if ith char in s1 and jth char in s2 are matching add 1 and go forward;
// case - 2 : if ith char in s1 and jth char in s2 are not matching 
// example : s1 - > bcde , s2 -> ce then we will take max((bcde in e) and (ce in cde))

// memoization
// here two variable are changing i - > (0 to n - 1) and j (0 to m - 1) so we create dp array of size new int[n][m]
import java.util.*;
class Solution {
    public int solve(int i, int j, String text1, String text2,int[][] dp) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + solve(i + 1, j + 1, text1, text2,dp);
        } else {
            return dp[i][j] = Math.max(solve(i + 1, j, text1, text2,dp), solve(i, j + 1, text1, text2,dp));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, 0, text1, text2,dp);
    }
}
