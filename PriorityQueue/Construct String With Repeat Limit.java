
import java.util.*;
class Solution {
    class Pair implements Comparable<Pair> {
        char ch;
        int cnt;

        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair other) {
            return other.ch - this.ch;
        }
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int n = s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] charFreq = new int[26];
        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] > 0) {
                pq.offer(new Pair((char) (i + 97), charFreq[i]));
            }
        }
        StringBuilder ans = new StringBuilder();
        Pair temp = pq.poll();
        for (int i = 0; i < Math.min(temp.cnt, repeatLimit); i++) {
            ans.append(temp.ch);
        }
        if (temp.cnt > repeatLimit) {
            pq.offer(new Pair(temp.ch, temp.cnt - repeatLimit));
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            char ch = p.ch;
            int cnt = p.cnt;
            if (ans.charAt(ans.length() - 1) != ch) {
                for (int i = 0; i < Math.min(repeatLimit, cnt); i++) {
                    ans.append(ch);
                }
                if (cnt > repeatLimit) {
                    pq.offer(new Pair(ch, cnt - repeatLimit));
                }
            } else {
                if (pq.size() == 0) {
                    break;
                }
                Pair p1 = pq.poll();
                char ch1 = p1.ch;
                int cnt1 = p1.cnt;
                ans.append(ch1);
                if (cnt1 > 1) {
                    pq.offer(new Pair(ch1, cnt1 - 1));
                }
                pq.offer(p);
            }
        }
        return ans.toString();
    }
}
