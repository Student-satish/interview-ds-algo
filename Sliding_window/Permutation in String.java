class Solution {
    public boolean isValid(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] > a2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isEqual(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] orgCnt = new int[26];
        for (int i = 0; i < n; i++) {
            orgCnt[s1.charAt(i) - 'a']++;
        }
        int[] currCnt = new int[26];
        int slow = 0, fast = 0;
        while (fast < m) {
            currCnt[s2.charAt(fast) - 'a']++;
            // just slide the window when number of characters becomes excess in curr window than original s1
            if (!isValid(currCnt, orgCnt)) {
                currCnt[s2.charAt(slow) - 'a']--;
                slow++;
            }
            // check if number of characters becomes equal to original s1 in curr window
            if (isEqual(currCnt, orgCnt))
                return true;
            fast++;
        }
        return false;
    }
}