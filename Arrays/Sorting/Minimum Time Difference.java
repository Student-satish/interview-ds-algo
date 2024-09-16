import java.util.*;
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] min = new int[n];
        for(int i = 0; i < n; i++) {
            // first convert hh:mm to minutes 
            String s = timePoints.get(i);
            int a = s.charAt(0) - '0' , b = s.charAt(1) - '0' , c = s.charAt(3) - '0' , d = s.charAt(4) - '0';
            int hours = a * 10 + b , minutes = c * 10 + d;
            min[i] = hours * 60 + minutes;
        }
        Arrays.sort(min);
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            result = Math.min(result,Math.min((min[i+1]-min[i]),1440-(min[i+1]-min[i])));
        }
        result = Math.min(result,Math.min((min[n-1]-min[0]),1440-(min[n-1]-min[0])));
        return result;   
    }
}
