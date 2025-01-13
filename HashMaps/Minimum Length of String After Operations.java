class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] charFreq = new int[26];
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            charFreq[ch-'a']++;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if(charFreq[i] > 0) {
                ans += charFreq[i] % 2 == 0 ? 2 : 1;
            }
        }
        return ans;
    }
}
