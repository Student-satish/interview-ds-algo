import java.util.*;
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;
        String[] words = s.split(" ");
        HashMap<String, Integer> mp = new HashMap<>();
        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String word : mp.keySet()) {
            if (mp.get(word) == 1)
                res.add(word);
        }
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;

    }
}