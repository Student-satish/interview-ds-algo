// what is the  question ?
// given two strings s1 and s2 and we have to check whether s2 exist as subsequence in s1 or not
// conditions
// in one operation we can select any indices of s1 replace those characters to next lexocographical characters in cycle
// we can perform at most one operation
// idea
// two pointers










class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length() , m = str2.length();
        int i = 0 , j = 0;
        while(i < n && j < m) {
            char x1 = str1.charAt(i) , x2 = str2.charAt(j);
            char nextChar = (char)((x1 - 'a' + 1) % 26 + 97);
            if(x1 == x2 || nextChar == x2) {
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j >= m ? true : false;
    }
}