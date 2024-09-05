import java.util.*;
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int num : rolls) {
            sum += num;
        }
        int remSum =  ((n + m) * mean) - sum;
        if(n > remSum || 6 * n < remSum) return new int[0];
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        remSum -= n;
        int i = 0;
        while(remSum > 0) {
            if(remSum > 5) {
                ans[i] += 5;
                remSum -= 5;
                i++;
            }else {
                ans[i] += remSum;
                remSum = 0;
            }
        }
        return ans;
    }
}