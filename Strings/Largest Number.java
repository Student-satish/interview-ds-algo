import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        // int result = (b + a).compareTo(a + b);
        // result is positve a comes after b
        // result is negative a comes before b
        // result is positve both strings are same
        // ["3","30"]
        // a = 3
        // b = 30
        // b+a = 303 , a + b = 330 , (b+a < a+b) result becomes negative
        // result is negative that means [b,a] forms less number than [a,b] so a comes before b which is [a,b];
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