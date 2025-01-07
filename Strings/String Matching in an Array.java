class Solution {
    public int[] computeLpsArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int i = 1, len = 0;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }

    public boolean isMatch(String sub, String main, int[] lps) {
        int n = sub.length(), m = main.length();
        int subIdx = 0, mainIdx = 0;
        while (mainIdx < m) {
            if (sub.charAt(subIdx) == main.charAt(mainIdx)) {
                subIdx++;
                mainIdx++;
                if (subIdx == n)
                    return true;
            } else {
                if (subIdx > 0) {
                    subIdx = lps[subIdx - 1];
                } else {
                    mainIdx++;
                }
            }
        }
        return false;
    }

    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] lps = computeLpsArray(words[i]);
            for (int j = 0; j < n; j++) {
                if(j == i) continue;
                if (isMatch(words[i], words[j], lps)) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
