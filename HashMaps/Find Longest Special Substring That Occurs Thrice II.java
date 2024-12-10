import java.util.*; 
// brute force -> o(n^3)
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringBuilder curr = new StringBuilder();
            for(int j = i; j < n; j++) {
                if(s.charAt(i) != s.charAt(j)) {
                    break;
                }
                curr.append(s.charAt(j));
                String temp = curr.toString();
                mp.put(temp,mp.getOrDefault(temp,0)+1);
            }
        }
        int len = -1;
        for(String t : mp.keySet()) {
            if(mp.get(t) >= 3) {
                len = Math.max(len,t.length());
            }
        }
        return len;
    }
}





// optimial -> o(n)
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<Integer, Integer>[] freq = new HashMap[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new HashMap<>();
        }
        int i = 0;
        while (i < n) {
            char curr = s.charAt(i);
            int len = 0;
            while (i < n && s.charAt(i) == curr) {
                len++;
                i++;
            }
            HashMap<Integer, Integer> mp = freq[curr - 'a'];
            for (int j = 1; j <= len; j++) {
                mp.put(j, mp.getOrDefault(j, 0) + len - j + 1);
            }
        }
        int len = -1;
        for (int j = 0; j < 26; j++) {
            HashMap<Integer, Integer> mp = freq[j];
            for (int x : mp.keySet()) {
                if (mp.get(x) >= 3) {
                    len = Math.max(len, x);
                }
            }
        }
        return len;
    }
}
