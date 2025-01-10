class Solution {
    public boolean isUniversal(int[] charFreq,int[] charFreq1) {
        for(int i = 0; i < 26; i++) {
            if(charFreq1[i] < charFreq[i]) {
                return false;
            }
        }
        return true;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] charFreq = new int[26];
        for(String str : words2) {
            int[] currFreq = new int[26];
            for(int i = 0; i < str.length(); i++) {
                currFreq[str.charAt(i)-'a']++;
            }
            for(int i = 0; i < 26; i++) {
                charFreq[i] = Math.max(charFreq[i],currFreq[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String str : words1) {
            int[] charFreq1 = new int[26];
            for(int i = 0; i < str.length(); i++) {
                charFreq1[str.charAt(i)-'a']++;
            }
            if(isUniversal(charFreq,charFreq1)) {
                ans.add(str);
            }
        }
        return ans;
    }
}
