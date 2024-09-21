import java.util.*;
// brute force
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        // find the longest palindrome prefix
        for(int i = 0; i < n; i++) {
            if(s.startsWith(rev.substring(i))) {
                return rev.substring(0,i) + s;
            }
        }
        return "";
    }
}
// using kmp alogorithm
class Classroom {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = "";
        for(int i = n - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        String pattern = s + "*" + rev;
        int m = pattern.length();
        // lps[i] means longest prefix suffix equal from 0 to i;
        int[] lps = new int[m];
        int i = 1 , len = 0;
        while(i < m) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                lps[i] = len + 1;
                len++;
                i++;
            }else {
                if(len > 0) {
                    len = lps[len-1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        String result = "";
        for(int k = n - 1; k >= lps[m-1]; k--) {
            result += s.charAt(k);
        }
        result += s;
        return result;
    }
}