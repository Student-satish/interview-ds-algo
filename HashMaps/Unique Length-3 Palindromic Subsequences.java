// store first occurence and lastOccurence of that character count unique characters in between these indexes
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstOccur = new int[26];
        int[] lastOccur = new int[26];
        Arrays.fill(firstOccur,-1);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(firstOccur[ch-'a'] == -1) {
                firstOccur[ch-'a'] = i;
            }
            lastOccur[ch-'a'] = i;
        }
        int ans = 0;
        for(char ch = 'a'; ch <= 'z'; ch++) {
            HashSet<Character> between = new HashSet<>();
            int firstIdx = firstOccur[ch-'a'] , lastIdx = lastOccur[ch-'a'];
            for(int i = firstIdx + 1; i < lastIdx; i++) {
                between.add(s.charAt(i));
            }
            ans += between.size();
        }
        return ans;
    }
}
