import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        // here we custom sorting based on concatenation of two strings
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        // when an array contains all zeroes
        if (arr[0].equals("0"))
            return "0";
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }
        return result.toString();
    }
}