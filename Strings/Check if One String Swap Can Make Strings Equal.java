class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt = 0, firstDiffIdx = -1, secDiffIdx = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstDiffIdx == -1) {
                    firstDiffIdx = i;
                } else {
                    secDiffIdx = i;
                }
                cnt++;
            }
            if (cnt > 2) {
                return false;
            }
        }
        if (cnt == 0) {
            return true;
        } else if (firstDiffIdx == -1 || secDiffIdx == -1) {
            return false;
        } else if (s1.charAt(firstDiffIdx) == s2.charAt(secDiffIdx)
                && s2.charAt(firstDiffIdx) == s1.charAt(secDiffIdx)) {
            return true;
        }
        return false;
    }
}
